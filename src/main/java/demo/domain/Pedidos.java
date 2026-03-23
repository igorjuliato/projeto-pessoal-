package demo.domain;


import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Pedidos_Cliente")
public class Pedidos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdPedido;

    private String Cliente;

    private LocalDate dataPedido;

    private String localPedido;

    @OneToMany(mappedBy = "pedidos", cascade = CascadeType.ALL)
    private List<ItensPedidos> listPedido;

    public Pedidos(){}

    public Long getIdPedido() {
        return IdPedido;
    }

    public void setIdPedido(Long idPedido) {
        IdPedido = idPedido;
    }

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String cliente) {
        Cliente = cliente;
    }

    public LocalDate getDataPedido() {return dataPedido;}

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getLocalPedido() {
        return localPedido;
    }

    public void setLocalPedido(String localPedido) {
        this.localPedido = localPedido;
    }

    public List<ItensPedidos> getListPedido() {
        return listPedido;
    }

    public void setListPedido(List<ItensPedidos> listPedido) {
        this.listPedido = listPedido;
    }
}
