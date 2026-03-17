package demo.controller;

import demo.Dtos.DtoPedido;
import demo.Service.RegistrarPedidos;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/compras")
public class ControllerPedidos {

    @Autowired
    public RegistrarPedidos pedidosService;

    @PostMapping("/fazerPedido")
    public void ResgistroPedido(@Valid @RequestBody DtoPedido.Request dto){
        pedidosService.RegistarPedido(dto);
    }
}
