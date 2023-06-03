package br.com.projetointegrador.grupoIII.api.presentation.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class AlterarCadastroFornecedorResponse {

    private String nome;
    private String endereco;
    private String cidade;
    private String estado;
    private String telefone;
}
