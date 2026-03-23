package demo.Service;

import demo.Dtos.DtoBuscarPedido;
import demo.Repository.PedidosRepository;
import demo.controller.ControllerAreaFabricante;
import demo.domain.ItensPedidos;
import demo.domain.Pedidos;
import infra.ExecepitionsPedidoNaoEncontrado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class CalcularPedido {

    @Autowired
    private final PedidosRepository repository;

    public CalcularPedido(PedidosRepository repository) {
        this.repository = repository;
    }

    @Autowired
    private ControllerAreaFabricante controller;

    @Transactional
    public BigDecimal calcularPrecoDeCompra(DtoBuscarPedido.Request dto) {
        Optional<Pedidos> BuscaPedido = Optional.of(repository.findById(dto.getId())
                .orElseThrow(() -> new ExecepitionsPedidoNaoEncontrado("seu Pedido não esta sendo achado")));

        BuscaPedido.isPresent();
            Pedidos pedido = BuscaPedido.get();
            List<ItensPedidos> ItensDoCliente = pedido.getListPedido();
            BigDecimal valorTotal = ItensDoCliente.stream().map(
                    i -> {
                        int preco = repository.buscarPrecoUnitario(i.getId());
                        int quantidade = i.getQuantidade();
                        BigDecimal valorDeCadaItemPedido = new BigDecimal(preco * quantidade);

                        return valorDeCadaItemPedido;
                    }).reduce(BigDecimal.ZERO, BigDecimal::add);

            return valorTotal;
        }
    }

