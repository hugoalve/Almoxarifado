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

    public LocalEstoque somarLocalEstoque(Produto produto, Almoxarifado almoxarifado, Integer quantidadeCompra) {
        Optional<LocalEstoque> optionalLocalEstoque = repository.findByProdutoAndAlmoxarifado(produto, almoxarifado);
        if (optionalLocalEstoque.isPresent()) {
            LocalEstoque localEstoque = optionalLocalEstoque.get();
            Integer novaQuantidade = localEstoque.getQuantidade() + quantidadeCompra;
            localEstoque.setQuantidade(novaQuantidade);
            return repository.save(localEstoque);
        } else {
            LocalEstoque novoLocalEstoque = new LocalEstoque(null, null, 0);
            novoLocalEstoque.setProduto(produto);
            novoLocalEstoque.setAlmoxarifado(almoxarifado);
            novoLocalEstoque.setQuantidade(quantidadeCompra);
            return repository.save(novoLocalEstoque);
        }
    }

    public LocalEstoque reduzirLocalEstoque(Produto produto, Almoxarifado almoxarifado, Integer quantidadeCompra) {
        Optional<LocalEstoque> optionalLocalEstoque = repository.findByProdutoAndAlmoxarifado(produto, almoxarifado);
        if (optionalLocalEstoque.isPresent()) {
            LocalEstoque localEstoque = optionalLocalEstoque.get();
            if (localEstoque.getQuantidade() < quantidadeCompra) {
                throw new IllegalArgumentException("Quantidade insuficiente no estoque.");
            }
            Integer novaQuantidade = localEstoque.getQuantidade() - quantidadeCompra;
            localEstoque.setQuantidade(novaQuantidade);

            return repository.save(localEstoque);
        } else {
            throw new IllegalArgumentException(
                    "Local de estoque não encontrado para o produto e almoxarifado informados.");
        }
    }

}
