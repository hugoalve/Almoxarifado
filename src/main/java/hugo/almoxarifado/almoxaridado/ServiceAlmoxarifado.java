package hugo.almoxarifado.almoxaridado;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import hugo.almoxarifado.Modulos.Almoxarifado;
import hugo.almoxarifado.Modulos.Compra;

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

    public List<Compra> listarCompras(@PathVariable Long id) {
        Almoxarifado almoxarifado = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Almoxarifado não encontrado: " + id));
        return almoxarifado.getAlmoxarifadoProdutos();
    }

}
