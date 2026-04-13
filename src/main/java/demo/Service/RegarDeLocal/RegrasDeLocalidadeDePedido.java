package demo.Service.RegarDeLocal;

import demo.Dtos.DtoPedido;
import infra.RegiaoInvalida;
import org.springframework.stereotype.Service;

@Service
public class RegrasDeLocalidadeDePedido {

    private final ViaCepCliente viaCepCliente;

    public RegrasDeLocalidadeDePedido(ViaCepCliente viaCepCliente) {
        this.viaCepCliente = viaCepCliente;
    }

    public void NaoEntregaNoLocal(DtoPedido.Request dto){
        var response = viaCepCliente.buscarPorCidade(dto.getCep());

        if(response.getRegiao() != "Nordeste"){
           throw new RegiaoInvalida("so fazemos pedidos na região do nordeste");
        }
    }
}
