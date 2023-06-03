package br.com.projetointegrador.grupoIII.api.mapper;

import br.com.projetointegrador.grupoIII.api.domain.Fornecedores;
import br.com.projetointegrador.grupoIII.api.presentation.request.AlterarCadastroFornecedorRequest;
import br.com.projetointegrador.grupoIII.api.presentation.response.AlterarCadastroFornecedorResponse;

public class AlterarCadastroFornecedorMapper {

    public static Fornecedores toEntity(AlterarCadastroFornecedorRequest request) {
        return Fornecedores.builder()
                .nome(request.getNome())
                .endereco(request.getEndereco())
                .cidade(request.getCidade())
                .estado(request.getEstado())
                .telefone(request.getTelefone())
                .build();
    }

    public static AlterarCadastroFornecedorResponse toResponse(Fornecedores response) {
        return AlterarCadastroFornecedorResponse.builder()
                .nome(response.getNome())
                .endereco(response.getEndereco())
                .cidade(response.getCidade())
                .estado(response.getEstado())
                .telefone(response.getTelefone())
                .build();
    }
}
