package demo.Dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.apache.catalina.connector.Request;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

public class DtoBuscarPedido{

        @Builder
        @Getter
        @AllArgsConstructor
        @NoArgsConstructor
        @Data
        public static class Request { @NotBlank long id;}

        @Builder
        @Getter
        @AllArgsConstructor
        @NoArgsConstructor
        @Data
        public static class Response {
                BigDecimal valorPedido;
        }
}



