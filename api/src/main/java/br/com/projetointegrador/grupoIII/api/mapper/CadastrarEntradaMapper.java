package br.com.projetointegrador.grupoIII.api.mapper;

import br.com.projetointegrador.grupoIII.api.domain.Estoque;
import br.com.projetointegrador.grupoIII.api.domain.Produtos;
import br.com.projetointegrador.grupoIII.api.domain.Usuarios;
import br.com.projetointegrador.grupoIII.api.presentation.request.CadastrarEntradaRequest;
import br.com.projetointegrador.grupoIII.api.presentation.response.CadastrarEntradaResponse;
//import br.com.projetointegrador.grupoIII.api.security.domain.Usuarios;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.*;

public class CadastrarEntradaMapper {

    public static Estoque toEntity(CadastrarEntradaRequest request) {
        return Estoque.builder()
                .quantidade(request.getQuantidade())
                .precoUnitario(request.getPrecoUnitario())
                .movimento(request.getMovimento())
                .dataMovimento(now())
                .produtos(Produtos.builder().id(request.getProdutoId()).build())
                .usuarios(Usuarios.builder().id(request.getUsuarioId()).build())
                .build();
    }

    public static CadastrarEntradaResponse toResponse(Integer id) {
        return CadastrarEntradaResponse.builder()
                .id(id)
                .build();
    }
}
