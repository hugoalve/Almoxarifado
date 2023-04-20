package hugo.almoxarifado.Modulos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class Requisicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private int quantidadeSolicitada;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "Id_Almoxarifado")
    private Almoxarifado almoxarifado;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "Id_produto")
    private Produto produto;

    public Requisicao() {

    }

    public Requisicao(Long idalmoxarifado, Long idproduto, int quantidadeSolicitada) {
        this.quantidadeSolicitada = quantidadeSolicitada;
        this.almoxarifado = new Almoxarifado();
        this.almoxarifado.setId(idalmoxarifado);
        this.produto = new Produto();
        this.produto.setId(idproduto);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantidadeSolicitada() {
        return quantidadeSolicitada;
    }

    public void setQuantidadeSolicitada(int quantidadeSolicitada) {
        this.quantidadeSolicitada = quantidadeSolicitada;
    }

    public Almoxarifado getAlmoxarifado() {
        return almoxarifado;
    }

    public void setAlmoxarifado(Almoxarifado almoxarifado) {
        this.almoxarifado = almoxarifado;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Long getIdAlmoxarifado() {
        return this.almoxarifado.getId();
    }

    public Long getIdProduto() {
        return this.produto.getId();
    }

}
