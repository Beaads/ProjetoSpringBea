package ProjetoSpringBea.Controller;

import ProjetoSpringBea.Domain.VendaProduto;
import ProjetoSpringBea.Service.VendaProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("vendas")
@RestController
@RequiredArgsConstructor

public class VendaProdutoController {

    private final VendaProdutoService vendaProdutoService;
    //http://localhost:8080/vendas

    @GetMapping
    public ResponseEntity<List<VendaProduto>> list() {
        return new ResponseEntity<>(vendaProdutoService.listAllVendaProduto(), HttpStatus.OK);
    }

    @GetMapping(path = "/{idVenda}")
    public ResponseEntity<VendaProduto> findById(@PathVariable int idVenda){
        return new ResponseEntity<>(vendaProdutoService.findByIdVenda(idVenda), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<VendaProduto> save (@RequestBody VendaProduto vendaProduto) {
        return new ResponseEntity<>(vendaProdutoService.save(vendaProduto), HttpStatus.CREATED);
    }
}
