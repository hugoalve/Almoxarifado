package hugo.almoxarifado.almoxaridado;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import hugo.almoxarifado.Modulos.Almoxarifado;
import jakarta.validation.Valid;

@Service
public class ServiceAlmoxarifado {

    @Autowired
    private AlmoxarifadoRepository repository;

    public List<Almoxarifado> findAll() {
        return repository.findAll();
    }

    public Almoxarifado insert(@Valid @RequestBody Almoxarifado almoxarifado) {
        return repository.save(almoxarifado);
    }

}
