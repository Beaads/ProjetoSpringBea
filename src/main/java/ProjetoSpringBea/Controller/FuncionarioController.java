package ProjetoSpringBea.Controller;
import ProjetoSpringBea.Domain.Funcionario;
import ProjetoSpringBea.Domain.FuncionarioQueMaisVendeu;
import ProjetoSpringBea.Service.FuncionarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping ("funcionarios")
@RestController
@RequiredArgsConstructor

//http://localhost:8080/funcionarios

public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    @GetMapping
    public ResponseEntity<List<Funcionario>> list() {
        return new ResponseEntity<>(funcionarioService.listAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{idFuncionario}")
    public ResponseEntity<Funcionario> findById(@PathVariable int idFuncionario){
        return new ResponseEntity<>(funcionarioService.findByCodigoColaborador(idFuncionario), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Funcionario> save (@RequestBody Funcionario funcionario) {
        return new ResponseEntity<>(funcionarioService.save(funcionario), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{idFuncionario}")
    public ResponseEntity<Void> delete (@PathVariable int idFuncionario) {
        Optional<Funcionario> data = Optional.ofNullable(funcionarioService.findByCodigoColaborador(idFuncionario));
        FuncionarioService response = new FuncionarioService();
        if (data.isPresent()) {
            funcionarioService.delete(idFuncionario);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<> (HttpStatus.NO_CONTENT);
    }

    @PutMapping(path = "/{idFuncionario}")
    public ResponseEntity<Void> replace (@RequestBody Funcionario funcionario, @PathVariable int idFuncionario) {
        funcionarioService.replace(funcionario, idFuncionario);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(path = "/quemVendeumais")
    public ResponseEntity<List<FuncionarioQueMaisVendeu>> lista() {
        return new ResponseEntity<>(funcionarioService.listaQuemVendeuMais(), HttpStatus.OK);
    }
}
