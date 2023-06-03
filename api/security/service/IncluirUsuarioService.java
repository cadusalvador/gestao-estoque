package br.com.projetointegrador.grupoIII.api.security.service;

import br.com.projetointegrador.grupoIII.api.security.controller.request.UsuarioRequest;
import br.com.projetointegrador.grupoIII.api.security.controller.response.UsuarioResponse;
import br.com.projetointegrador.grupoIII.api.security.domain.Permissao;
import br.com.projetointegrador.grupoIII.api.security.domain.Usuarios;
import br.com.projetointegrador.grupoIII.api.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import static br.com.projetointegrador.grupoIII.api.security.mapper.UsuarioMapper.toEntity;
import static br.com.projetointegrador.grupoIII.api.security.mapper.UsuarioMapper.toResponse;

@Service
public class IncluirUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UsuarioResponse incluir(UsuarioRequest request) {

        Usuarios usuarios = toEntity(request);
        usuarios.setSenha(passwordEncoder.encode(request.getSenha()));
        usuarios.setAtivo(true);

        request.getPermissoes()
                .forEach(p -> usuarios.adicionarPermissao(Permissao.builder().denominacao(p).build()));

        usuarioRepository.save(usuarios);

        return toResponse(usuarios);
    }
}
