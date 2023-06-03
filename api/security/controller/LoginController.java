package br.com.projetointegrador.grupoIII.api.security.controller;

import br.com.projetointegrador.grupoIII.api.security.controller.response.UsuarioResponse;
import br.com.projetointegrador.grupoIII.api.security.service.BuscarUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private BuscarUsuarioService buscarUsuarioService;

    @PostMapping
    public UsuarioResponse login() {
        return buscarUsuarioService.buscar();
    }
}