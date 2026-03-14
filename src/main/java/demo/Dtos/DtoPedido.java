package demo.Dtos;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
public class DtoPedido{

    @Builder
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class Request {

        @NotNull
        private List<DtoItensPedidos> itens;

        @NotNull
        private String nomeCliente;

        @NotNull
        private LocalDate dataDoPedido;

        @NotNull
        private String localPedido;
    }
}