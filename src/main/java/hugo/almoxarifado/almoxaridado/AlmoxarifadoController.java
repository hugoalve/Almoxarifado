package hugo.almoxarifado.almoxaridado;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hugo.almoxarifado.Modulos.Almoxarifado;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/almoxarifado")
public class AlmoxarifadoController {

    @Autowired
    private ServiceAlmoxarifado service;

    @GetMapping
    public List<Almoxarifado> findAll() {
        return service.findAll();
    }

    @PostMapping
    public Almoxarifado insert(@RequestBody Almoxarifado almoxarifado) {
        return service.insert(almoxarifado);
    }

    @GetMapping("/relatorio")
    public void gerarRelatorioAlmoxarifado(HttpServletResponse response) throws Exception {
        service.gerarRelatorioAlmoxarifado(response);
    }

}
