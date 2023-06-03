package br.com.projetointegrador.grupoIII.api.security.service;

import br.com.projetointegrador.grupoIII.api.security.controller.response.UsuarioResponse;
import br.com.projetointegrador.grupoIII.api.security.domain.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static br.com.projetointegrador.grupoIII.api.security.mapper.UsuarioMapper.toResponse;

@Service
public class BuscarUsuarioService {

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    public UsuarioResponse buscar() {
        Usuarios usuariosAutenticado = usuarioAutenticadoService.get();
        return toResponse(usuariosAutenticado);
    }
}
