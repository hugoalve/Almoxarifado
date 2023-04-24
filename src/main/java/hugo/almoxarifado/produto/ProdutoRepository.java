package hugo.almoxarifado.produto;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import hugo.almoxarifado.Modulos.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    Optional<Produto> findByNomeAndDescricao(String nome, String descricao);

}
