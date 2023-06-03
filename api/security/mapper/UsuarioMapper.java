package br.com.projetointegrador.grupoIII.api.security.mapper;

import br.com.projetointegrador.grupoIII.api.security.controller.request.UsuarioRequest;
import br.com.projetointegrador.grupoIII.api.security.controller.response.UsuarioResponse;
import br.com.projetointegrador.grupoIII.api.security.domain.Permissao;
import br.com.projetointegrador.grupoIII.api.security.domain.Usuarios;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class UsuarioMapper {

    public static Usuarios toEntity(UsuarioRequest request) {
        return Usuarios.builder()
                .nome(request.getNome())
                .login(request.getLogin())
                .build();
    }

    public static UsuarioResponse toResponse(Usuarios entity) {
        return UsuarioResponse.builder()
                .nome(entity.getNome())
                .login(entity.getLogin())
                .permissoes(buildPermissoesResponse(entity.getPermissoes()))
                .build();
    }

    private static List<String> buildPermissoesResponse(List<Permissao> permissoes) {
        return permissoes.stream()
                .map(Permissao::getDenominacao)
                .collect(toList());
    }
}
