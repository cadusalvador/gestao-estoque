package br.com.projetointegrador.grupoIII.api.security.domain;

import br.com.projetointegrador.grupoIII.api.domain.Estoque;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@SuperBuilder
@Getter @Setter @EqualsAndHashCode(of = "id") @ToString(of = "id")
public class Usuarios {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    private String nome;
    private String login;
    private String senha;
    private Boolean ativo;

    @OneToMany(mappedBy = "usuarios", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Permissao> permissoes = new ArrayList<>();

    @OneToOne(mappedBy = "usuarios", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Estoque estoque;

    public void adicionarPermissao(Permissao permissao) {
        this.permissoes.add(permissao);
        permissao.setUsuarios(this);
    }
}
