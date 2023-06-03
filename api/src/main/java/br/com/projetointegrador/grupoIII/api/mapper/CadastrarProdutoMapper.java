package br.com.projetointegrador.grupoIII.api.mapper;

import br.com.projetointegrador.grupoIII.api.domain.Fornecedores;
import br.com.projetointegrador.grupoIII.api.domain.Produtos;
import br.com.projetointegrador.grupoIII.api.presentation.request.CadastrarProdutoRequest;
import br.com.projetointegrador.grupoIII.api.presentation.response.CadastrarProdutoResponse;

public class CadastrarProdutoMapper {

    public static Produtos toEntity(CadastrarProdutoRequest request) {
        return Produtos.builder()
                .nome(request.getNome())
                .descricao(request.getDescricao())
                .fornecedores(Fornecedores.builder().id(request.getIdFornecedor()).build())
                .build();
    }

    public static CadastrarProdutoResponse toResponse(Integer id) {
        return CadastrarProdutoResponse.builder()
                .id(id)
                .build();
    }
}
