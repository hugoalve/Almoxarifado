package hugo.almoxarifado.requisicao;

import org.springframework.data.jpa.repository.JpaRepository;

import hugo.almoxarifado.Modulos.Requisicao;

public interface RequisicaoRepository extends JpaRepository<Requisicao, Long> {

}
