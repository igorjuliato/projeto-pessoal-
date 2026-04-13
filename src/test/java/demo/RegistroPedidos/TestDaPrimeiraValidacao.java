package demo.RegistroPedidos;

import static org.mockito.Mockito.*;
import demo.DtoFactory.PedidoDtoFactory;
import demo.Dtos.DtoPedido;
import demo.Service.RegarDeLocal.RegrasDeLocalidadeDePedido;
import demo.Service.RegarDeLocal.ViaCepCliente;
import infra.RegiaoInvalida;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

@ExtendWith(MockitoExtension.class)
class TestDaPrimeiraValidacao {

    @Mock
    private ViaCepCliente viacep;

    private demo.Service.RegarDeLocal.DtoResponseApiViacep.Request dto;

    @InjectMocks
    private RegrasDeLocalidadeDePedido PrimeiraValidacao;

    public static Stream<Arguments> TodosOsCenarios() {
        return Stream.of(
                Arguments.of(PedidoDtoFactory.criarProdutoDtoRequest().valido(), null),
                Arguments.of(PedidoDtoFactory.criarProdutoDtoRequest().InvalidoPorLocal(), RegiaoInvalida.class)
        );
    }

    @ParameterizedTest
    @MethodSource("TodosOsCenarios")
    public void TestandoPrimeiraValicaoDoFluxo(DtoPedido.Request dto, Class<? extends Exception> exceptionClass){

        dto.setCep("58077-110");

        when(viacep.buscarPorCidade(anyString())).thenReturn(dto);

        Assertions.assertDoesNotThrow(() -> PrimeiraValidacao.NaoEntregaNoLocal(dto.getCep()));
    }
}



