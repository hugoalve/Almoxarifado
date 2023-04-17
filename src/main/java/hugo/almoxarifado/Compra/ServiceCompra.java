package hugo.almoxarifado.Compra;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hugo.almoxarifado.Modulos.Compra;

@Service
public class ServiceCompra {

    @Autowired
    private CompraRepository compraRepository;

    public List<Compra> findAll() {
        return compraRepository.findAll();
    }

    public Compra create(Compra almoxarifadoProdutos) {
        if (almoxarifadoProdutos.getAlmoxarifado() == null) {
            throw new IllegalArgumentException("O campo Almoxarifado não pode ser nulo");
        }
        if (almoxarifadoProdutos.getProduto() == null) {
            throw new IllegalArgumentException("O campo Produto não pode ser nulo");
        }
        if (almoxarifadoProdutos.getQuantidade() <= 0) {
            throw new IllegalArgumentException("A quantidade deve ser maior que zero");
        }
        return compraRepository.save(almoxarifadoProdutos);
    }

}
