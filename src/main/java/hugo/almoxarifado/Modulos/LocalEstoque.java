package hugo.almoxarifado.Modulos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class LocalEstoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "Id_Almoxerifado")
    private Almoxarifado almoxarifado;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "Id_produto")
    private Produto produto;

    @NotNull
    private int quantidade;

    public LocalEstoque() {
    }

    public LocalEstoque(Long idAlmoxarifado, Long idProduto, int quantidade) {
        this.almoxarifado = new Almoxarifado();
        this.almoxarifado.setId(idAlmoxarifado);
        this.produto = new Produto();
        this.produto.setId(idProduto);
        this.quantidade = quantidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Long getIdAlmoxarifado() {
        return this.almoxarifado.getId();
    }

    public Long getIdProduto() {
        return this.produto.getId();
    }

    public void adicionarProduto(int quantidade) {
        this.quantidade += quantidade;
    }

    public void removerProduto(int quantidade) {
        this.quantidade -= quantidade;
    }

}
