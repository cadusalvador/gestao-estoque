//package br.com.projetointegrador.grupoIII.api.security.service;
//
//import br.com.projetointegrador.grupoIII.api.security.config.UsuarioSecurity;
//import br.com.projetointegrador.grupoIII.api.security.controller.response.UsuariosResponse;
//import br.com.projetointegrador.grupoIII.api.security.domain.Usuarios;
//import br.com.projetointegrador.grupoIII.api.security.repository.UsuariosRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Service;
//
//import static br.com.projetointegrador.grupoIII.api.security.mapper.UsuarioMapper.toResponse;
//import static java.util.Objects.isNull;
//import static java.util.Objects.nonNull;
//
//@Service
//public class UsuarioAutenticadoService {
//
//    @Autowired
//    private UsuariosRepository usuariosRepository;
//
//    public Integer getId() {
//
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//        if (authentication.getPrincipal() instanceof UsuarioSecurity) {
//            return ((UsuarioSecurity) authentication.getPrincipal()).getId();
//        }
//
//        return null;
//    }
//
//    public Usuarios get() {
//        Integer id = getId();
//
//        if (isNull(id)) {
//            return null;
//        }
//
//        return usuariosRepository.findById(getId()).orElse(null);
//    }
//
//    public UsuariosResponse getResponse() {
//        Usuarios entity = get();
//        return nonNull(entity) ? toResponse(entity) : new UsuariosResponse();
//    }
//}
