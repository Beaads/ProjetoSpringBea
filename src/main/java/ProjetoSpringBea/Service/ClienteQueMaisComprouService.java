package ProjetoSpringBea.Service;

import ProjetoSpringBea.Dao.ClienteQueMaisComprouDAO;
import ProjetoSpringBea.Domain.Cliente;
import ProjetoSpringBea.Domain.ClienteQueMaisComprou;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteQueMaisComprouService {

    private ClienteQueMaisComprouDAO clienteQueMaisComprouDAO = new ClienteQueMaisComprouDAO();

    public List<ClienteQueMaisComprou> listaCliente() {
        return clienteQueMaisComprouDAO.listaCliente();
    }
}
