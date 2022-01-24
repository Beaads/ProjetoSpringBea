package ProjetoSpringBea.Service;

import ProjetoSpringBea.Dao.ClienteDAO;
import ProjetoSpringBea.Domain.Cliente;
import ProjetoSpringBea.Domain.ClienteQueMaisComprou;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private ClienteDAO clienteDAO = new ClienteDAO();

    public List<ClienteQueMaisComprou> listaCliente() {
        return clienteDAO.listaCliente();
    }

    public Cliente getClienteById(int idCliente) {
        return clienteDAO.getClienteById(idCliente);
    }
}
