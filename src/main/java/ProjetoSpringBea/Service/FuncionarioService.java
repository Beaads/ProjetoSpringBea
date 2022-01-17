package ProjetoSpringBea.Service;

import ProjetoSpringBea.Dao.FuncionarioDAO;
import ProjetoSpringBea.Domain.Funcionario;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FuncionarioService {

    private FuncionarioDAO funcionarioDao = new FuncionarioDAO();

    public List<Funcionario> listAll() {
        return funcionarioDao.listAllColaboradores();
    }

    public Funcionario findByCodigoColaborador(int codigoColaborador) {
        return funcionarioDao.findByCodigoColaborador(codigoColaborador);
    }

    public Funcionario save(Funcionario funcionario) {
        return funcionarioDao.cadastrarColaborador(funcionario);
    }

    public void delete(int idFuncionario) {
        funcionarioDao.deleteById(idFuncionario);
    }

    public void replace(Funcionario funcionario, int idFuncionario) {
        funcionarioDao.updateById(funcionario, idFuncionario);
    }
}