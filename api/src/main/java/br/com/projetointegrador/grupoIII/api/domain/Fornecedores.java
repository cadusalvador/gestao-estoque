package br.com.projetointegrador.grupoIII.api.domain;

import br.com.projetointegrador.grupoIII.api.presentation.response.FornecedorResponse;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id") @ToString(of = "id")
@Entity
public class Fornecedores {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    private String nome;
    private String endereco;
    private String cidade;
    private String estado;
    private String telefone;

    @OneToMany(mappedBy = "fornecedores", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Produtos> produtos = new ArrayList<>();

    public void adicionarProduto(Produtos produto) {
        this.getProdutos().add(produto);
        produto.setFornecedores(this);
    }

    public FornecedorResponse toFornecedorResponse() {
        return FornecedorResponse.builder()
                .id(id)
                .nome(nome)
                .endereco(endereco)
                .cidade(cidade)
                .estado(estado)
                .telefone(telefone)
                .build();
    }
}
