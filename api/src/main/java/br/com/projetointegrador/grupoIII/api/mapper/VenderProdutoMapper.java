package br.com.projetointegrador.grupoIII.api.mapper;

import br.com.projetointegrador.grupoIII.api.domain.Estoque;
import br.com.projetointegrador.grupoIII.api.presentation.request.VenderProdutoRequest;
import br.com.projetointegrador.grupoIII.api.presentation.response.VenderProdutoResponse;

public class VenderProdutoMapper {

    public static Estoque toEntity(VenderProdutoRequest request) {
        return Estoque.builder()
                .quantidade(request.getQuantidade())
                .build();
    }

    public static VenderProdutoResponse toResponse(Integer id) {
        return VenderProdutoResponse.builder()
                .id(id)
                .build();
    }
}
