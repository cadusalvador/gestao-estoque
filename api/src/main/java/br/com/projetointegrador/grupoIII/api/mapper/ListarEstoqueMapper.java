package br.com.projetointegrador.grupoIII.api.mapper;

import br.com.projetointegrador.grupoIII.api.domain.Estoque;
import br.com.projetointegrador.grupoIII.api.presentation.response.ListarEstoqueResponse;

public class ListarEstoqueMapper {

    public static ListarEstoqueResponse toResponse(Estoque estoque) {
        return ListarEstoqueResponse.builder()
                .produtoId(estoque.getProdutos().getId())
                .dataMovimento(estoque.getDataMovimento())
                .movimento(estoque.getMovimento())
                .quantidade(estoque.getQuantidade())
                .precoUnitario(estoque.getPrecoUnitario())
                .usuarioId(estoque.getUsuarios().getId())
                .build();
    }
}
