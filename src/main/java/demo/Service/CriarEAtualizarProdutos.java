package demo.Service;

import demo.Dtos.DtoAtualizarECriar;
import demo.Repository.ProdutoRepository;
import demo.domain.Produto;
import demo.mapper.ProdutoMapper;
import infra.ExecepitionsPedidoNaoEncontrado;
import infra.ProdutoExistente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class CriarEAtualizarProdutos {


    @Autowired
    private static ProdutoRepository repository;

    @Autowired
    private static ProdutoMapper mapper;

    @Transactional
    public void Atualizar(DtoAtualizarECriar.Request dto) {
        Produto produto = repository.findById(dto.getId())
                .orElseThrow(() -> new ExecepitionsPedidoNaoEncontrado("seu Produto não foi encontrado"));

        mapper.atualizar(dto, produto);

        repository.save(produto);
    }

    public void CriarProduto(DtoAtualizarECriar.Request dto){
        Produto produto = repository.findById(dto.getId())
                        .orElseThrow(() -> new ProdutoExistente("seu produto ja existe"));

        mapper.converter(dto);

        repository.save(produto);
    }
}
