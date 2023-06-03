package br.com.projetointegrador.grupoIII.api.security.service;

import br.com.projetointegrador.grupoIII.api.security.UsuarioSecurity;
import br.com.projetointegrador.grupoIII.api.security.domain.Usuarios;
import br.com.projetointegrador.grupoIII.api.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class BuscarUsuarioSecurityService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Usuarios usuarios = usuarioRepository.findBylogin(login);
        return new UsuarioSecurity(usuarios);
    }
}
