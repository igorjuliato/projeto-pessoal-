package demo.domain;

import demo.Dtos.DtoItensPedidos;
import jakarta.persistence.*;

@Entity
@Table(name = "itens_pedidos")
public class ItensPedidos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer quantidade;

    @ManyToOne
    @JoinColumn(name = "pedidos_id", nullable = false)
    private Pedidos pedidos;

    public ItensPedidos(){}

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

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Pedidos getPedidos() {
        return pedidos;
    }

    public void setPedidos(Pedidos pedidos) {
        this.pedidos = pedidos;
    }
}
