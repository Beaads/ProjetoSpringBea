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
            PreparedStatement stm = connection.prepareStatement("SELECT idFuncionario, nome,"
                    + " idade, setor FROM funcionario");
            stm.executeQuery();
            ResultSet rst = stm.getResultSet();
            while (rst.next()) {
                int idFuncionario = rst.getInt("idFuncionario");
                String nome = rst.getString("nome");
                int idade = rst.getInt("idade");
                String setor = rst.getString("setor");
                Funcionario funcionario = new Funcionario(idFuncionario, nome, idade, setor);
                funcionarios.add(funcionario);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return funcionarios;
    }

    public Funcionario findByCodigoFuncionario(int idFuncionario) {
        try (Connection connection = new ConnectionFactory().recuperarConexao()) {
            PreparedStatement stm = connection.prepareStatement("SELECT idFuncionario, nome,"
                    + " idade, setor FROM FUNCIONARIO WHERE idFuncionario = (?)");
            stm.setInt(1, idFuncionario);
            stm.executeQuery();
            ResultSet rst = stm.getResultSet();
            while (rst.next()) {
                String nome = rst.getString("nome");
                int idade = rst.getInt("idade");
                String setor = rst.getString("setor");
                Funcionario funcionario = new Funcionario(idFuncionario, nome, idade, setor);
                return funcionario;
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Funcionario cadastrarFuncionario(Funcionario funcionario) {
        try (Connection connection = new ConnectionFactory().recuperarConexao()) {
            PreparedStatement stm = connection.prepareStatement("INSERT INTO FUNCIONARIO (" +
                    "SETOR, IDADE, NOME) VALUES (?, ?, ?) RETURNING IDFUNCIONARIO");
            stm.setString(3, funcionario.getNome());
            stm.setInt(2, funcionario.getIdade());
            stm.setString(1, funcionario.getSetor());
            stm.execute();
            ResultSet rst = stm.getResultSet();
            while (rst.next()) {
                int idFuncionario = rst.getInt("IDFUNCIONARIO");
                funcionario.setId(idFuncionario);
            }
            return funcionario;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteById(int idFuncionario) {
        try (Connection connection = new ConnectionFactory().recuperarConexao()) {
            PreparedStatement stm = connection.prepareStatement("DELETE FROM FUNCIONARIO WHERE " +
                    "IDFUNCIONARIO = ?");
            stm.setInt(1, idFuncionario);
            stm.execute();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void updateById(Funcionario funcionario, int idFuncionario) {
        try (Connection connection = new ConnectionFactory().recuperarConexao()) {
            PreparedStatement stm = connection.prepareStatement("UPDATE FUNCIONARIO SET NOME = ?, IDADE = ?, SETOR = ?" +
                    "WHERE IDFUNCIONARIO = ?");
            stm.setString(1, funcionario.getNome());
            stm.setInt(2, funcionario.getIdade());
            stm.setString(3, funcionario.getSetor());
            stm.setInt(4, idFuncionario);
            stm.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

