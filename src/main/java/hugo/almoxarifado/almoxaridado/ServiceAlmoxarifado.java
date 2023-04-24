package hugo.almoxarifado.almoxaridado;

import java.util.List;
import java.util.Optional;

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
        if (findByNome(almoxarifado)) {
            throw new IllegalArgumentException("Almoxarifado já existe");
        }
        return repository.save(almoxarifado);
    }

    private boolean findByNome(Almoxarifado almoxarifado) {
        Optional<Almoxarifado> finfByNome = repository.findByNome(almoxarifado.getNome());
        return finfByNome.isPresent();
    }

}
