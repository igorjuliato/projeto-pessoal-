package demo.mapper;

import demo.Dtos.DtoPedido;
import demo.domain.Pedidos;
import org.mapstruct.Mapper;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;


@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = IGNORE)
public interface PedidosMapper {

    Pedidos converter(DtoPedido.Request dto);
}
