package ProjetoSpringBea.Domain;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Produto {
    private String nome;
    private int quantidadeProduto;
}
