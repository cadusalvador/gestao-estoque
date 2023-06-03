package br.com.projetointegrador.grupoIII.api.mapper;

import br.com.projetointegrador.grupoIII.api.domain.Fornecedores;
import br.com.projetointegrador.grupoIII.api.domain.Produtos;
import br.com.projetointegrador.grupoIII.api.presentation.request.AlterarCadastroProdutoRequest;

public class AlterarCadastroProdutoMapper {

    public static Produtos toEntity(AlterarCadastroProdutoRequest request) {
        return Produtos.builder()
                .nome(request.getNome())
                .descricao(request.getDescricao())
                .fornecedores(Fornecedores.builder().id(request.getIdFornecedor()).build())
                .build();
    }
}
