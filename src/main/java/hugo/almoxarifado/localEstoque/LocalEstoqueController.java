package hugo.almoxarifado.localEstoque;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hugo.almoxarifado.Modulos.LocalEstoque;

@RestController
@RequestMapping(value = "/estoque")
public class LocalEstoqueController {

    @Autowired
    private LocalEstoqueService localEstoqueService;

    @GetMapping
    public List<LocalEstoque> findAll() {
        return localEstoqueService.findAll();

    }

}
