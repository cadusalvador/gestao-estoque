package br.com.projetointegrador.grupoIII.api.mapper;

import br.com.projetointegrador.grupoIII.api.domain.Fornecedores;
import br.com.projetointegrador.grupoIII.api.presentation.response.FornecedorResponse;

public class ListarFornecedoresMapper {

    public static FornecedorResponse toResponse(Fornecedores fornecedores) {
        return FornecedorResponse.builder()
                .id(fornecedores.getId())
                .nome(fornecedores.getNome())
                .endereco(fornecedores.getEndereco())
                .cidade(fornecedores.getCidade())
                .estado(fornecedores.getEstado())
                .telefone(fornecedores.getTelefone())
                .build();
    }
}
