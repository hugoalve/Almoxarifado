package hugo.almoxarifado.requisicao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hugo.almoxarifado.Modulos.Requisicao;

@RestController
@RequestMapping(value = "/resiquicao")
public class RequisicaoController {

    @Autowired
    private RequisicaoService requisicaoService;

    @GetMapping
    public List<Requisicao> findAll() {
        return requisicaoService.findAll();
    }
}
