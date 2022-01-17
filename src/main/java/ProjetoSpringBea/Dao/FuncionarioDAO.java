package ProjetoSpringBea.Dao;

import ProjetoSpringBea.Connection.ConnectionFactory;
import ProjetoSpringBea.Domain.Funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {

    public List<Funcionario> listAllColaboradores() {
        List<Funcionario> funcionarios = new ArrayList<>();
        try (Connection connection = new ConnectionFactory().recuperarConexao()) {
            PreparedStatement stm = connection.prepareStatement("SELECT id, nome,"
                    + " idade, setor FROM funcionario");
            stm.executeQuery();
            ResultSet rst = stm.getResultSet();
            while (rst.next()) {
                int codigoColaborador = rst.getInt("id");
                String nomecolaborador = rst.getString("nome");
                int datanascimento = rst.getInt("idade");
                String setor = rst.getString("setor");
                Funcionario funcionario = new Funcionario(id, nome, idade, setor);
                funcionarios.add(funcionario);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return colaboradores;
    }
}
