package hugo.almoxarifado.produto;

import org.springframework.data.jpa.repository.JpaRepository;

import hugo.almoxarifado.Modulos.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
