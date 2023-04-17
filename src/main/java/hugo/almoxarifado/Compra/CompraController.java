package hugo.almoxarifado.Compra;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hugo.almoxarifado.Modulos.Compra;

@RestController
@RequestMapping(value = "/entradaProduto")
public class CompraController {

    @Autowired
    private ServiceCompra serviceCompra;

    @GetMapping
    public List<Compra> findAll() {
        return serviceCompra.findAll();
    }

    @PostMapping
    public Compra create(@RequestBody Compra compra) {
        return serviceCompra.create(compra);
    }

}
