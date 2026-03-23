package demo.controller;

import demo.Dtos.DtoAtualizarECriar;
import demo.Dtos.DtoBuscarPedido;
import demo.Service.CalcularPedido;
import demo.Service.DecisaoDeAtualizarOuCriar;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("paraFabricante")
public class ControllerAreaFabricante {

    @Autowired
    private CalcularPedido calcular;

    @Autowired
    private DecisaoDeAtualizarOuCriar CriarOuAtualizar;

    @GetMapping("/{id}/calcularPedido")
    public ResponseEntity<BigDecimal> calcularValorDeCompra(@Valid DtoBuscarPedido.Request dto){
        BigDecimal valorTotal = calcular.calcularPrecoDeCompra(dto);
        return ResponseEntity.ok(valorTotal);
    }

    @PostMapping("/Atualizar/Criar")
    public ResponseEntity<DtoAtualizarECriar.Response> AtualizarOuCriarProduto (@RequestBody @Valid DtoAtualizarECriar.Request dto){
        DtoAtualizarECriar.Response resposta = CriarOuAtualizar.VerificarNoDB(dto);
        return ResponseEntity.ok(resposta);
    }

    @PostMapping("/confirmar")
    public ResponseEntity<String> Confirmar (@Valid DtoAtualizarECriar.RequestResposta dto){
       String mensagem = CriarOuAtualizar.CriarProduto(dto);
       return ResponseEntity.ok(mensagem);
    }
}
