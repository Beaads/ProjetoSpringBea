package ProjetoSpringBea.Controller;

import ProjetoSpringBea.Domain.Funcionario;
import ProjetoSpringBea.Service.FuncionarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping
@RestController
@RequiredArgsConstructor

public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    //http://localhost:8080/colaboradores
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

    @DeleteMapping(path = "/{codigoColaborador}")
    public ResponseEntity<Void> delete (@PathVariable int idFuncionario) {
        funcionarioService.delete(idFuncionario);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(path = "/{codigoColaborador}")
    public ResponseEntity<Void> replace (@RequestBody Funcionario funcionario, @PathVariable int codigoColaborador) {
        funcionarioService.replace(funcionario, idFuncionario);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
