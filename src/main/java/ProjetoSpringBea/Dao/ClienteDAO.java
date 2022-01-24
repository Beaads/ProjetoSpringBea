package ProjetoSpringBea.Dao;
import ProjetoSpringBea.Connection.ConnectionFactory;
import ProjetoSpringBea.Domain.Cliente;
import ProjetoSpringBea.Domain.ClienteQueMaisComprou;
import ProjetoSpringBea.Domain.VendaProduto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public List<ClienteQueMaisComprou> listaCliente() {
        List<ClienteQueMaisComprou> clientes = new ArrayList<>();
        try (Connection connection = new ConnectionFactory().recuperarConexao()) {
            PreparedStatement stm = connection.prepareStatement("SELECT SUM(VP.QUANTIDADE) AS QUANTIDADE, C.NOME " +
                    "FROM VENDAPRODUTO VP " +
                    "INNER JOIN CLIENTE C ON VP.IDCLIENTE = C.IDCLIENTE " +
                    "GROUP BY C.NOME " +
                    "ORDER BY SUM(VP.QUANTIDADE) desc");
            stm.executeQuery();
            ResultSet rst = stm.getResultSet();
            while (rst.next()) {
                String nomeCliente = rst.getString("nome");
                int quantidade = rst.getInt("quantidade");
                ClienteQueMaisComprou clienteQueMaisComprou = new ClienteQueMaisComprou(nomeCliente, quantidade);
                clientes.add(clienteQueMaisComprou);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    public Cliente getClienteById(int idCliente) {
        try(Connection connection = new ConnectionFactory().recuperarConexao()) {
            PreparedStatement validClient = connection.prepareStatement("SELECT idcliente, idade, nome, valorparagastar FROM CLIENTE WHERE idCliente = ?");
            validClient.setInt(1, idCliente);
            validClient.executeQuery();
            ResultSet resultClient = validClient.getResultSet();
            while(resultClient.next()) {
                Cliente cliente = new Cliente(idCliente,
                        resultClient.getInt("idade"),
                        resultClient.getString("nome"),
                resultClient.getInt("valorParaGastar"));
                return cliente;
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Cliente updateValorParaGastar(int idCliente) {
        try(Connection connection = new ConnectionFactory().recuperarConexao()) {
            PreparedStatement updateSaldoCliente = connection.prepareStatement("UPDATE CLIENTE SET valorParaGastar = ? WHERE idCliente = ?");
            updateSaldoCliente.setInt(1, ( valorClient - precoTotal));
            updateSaldoCliente.setInt(2, idCliente);

            updateSaldoCliente.execute();

    } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
