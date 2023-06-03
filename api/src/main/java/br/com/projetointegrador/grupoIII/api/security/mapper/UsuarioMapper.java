//package br.com.projetointegrador.grupoIII.api.security.mapper;
//
//import br.com.projetointegrador.grupoIII.api.security.controller.request.UsuariosRequest;
//import br.com.projetointegrador.grupoIII.api.security.controller.response.UsuariosResponse;
//import br.com.projetointegrador.grupoIII.api.security.domain.Usuarios;
//
//public class UsuarioMapper {
//
//    public static Usuarios toEntity(UsuariosRequest request) {
//        Usuarios entity = new Usuarios();
//        entity.setNome(request.getNome());
//        entity.setLogin(request.getLogin());
//        return entity;
//    }
//
//    public static UsuariosResponse toResponse(Usuarios entity) {
//        UsuariosResponse response = new UsuariosResponse();
//        response.setId(entity.getId());
//        response.setNome(entity.getNome());
//        response.setLogin(entity.getLogin());
//        return response;
//    }
//}
