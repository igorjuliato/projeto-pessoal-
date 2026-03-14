package demo.Service;

import demo.Dtos.DtoPedido;
import demo.domain.ItensPedidos;
import demo.domain.Pedidos;
import demo.Repository.pedidosRepository;
import demo.mapper.ItensMapper;
import demo.mapper.PedidosMapper;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RegistrarPedidos {
    private final pedidosRepository repository;

    private Pedidos pedido;

    public RegistrarPedidos(pedidosRepository repository) {
        this.repository = repository;
    }

    @Autowired
    private PedidosMapper mapperPedido;

    @Autowired
    private ItensMapper mappperItens;

    public void RegistarPedido (DtoPedido.Request dto) {

        Pedidos pedidos = mapperPedido.converter(dto);

        List<ItensPedidos> listaDePedidos = dto.getItens().stream().
                   map(i -> {
                       ItensPedidos iten = mappperItens.converter(i);
                       iten.setPedidos(pedidos);

                       return iten;
                   }).toList();

                   pedidos.setListPedido(listaDePedidos);

                   repository.save(pedidos);
        }
    }

