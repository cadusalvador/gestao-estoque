//package br.com.projetointegrador.grupoIII.api.security.config;
//
//import br.com.projetointegrador.grupoIII.api.security.domain.Usuarios;
//import lombok.Getter;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Getter
//public class UsuarioSecurity implements UserDetails {
//
//    private final Integer id;
//    private final String username;
//    private final String password;
//    private final List<SimpleGrantedAuthority> authorities;
//
//    private final boolean accountNonExpired;
//    private final boolean accountNonLocked;
//    private final boolean credentialsNonExpired;
//    private final boolean enabled;
//
//    public UsuarioSecurity(Usuarios usuario) {
//
//        this.id = usuario.getId();
//        this.username = usuario.getLogin();
//        this.password = usuario.getSenha();
//
//        this.accountNonExpired = usuario.isAtivo();
//        this.accountNonLocked = usuario.isAtivo();
//        this.credentialsNonExpired = usuario.isAtivo();
//        this.enabled = usuario.isAtivo();
//
//        this.authorities = usuario.getPermissoes().stream()
//                .map(permissao -> new SimpleGrantedAuthority(permissao.getFuncao().getRole()))
//                .collect(Collectors.toList());
//    }
//}
