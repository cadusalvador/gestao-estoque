//package br.com.projetointegrador.grupoIII.api.security.config;
//
//import br.com.projetointegrador.grupoIII.api.security.repository.UsuariosRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class BuscarUsuarioSecuritySerivce implements UserDetailsService {
//
//    @Autowired
//    private UsuariosRepository usuariosRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
//
//        return usuariosRepository.findByLogin(login)
//                .map(UsuarioSecurity::new)
//                .orElseThrow(() -> new UsernameNotFoundException("Credenciais inválidas"));
//    }
//}
