package br.com.projetointegrador.grupoIII.api.security.repository;

import br.com.projetointegrador.grupoIII.api.security.domain.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuarios, Integer> {

    Usuarios findBylogin(String login);
}
