package ProjetoSpringBea.Service;

import ProjetoSpringBea.Dao.VendaProdutoDAO;
import ProjetoSpringBea.Domain.VendaProduto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class VendaProdutoService {

    private VendaProdutoDAO vendaProdutoDAO = new VendaProdutoDAO();

    public List<VendaProduto> listAllVendaProduto() {
        return vendaProdutoDAO.listAllVendaProduto();
    }

    public VendaProduto findByIdVenda(int idVenda) {
        return vendaProdutoDAO.findByIdVenda(idVenda);
    }

    public VendaProduto save(VendaProduto vendaProduto) {
        return vendaProdutoDAO.cadastrarVenda(vendaProduto);
    }

}
