//package br.com.projetointegrador.grupoIII.api.security.controller;
//
//import br.com.projetointegrador.grupoIII.api.security.controller.request.UsuariosRequest;
//import br.com.projetointegrador.grupoIII.api.security.controller.response.UsuariosResponse;
//import br.com.projetointegrador.grupoIII.api.security.service.IncluirUsuarioService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/usuarios")
//public class UsuarioController {
//
//    @Autowired
//    private IncluirUsuarioService service;
//
//    @PostMapping
//    public UsuariosResponse incluir(@RequestBody UsuariosRequest request) {
//        return service.incluir(request);
//    }
//}
