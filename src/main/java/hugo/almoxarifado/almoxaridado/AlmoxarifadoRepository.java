package hugo.almoxarifado.almoxaridado;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import hugo.almoxarifado.Modulos.Almoxarifado;

public interface AlmoxarifadoRepository extends JpaRepository<Almoxarifado, Long> {

    Optional<Almoxarifado> findByNome(String nome);
}
