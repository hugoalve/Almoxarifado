package hugo.almoxarifado.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hugo.almoxarifado.cadastros.AlmoxarifadoProdutos;
import hugo.almoxarifado.repositories.AlmoxarifadoProdutoRepository;

@Service
public class ServiceAlmoxarifadoProduto {

    @Autowired
    private AlmoxarifadoProdutoRepository serviceAlmoxarifadoProduto;

    public List<AlmoxarifadoProdutos> findAll() {
        return serviceAlmoxarifadoProduto.findAll();
    }

    public AlmoxarifadoProdutos create(AlmoxarifadoProdutos almoxarifadoProdutos) {
        return serviceAlmoxarifadoProduto.save(almoxarifadoProdutos);
    }

}
