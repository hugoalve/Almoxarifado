package hugo.almoxarifado.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import hugo.almoxarifado.cadastros.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
