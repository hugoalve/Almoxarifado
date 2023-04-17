package hugo.almoxarifado.almoxaridado;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hugo.almoxarifado.Modulos.Almoxarifado;

@Service
public class ServiceAlmoxarifado {

    @Autowired
    private AlmoxarifadoRepository repository;

    public List<Almoxarifado> findAll() {
        return repository.findAll();
    }

    public Almoxarifado insert(Almoxarifado almoxarifado) {
        return repository.save(almoxarifado);
    }

}
