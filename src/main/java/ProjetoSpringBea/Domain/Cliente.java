package ProjetoSpringBea.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Cliente {
        private int id;
        private int idade;
        private String nome;
        private double valorParaGastar;
}
