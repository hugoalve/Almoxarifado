package hugo.almoxarifado.produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hugo.almoxarifado.Modulos.Produto;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoController {

    @Autowired
    private ServiceProduto service;

    @GetMapping
    public List<Produto> findAll() {
        return service.listarProdutos();
    }

    @PostMapping
    public Produto insert(@RequestBody Produto produto) {
        return service.insert(produto);
    }
}
