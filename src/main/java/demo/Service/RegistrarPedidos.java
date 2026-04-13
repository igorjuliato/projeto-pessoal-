package demo.Service;

import demo.Dtos.DtoPedido;
import demo.Service.RegarDeLocal.RegrasDeLocalidadeDePedido;
import demo.domain.ItensPedidos;
import demo.domain.Pedidos;
import demo.Repository.PedidosRepository;
import demo.mapper.ItensMapper;
import demo.mapper.PedidosMapper;
import infra.PedidoInvalido;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RegistrarPedidos {

    @Autowired
    private PedidosRepository repository;

    private Pedidos pedido;

    @Autowired
    private PedidosMapper mapperPedido;

    @Autowired
    private ItensMapper mappperItens;

    @Autowired
    private RegrasDeLocalidadeDePedido validaçãoLocal;

    public String RegistarPedido (DtoPedido.Request dto) {
        if(dto.getItens().get(0).quantidade() <= 0){throw new PedidoInvalido(
                "no item: " + dto.getItens().get(0).idProduto() + " deve ter pelo menos um produto");}

        validaçãoLocal.NaoEntregaNoLocal(dto);
        System.out.println("entrou na validação");

            Pedidos pedidos = mapperPedido.converter(dto);
        System.out.println("entrou no mapper");

            List<ItensPedidos> listaDePedidos = dto.getItens().stream().
                    map(i -> {
                        ItensPedidos iten = mappperItens.converter(i);
                        iten.setPedidos(pedidos);

                        return iten;
                    }).toList();

            pedidos.setListPedido(listaDePedidos);

            repository.save(pedidos);
        System.out.println("entrou no repository");
            return "seu pedido foi feito";
    }
}


