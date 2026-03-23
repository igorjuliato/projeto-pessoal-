package demo.Service;

import demo.Dtos.DtoDeletarPedido;
import demo.Repository.PedidosRepository;
import demo.domain.Pedidos;
import infra.ExecepitionsPedidoNaoEncontrado;
import infra.ProdutoExistente;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class DeletarPedido {

    @Autowired
    private PedidosRepository repository;

    public void deletar(@Valid DtoDeletarPedido.Request dto) {
       Optional<Pedidos> id = Optional.of(repository.findById(dto.getId())
               .orElseThrow(() -> new ExecepitionsPedidoNaoEncontrado("seu pedido não existe")));

       repository.delete(id.get());
    }
}
