package hugo.almoxarifado.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import hugo.almoxarifado.cadastros.Almoxarifado;

public interface AlmoxarifadoRepository extends JpaRepository<Almoxarifado, Long> {

}
