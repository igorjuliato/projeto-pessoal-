package demo.mapper;

import demo.Dtos.DtoAtualizarECriar;
import demo.domain.Produto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = IGNORE)
public interface ProdutoMapper {
    Produto converter(DtoAtualizarECriar.Request dto);

    void atualizar(DtoAtualizarECriar.Request dto , @MappingTarget Produto produto);
}
