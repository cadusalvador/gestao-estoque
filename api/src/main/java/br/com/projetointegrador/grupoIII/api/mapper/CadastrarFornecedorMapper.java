package br.com.projetointegrador.grupoIII.api.mapper;

import br.com.projetointegrador.grupoIII.api.domain.Fornecedores;
import br.com.projetointegrador.grupoIII.api.presentation.request.CadastrarFornecedorRequest;
import br.com.projetointegrador.grupoIII.api.presentation.response.CadastrarFornecedorResponse;

public class CadastrarFornecedorMapper {

    public static Fornecedores toEntity(CadastrarFornecedorRequest request) {
        return Fornecedores.builder()
                .nome(request.getNome())
                .endereco(request.getEndereco())
                .cidade(request.getCidade())
                .estado(request.getEstado())
                .telefone(request.getTelefone())
                .build();
    }

    public static CadastrarFornecedorResponse toResponse(Integer id) {
        return CadastrarFornecedorResponse.builder()
                .id(id)
                .build();
    }
}
