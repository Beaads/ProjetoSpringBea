package ProjetoSpringBea.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Cliente {
        private int id;
        private String nome;
        private int idade;
        private double valorParaGastar;
}
