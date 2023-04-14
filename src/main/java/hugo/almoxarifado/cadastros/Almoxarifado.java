package hugo.almoxarifado.cadastros;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;

@Entity
public class Almoxarifado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nome;

    @OneToMany(mappedBy = "almoxarifado")
    private List<AlmoxarifadoProdutos> almoxarifadoProdutos;

    public void addProduto(Produto produto, int quantidade) {
        AlmoxarifadoProdutos almoxarifadoProduto = new AlmoxarifadoProdutos(this, produto, quantidade);
        almoxarifadoProdutos.add(almoxarifadoProduto);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<AlmoxarifadoProdutos> getAlmoxarifadoProdutos() {
        return almoxarifadoProdutos;
    }

    public void setAlmoxarifadoProdutos(List<AlmoxarifadoProdutos> almoxarifadoProdutos) {
        this.almoxarifadoProdutos = almoxarifadoProdutos;
    }
}
