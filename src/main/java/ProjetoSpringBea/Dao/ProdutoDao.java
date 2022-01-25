package ProjetoSpringBea.Dao;

import ProjetoSpringBea.Connection.ConnectionFactory;
import ProjetoSpringBea.Domain.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdutoDao {

    public Produto getProdutoById(int idProduto) {
        try (Connection connection = new ConnectionFactory().recuperarConexao()) {
            PreparedStatement validProd = connection.prepareStatement("SELECT idProduto, nome, quantidade, preco FROM PRODUTO WHERE idProduto = ?");
            validProd.setInt(1, idProduto);
            validProd.executeQuery();
            ResultSet resultProduct = validProd.getResultSet();
            while (resultProduct.next()) {
                Produto produto = new Produto(idProduto,
                        resultProduct.getString("nome"),
                        resultProduct.getInt("quantidade"),
                        resultProduct.getInt("preco"));
                return produto;
            }

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void updateQuantidadeProduto(Produto produto, int quantidade) {
        try (Connection connection = new ConnectionFactory().recuperarConexao()) {
            PreparedStatement updateQuantidadeProdutos = connection.prepareStatement("UPDATE PRODUTO SET quantidade = ? WHERE idProduto = ?");
            updateQuantidadeProdutos.setInt(1, (produto.getQuantidade() - quantidade));
            updateQuantidadeProdutos.setInt(2, produto.getIdProduto());
            updateQuantidadeProdutos.execute();
    } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
}
