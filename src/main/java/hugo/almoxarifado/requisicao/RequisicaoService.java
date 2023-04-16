package hugo.almoxarifado.requisicao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hugo.almoxarifado.Modulos.Requisicao;

@Service
public class RequisicaoService {

    @Autowired
    private RequisicaoRepository requisicaoRepository;

    public List<Requisicao> findAll() {
        return requisicaoRepository.findAll();
    }

}
