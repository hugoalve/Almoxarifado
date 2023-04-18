package hugo.almoxarifado.Compra;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hugo.almoxarifado.Modulos.Almoxarifado;
import hugo.almoxarifado.Modulos.Compra;
import hugo.almoxarifado.Modulos.Produto;
import hugo.almoxarifado.almoxaridado.AlmoxarifadoRepository;
import hugo.almoxarifado.localEstoque.LocalEstoqueService;
import hugo.almoxarifado.produto.ProdutoRepository;

@Service
public class ServiceCompra {

    @Autowired
    private CompraRepository compraRepository;
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private AlmoxarifadoRepository almoxarifadoRepository;
    @Autowired
    private LocalEstoqueService localEstoqueService;

    public List<Compra> findAll() {
        return compraRepository.findAll();
    }

    public Compra create(Compra compra) {
        Almoxarifado almoxarifado = almoxarifadoRepository.findById(compra.getAlmoxarifado().getId()).orElseThrow();
        Produto produto = produtoRepository.findById(compra.getProduto().getId()).orElseThrow();
        compra.setAlmoxarifado(almoxarifado);
        compra.setProduto(produto);
        Compra compraCriada = compraRepository.save(compra);
        localEstoqueService.atualizarLocalEstoque(produto, almoxarifado, compra.getQuantidade());
        return compraCriada;

    }

}
