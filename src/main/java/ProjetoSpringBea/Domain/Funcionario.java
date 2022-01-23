package ProjetoSpringBea.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Funcionario {
    private int id;
    private String nome;
    private int idade;
    private String setor;

}
