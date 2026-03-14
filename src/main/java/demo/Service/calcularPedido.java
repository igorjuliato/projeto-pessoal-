package demo.Service;

import demo.Dtos.DtoBuscarPedido;
import demo.Repository.pedidosRepository;
import demo.controller.ControllerAreaFabricante;
import demo.domain.Pedidos;
import infra.execepitionsPedidos;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class calcularPedido {

    private final pedidosRepository repository;

    public calcularPedido(pedidosRepository repository) {
        this.repository = repository;
    }

    private ControllerAreaFabricante controller;

    public void calcularprecoDeCompra(DtoBuscarPedido dto) {

        Optional<Pedidos> pedido =   repository.findById(dto.id());

        if(pedido.isPresent()){

    } else {
           infra.execepitionsPedidos execepitionsPedidos = new execepitionsPedidos("pedido não encontrado");
            controller.handleResourceNotFound(execepitionsPedidos);
        }
        }

}
