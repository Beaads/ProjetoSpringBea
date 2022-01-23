package ProjetoSpringBea.Dao;
import ProjetoSpringBea.Connection.ConnectionFactory;
import ProjetoSpringBea.Domain.ClienteQueMaisComprou;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteQueMaisComprouDAO {

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
}
