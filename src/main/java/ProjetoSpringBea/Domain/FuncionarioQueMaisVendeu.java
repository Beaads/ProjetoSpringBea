package ProjetoSpringBea.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FuncionarioQueMaisVendeu {
    private int quantidade;
    private String nomeFuncionario;
}

