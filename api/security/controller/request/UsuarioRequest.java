package br.com.projetointegrador.grupoIII.api.security.controller.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter @Setter
public class UsuarioRequest {

    @NotBlank
    private String nome;

    @NotNull
    private String login;

    @NotBlank
    private String senha;

    @NotNull @NotEmpty
    private List<String> permissoes;

}
