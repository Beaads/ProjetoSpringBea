package ProjetoSpringBea.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor

public class ClienteQueMaisComprou {
    private String nomeCliente;
    private int quantidade;
}
