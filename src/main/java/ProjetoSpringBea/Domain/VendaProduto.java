package ProjetoSpringBea.Domain;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VendaProduto {
    private int idVenda;
    private int idProduto;
    private int idCliente;
    private int idFuncionario;
    private int quantidade;
}
