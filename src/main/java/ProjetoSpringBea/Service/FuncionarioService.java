package ProjetoSpringBea.Service;

import ProjetoSpringBea.Dao.FuncionarioDAO;
import ProjetoSpringBea.Domain.Funcionario;
import ProjetoSpringBea.Domain.FuncionarioQueMaisVendeu;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FuncionarioService {

    private FuncionarioDAO funcionarioDao = new FuncionarioDAO();

    public List<Funcionario> listAll() {
        return funcionarioDao.listAllColaboradores();
    }

    public Funcionario findByCodigoColaborador(int idFuncionario) {
        return funcionarioDao.findByCodigoFuncionario(idFuncionario);
    }

    public Funcionario save(Funcionario funcionario) {
        return funcionarioDao.cadastrarFuncionario(funcionario);
    }

    public void delete(int idFuncionario) {
        funcionarioDao.deleteById(idFuncionario);
    }

    public void replace(Funcionario funcionario, int idFuncionario) {
        funcionarioDao.updateById(funcionario, idFuncionario);
    }

    public List<FuncionarioQueMaisVendeu> listaQuemVendeuMais() {
        return funcionarioDao.listaQuemVendeuMais();
    }
}