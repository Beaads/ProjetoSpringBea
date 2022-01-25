package ProjetoSpringBea.Service;

import ProjetoSpringBea.Dao.ClienteDAO;
import ProjetoSpringBea.Dao.ProdutoDao;
import ProjetoSpringBea.Dao.VendaProdutoDAO;
import ProjetoSpringBea.Domain.Cliente;
import ProjetoSpringBea.Domain.Produto;
import ProjetoSpringBea.Domain.VendaProduto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service

public class VendaProdutoService {

    private FuncionarioService funcionarioService = new FuncionarioService();
    private VendaProdutoDAO vendaProdutoDAO = new VendaProdutoDAO();
    private ProdutoService produtoService = new ProdutoService();
    private ClienteService clienteService = new ClienteService();

    public List<VendaProduto> listAllVendaProduto() {
        return vendaProdutoDAO.listAllVendaProduto();
    }

    public VendaProduto findByIdVenda(int idVenda) {
        return vendaProdutoDAO.findByIdVenda(idVenda);
    }

    public VendaProduto save(VendaProduto vendaProduto) {
        String setor = funcionarioService.getSetorById(vendaProduto.getIdFuncionario());
        Produto produto = produtoService.getProdutoById(vendaProduto.getIdProduto());
        Cliente cliente = clienteService.getClienteById(vendaProduto.getIdCliente());
        if(Objects.equals(setor.toUpperCase(), "VENDAS")
                && produto.getQuantidade()   >= vendaProduto.getQuantidade()
                && cliente.getValorParaGastar() >= produto.getPreco() * vendaProduto.getQuantidade()
                && cliente.getIdade() >= 18) {
            clienteService.updateValorParaGastar(cliente.getId(), cliente.getValorParaGastar(), produto.getPreco(), vendaProduto.getQuantidade());
            produtoService.updateQuantidadeProduto(produto, vendaProduto.getQuantidade());
            return vendaProdutoDAO.cadastrarVenda(vendaProduto);
        }
        return null;
    }
}
