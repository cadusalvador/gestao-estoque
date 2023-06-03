package br.com.projetointegrador.grupoIII.api.presentation.response;

import br.com.projetointegrador.grupoIII.api.domain.Fornecedores;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class ListarProdutosResponse {

    private Integer id;
    private String nome;
    private String descricao;
    private FornecedorResponse fornecedor;

}
