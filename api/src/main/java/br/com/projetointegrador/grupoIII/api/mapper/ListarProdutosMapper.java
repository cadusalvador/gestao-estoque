package br.com.projetointegrador.grupoIII.api.mapper;

import br.com.projetointegrador.grupoIII.api.domain.Produtos;
import br.com.projetointegrador.grupoIII.api.presentation.response.FornecedorResponse;
import br.com.projetointegrador.grupoIII.api.presentation.response.ListarProdutosResponse;

public class ListarProdutosMapper {

    public static ListarProdutosResponse toResponse(Produtos produtos) {
        return ListarProdutosResponse.builder()
                .id(produtos.getId())
                .nome(produtos.getNome())
                .descricao(produtos.getDescricao())
                .fornecedor(produtos.getFornecedores().toFornecedorResponse())
                .build();
    }
}
