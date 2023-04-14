package hugo.almoxarifado.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hugo.almoxarifado.cadastros.AlmoxarifadoProdutos;
import hugo.almoxarifado.service.ServiceAlmoxarifadoProduto;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/entradaProduto")
public class AlmoxarifadoProdutosController {

    @Autowired
    private ServiceAlmoxarifadoProduto serviceAlmoxarifadoProduto;

    @GetMapping
    public List<AlmoxarifadoProdutos> findAll() {
        return serviceAlmoxarifadoProduto.findAll();
    }

    @PostMapping
    public AlmoxarifadoProdutos create(@Valid @RequestBody AlmoxarifadoProdutos almoxarifadoProdutos) {
        return serviceAlmoxarifadoProduto.create(almoxarifadoProdutos);
    }

}
