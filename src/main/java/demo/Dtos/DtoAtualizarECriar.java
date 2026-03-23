package demo.Dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.math.BigDecimal;

public class DtoAtualizarECriar {

     @NoArgsConstructor
     @Getter
     @AllArgsConstructor
     @Builder
     @Data
     public static class Request {
         @NotBlank
         Long id;

         String nomeProduto;

         BigDecimal preco;
     }

     @AllArgsConstructor
     @NoArgsConstructor
     @Data
     @Builder
     public static  class Response {

         @NotBlank
         String mensagem;

         @NotBlank
         String acao;
     }

     @NoArgsConstructor
     @AllArgsConstructor
     @Builder
     @Data
     public static class RequestResposta {
         @NotBlank
         String respostaCliente;
     }
}
