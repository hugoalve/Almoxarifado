package hugo.almoxarifado.localEstoque;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import hugo.almoxarifado.Modulos.Almoxarifado;
import hugo.almoxarifado.Modulos.LocalEstoque;
import hugo.almoxarifado.Modulos.Produto;

public interface LocalEstoqueRepository extends JpaRepository<LocalEstoque, Long> {

    Optional<LocalEstoque> findByProdutoAndAlmoxarifado(Produto produto, Almoxarifado almoxarifado);

}
