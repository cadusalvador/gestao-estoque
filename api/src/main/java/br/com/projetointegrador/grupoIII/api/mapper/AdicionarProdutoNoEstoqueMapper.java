package br.com.projetointegrador.grupoIII.api.mapper;

import br.com.projetointegrador.grupoIII.api.domain.Estoque;
import br.com.projetointegrador.grupoIII.api.presentation.request.AdicionarProdutoNoEstoqueRequest;
import br.com.projetointegrador.grupoIII.api.presentation.response.AdicionarProdutoNoEstoqueResponse;

public class AdicionarProdutoNoEstoqueMapper {

    public static Estoque toEntity(AdicionarProdutoNoEstoqueRequest request){
        return Estoque.builder()
                .quantidade(request.getQuantidade())
                .build();
    }

    public static AdicionarProdutoNoEstoqueResponse toResponse(Integer id) {
        return AdicionarProdutoNoEstoqueResponse.builder()
                .id(id)
                .build();
    }
}
