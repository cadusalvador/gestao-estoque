package br.com.projetointegrador.grupoIII.api.security;

import br.com.projetointegrador.grupoIII.api.security.domain.Usuarios;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.stream.Collectors;

public class UsuarioSecurity implements UserDetails {

    private static final String PREFIXO_PERMISSAO_SPRING = "ROLE_";

    private Integer id;
    private String login;
    private String senha;
    private Boolean ativo;
    private List<SimpleGrantedAuthority> permissoes;

    public UsuarioSecurity(Usuarios usuarios) {
        this.id = usuarios.getId();
        this.login = usuarios.getLogin();
        this.senha = usuarios.getSenha();
        this.ativo = usuarios.getAtivo();
        this.permissoes = convertePermissoes(usuarios);
    }

    private List<SimpleGrantedAuthority> convertePermissoes(Usuarios usuarios) {
        return usuarios.getPermissoes().stream()
                .map(permissao -> new SimpleGrantedAuthority(PREFIXO_PERMISSAO_SPRING + permissao.getDenominacao()))
                .collect(Collectors.toList());
    }

    public Integer getId() {
        return id;
    }

    @Override
    public List<SimpleGrantedAuthority> getAuthorities() {
        return this.permissoes;
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.ativo;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.ativo;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.ativo;
    }

    @Override
    public boolean isEnabled() {
        return this.ativo;
    }
}
