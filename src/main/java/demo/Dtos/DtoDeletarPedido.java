package demo.Dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class DtoDeletarPedido {

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class Request{
        Long id;
    }
}
