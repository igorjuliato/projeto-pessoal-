package demo.mapperTest;

import demo.AssertionsTest.PedidoAssertions;
import demo.DtoFactory.PedidoDtoFactory;
import demo.Dtos.DtoItensPedidos;

import demo.mapper.ItensMapper;
import demo.mapper.PedidosMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.util.List;

class PedidosMapperTest {

    PedidosMapper mapperPedidos = Mappers.getMapper(PedidosMapper.class);

    ItensMapper mapperItens = Mappers.getMapper(ItensMapper.class);

    @DisplayName("tem que converter os dados")
    @Nested
    class Converter {

        @DisplayName("caso de sucesso")
        @Nested
        class Sucesso {

            @Test
            void Teste1() {
                //ARRANGE
               var dto = PedidoDtoFactory.criarProdutoDtoRequest().ComTodosOsCampos();
                //ACT
                var atual = mapperPedidos.converter(dto);
                //ASSERT
                PedidoAssertions.afrimaQue_Pedido(atual).FoiConvertido_DtoPedido();
            }
            }
        }
    }
