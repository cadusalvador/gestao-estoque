//package br.com.projetointegrador.grupoIII.api.security.service;
//
//import br.com.projetointegrador.grupoIII.api.security.controller.request.UsuariosRequest;
//import br.com.projetointegrador.grupoIII.api.security.controller.response.UsuariosResponse;
//import br.com.projetointegrador.grupoIII.api.security.domain.Permissao;
//import br.com.projetointegrador.grupoIII.api.security.domain.Usuarios;
//import br.com.projetointegrador.grupoIII.api.security.repository.UsuariosRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import static br.com.projetointegrador.grupoIII.api.security.mapper.UsuarioMapper.toEntity;
//import static br.com.projetointegrador.grupoIII.api.security.mapper.UsuarioMapper.toResponse;
//
//@Service
//public class IncluirUsuarioService {
//
//    @Autowired
//    private UsuariosRepository usuariosRepository;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    public UsuariosResponse incluir(UsuariosRequest request) {
//
//        Usuarios usuario = toEntity(request);
//        usuario.setSenha(getSenhaCriptografada(request.getSenha()));
//        usuario.setAtivo(true);
//
//        request.getPermissoes()
//                .forEach(permissao -> usuario.adicionarPermissao(
//                        Permissao.builder().funcao(permissao).build()
//                ));
//
//
//        usuariosRepository.save(usuario);
//
//        return toResponse(usuario);
//    }
//
//    private String getSenhaCriptografada(String senhaAberta) {
//        return passwordEncoder.encode(senhaAberta);
//    }
//
//}
