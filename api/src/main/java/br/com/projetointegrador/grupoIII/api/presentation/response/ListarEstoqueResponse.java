package br.com.projetointegrador.grupoIII.api.presentation.response;

import br.com.projetointegrador.grupoIII.api.domain.Movimento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class ListarEstoqueResponse {

    private Integer produtoId;
    private LocalDateTime dataMovimento;
    private Movimento movimento;
    private Integer quantidade;
    private Double precoUnitario;
    private Integer usuarioId;
}
