package demo.Dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.math.BigDecimal;

public class DtoProdutos {

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public class Request {
    String nomeProduto;

    BigDecimal preco;
    }
}
