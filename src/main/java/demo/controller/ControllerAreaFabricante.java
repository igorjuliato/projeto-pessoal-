package demo.controller;

import demo.Dtos.DtoBuscarPedido;
import demo.Service.CalcularPedido;
import infra.execepitionsPedidos;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("paraFabricante")
public class ControllerAreaFabricante {

    private CalcularPedido calcular;

    @GetMapping("/{id}/total")
    public ResponseEntity<BigDecimal> calcularValorDeCompra(DtoBuscarPedido.Request dto){
        BigDecimal valorTotal = calcular.calcularPrecoDeCompra(dto);
        return ResponseEntity.ok(valorTotal);
    }
}
