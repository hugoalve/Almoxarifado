package hugo.almoxarifado.requisicao;

import java.util.List;

import org.jetbrains.annotations.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hugo.almoxarifado.Modulos.Almoxarifado;
import hugo.almoxarifado.Modulos.Produto;
import hugo.almoxarifado.Modulos.Requisicao;
import hugo.almoxarifado.almoxaridado.AlmoxarifadoRepository;
import hugo.almoxarifado.localEstoque.LocalEstoqueService;
import hugo.almoxarifado.produto.ProdutoRepository;

@Service
public class RequisicaoService {

    @Autowired
    private RequisicaoRepository requisicaoRepository;

    @Autowired
    private AlmoxarifadoRepository almoxarifadoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private LocalEstoqueService localEstoqueService;

    public List<Requisicao> findAll() {
        return requisicaoRepository.findAll();
    }

    public Requisicao criarRequisicao(@NotNull Requisicao requisicao) {
        Almoxarifado almoxarifado = almoxarifadoRepository.findById(requisicao.getIdAlmoxarifado())
                .orElseThrow(() -> new IllegalArgumentException("Almoxarifado não encontrado"));
        Produto produto = produtoRepository.findById(requisicao.getIdProduto())
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));
        requisicao.setAlmoxarifado(almoxarifado);
        requisicao.setProduto(produto);
        Requisicao criaRequisicao = requisicaoRepository.save(requisicao);
        localEstoqueService.reduzirLocalEstoque(produto, almoxarifado, requisicao.getQuantidadeSolicitada());
        return criaRequisicao;
    }

}
