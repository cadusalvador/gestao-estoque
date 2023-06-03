package br.com.projetointegrador.grupoIII.api.domain;

//import br.com.projetointegrador.grupoIII.api.security.domain.Usuarios;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.EnumType.*;
import static javax.persistence.GenerationType.IDENTITY;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id") @ToString(of = "id")
@Entity
public class Estoque {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    private Integer quantidade;
    private Double precoUnitario;

    @Enumerated(STRING)
    private Movimento movimento;
    private LocalDateTime dataMovimento;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produtos produtos;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuarios usuarios;
}
