package br.com.projetointegrador.grupoIII.api.presentation.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotBlank;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class AlterarCadastroProdutoRequest {

    @NotBlank
    private String nome;

    @NotBlank
    private String descricao;

    private Integer idFornecedor;

}
