package demo.AssertionsTest;
import demo.Dtos.DtoItensPedidos;
import demo.domain.Pedidos;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDate;
import java.util.List;


public class PedidoAssertions {

    private Pedidos dados;

    private final Pedidos atual;

    public PedidoAssertions(Pedidos atual) {
        this.atual = atual;
    }

    public static PedidoAssertions afrimaQue_Pedido (Pedidos atual){
        return new PedidoAssertions(atual);
    }
     public void FoiConvertido_DtoPedido (){
         Assertions.assertEquals("igor", atual.getCliente());
         List<DtoItensPedidos> esperado = List.of(
                 new DtoItensPedidos(1,3),
                 new DtoItensPedidos(2, 10),
                 new DtoItensPedidos(3, 6)
         );
         Assertions.assertEquals(esperado, atual.getListPedido());
         Assertions.assertEquals(LocalDate.of(2026, 02, 20) , atual.getDataPedido());
         Assertions.assertEquals("bougainville", atual.getLocalPedido());
     }
}
