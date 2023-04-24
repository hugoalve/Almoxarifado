package hugo.almoxarifado.produto;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import hugo.almoxarifado.Modulos.Produto;
import jakarta.validation.Valid;

@Service
public class ServiceProduto {

    @Autowired
    private ProdutoRepository repository;

    public List<Produto> listarProdutos() {
        return repository.findAll();
    }

    public Produto insert(@Valid @RequestBody Produto produto) {
        if (produtoJaExiste(produto)) {
            throw new IllegalArgumentException("Produto já existe");
        }
        return repository.save(produto);
    }

    private boolean produtoJaExiste(Produto produto) {
        Optional<Produto> produtoExistente = repository.findByNomeAndDescricao(produto.getNome(),
                produto.getDescricao());
        return produtoExistente.isPresent();
    }

}