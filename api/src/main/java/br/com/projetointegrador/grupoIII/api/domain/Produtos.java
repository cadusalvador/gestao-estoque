package br.com.projetointegrador.grupoIII.api.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id") @ToString(of = "id")
@Entity
public class Produtos {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    private String nome;
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    private Fornecedores fornecedores;

    @OneToMany(mappedBy = "produtos", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Estoque> estoque;
}
