package br.com.projetointegrador.grupoIII.api.repository;

import br.com.projetointegrador.grupoIII.api.domain.Fornecedores;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FornecedoresRepository extends JpaRepository<Fornecedores, Integer> {
}
