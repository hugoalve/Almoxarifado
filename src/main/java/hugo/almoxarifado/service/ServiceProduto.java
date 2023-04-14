package hugo.almoxarifado.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import hugo.almoxarifado.cadastros.Produto;
import hugo.almoxarifado.repositories.ProdutoRepository;
import jakarta.validation.Valid;

@Service
public class ServiceProduto {

    @Autowired
    private ProdutoRepository repository;

    public List<Produto> listarProdutos() {
        return repository.findAll();
    }

    public Produto insert(@Valid @RequestBody Produto produto) {
        return repository.save(produto);
    }

}