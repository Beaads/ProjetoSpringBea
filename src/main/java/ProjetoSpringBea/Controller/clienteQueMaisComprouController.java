package ProjetoSpringBea.Controller;

import ProjetoSpringBea.Domain.Cliente;
import ProjetoSpringBea.Domain.ClienteQueMaisComprou;
import ProjetoSpringBea.Service.ClienteQueMaisComprouService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RequestMapping("clienteQueMaisComprou")
@RestController
@RequiredArgsConstructor

public class clienteQueMaisComprouController {

    private final ClienteQueMaisComprouService clienteQueMaisComprouDAOService;

    @GetMapping
    public ResponseEntity<List<ClienteQueMaisComprou>> list() {
        return new ResponseEntity<>(clienteQueMaisComprouDAOService.listaCliente(), HttpStatus.OK);
    }
}
