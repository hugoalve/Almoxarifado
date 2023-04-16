package hugo.almoxarifado.Compra;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hugo.almoxarifado.Modulos.Compra;

@Service
public class ServiceCompra {

    @Autowired
    private CompraRepository serviceAlmoxarifadoProduto;

    public List<Compra> findAll() {
        return serviceAlmoxarifadoProduto.findAll();
    }

    public Compra create(Compra almoxarifadoProdutos) {
        return serviceAlmoxarifadoProduto.save(almoxarifadoProdutos);
    }

}
