package hugo.almoxarifado.localEstoque;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hugo.almoxarifado.Modulos.Almoxarifado;
import hugo.almoxarifado.Modulos.LocalEstoque;
import hugo.almoxarifado.Modulos.Produto;

@Service
public class LocalEstoqueService {

    @Autowired
    private LocalEstoqueRepository repository;

    public List<LocalEstoque> findAll() {
        return repository.findAll();
    }

    public Optional<LocalEstoque> findByProdutoAndAlmoxarifado(Produto produto, Almoxarifado almoxarifado) {
        return repository.findByProdutoAndAlmoxarifado(produto, almoxarifado);
    }

    public LocalEstoque atualizarLocalEstoque(Produto produto, Almoxarifado almoxarifado, Integer quantidade) {
        Optional<LocalEstoque> optionalLocalEstoque = repository.findByProdutoAndAlmoxarifado(produto, almoxarifado);
        if (optionalLocalEstoque.isPresent()) {
            LocalEstoque localEstoque = optionalLocalEstoque.get();
            localEstoque.setQuantidade(quantidade);
            return repository.save(localEstoque);
        } else {
            LocalEstoque localEstoque = new LocalEstoque(null, null, 0);
            localEstoque.setProduto(produto);
            localEstoque.setAlmoxarifado(almoxarifado);
            localEstoque.setQuantidade(quantidade);
            return repository.save(localEstoque);
        }
    }

}
