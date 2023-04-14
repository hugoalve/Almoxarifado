package hugo.almoxarifado.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import hugo.almoxarifado.cadastros.AlmoxarifadoProdutos;

public interface AlmoxarifadoProdutoRepository extends JpaRepository<AlmoxarifadoProdutos, Long> {

}
