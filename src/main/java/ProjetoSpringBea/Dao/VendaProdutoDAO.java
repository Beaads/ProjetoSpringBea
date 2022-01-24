package ProjetoSpringBea.Dao;

import ProjetoSpringBea.Connection.ConnectionFactory;
import ProjetoSpringBea.Domain.VendaProduto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class VendaProdutoDAO {

    public List<VendaProduto> listAllVendaProduto() {
        List<VendaProduto> vendas = new ArrayList<>();
        try (Connection connection = new ConnectionFactory().recuperarConexao()) {
            PreparedStatement stm = connection.prepareStatement("SELECT numerodavenda, idProduto,"
                    + " idCliente, idFuncionario, Quantidade FROM VENDAPRODUTO");
            stm.executeQuery();
            ResultSet rst = stm.getResultSet();
            while (rst.next()) {
                int numerodavenda = rst.getInt("numerodavenda");
                int idProduto = rst.getInt("idProduto");
                int idCliente = rst.getInt("idCliente");
                int idFuncionario = rst.getInt("idFuncionario");
                int Quantidade = rst.getInt("Quantidade");
                VendaProduto vendaProduto = new VendaProduto(numerodavenda, idProduto, idCliente, idFuncionario, Quantidade);
                vendas.add(vendaProduto);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return vendas;
    }

    public VendaProduto findByIdVenda(int idVenda) {
        try (Connection connection = new ConnectionFactory().recuperarConexao()) {
            PreparedStatement stm = connection.prepareStatement("SELECT idProduto,"
                    + " idCliente, idFuncionario, Quantidade FROM VENDAPRODUTO WHERE numerodavenda = (?)");
            stm.setInt(1, idVenda);
            stm.executeQuery();
            ResultSet rst = stm.getResultSet();
            while (rst.next()) {
                int idProduto = rst.getInt("idProduto");
                int idCliente = rst.getInt("idCliente");
                int idFuncionario = rst.getInt("idFuncionario");
                int Quantidade = rst.getInt("Quantidade");
                VendaProduto vendaProduto = new VendaProduto(idVenda, idProduto, idCliente, idFuncionario, Quantidade);
                return vendaProduto;
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public VendaProduto cadastrarVenda(VendaProduto vendaProduto) {
        try (Connection connection = new ConnectionFactory().recuperarConexao()) {
                PreparedStatement stm = connection.prepareStatement("INSERT INTO VENDAPRODUTO (" +
                        "IDPRODUTO, IDCLIENTE, IDFUNCIONARIO, QUANTIDADE) VALUES (?, ?, ?, ?) RETURNING numeroDaVenda");
                stm.setInt(1, vendaProduto.getIdProduto());
                stm.setInt(2, vendaProduto.getIdCliente());
                stm.setInt(3, vendaProduto.getIdFuncionario());
                stm.setInt(4, vendaProduto.getQuantidade());

                ResultSet rst = stm.getResultSet();
                int idVenda = 0;
                while(rst.next()) {
                    idVenda = rst.getInt("numeroDaVenda");
                }

                vendaProduto.setIdVenda(idVenda);
                return vendaProduto;
            } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
