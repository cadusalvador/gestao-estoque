package br.com.projetointegrador.grupoIII.api.presentation.request;

import br.com.projetointegrador.grupoIII.api.domain.Movimento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class CadastrarEntradaRequest {

    @NotNull
    private Integer quantidade;

    @NotNull
    private Double precoUnitario;

    @NotNull
    private Movimento movimento;

    @NotNull
    private Integer produtoId;

    @NotNull
    private Integer usuarioId;
}
