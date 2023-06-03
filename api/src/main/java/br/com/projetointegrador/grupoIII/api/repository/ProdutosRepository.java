package br.com.projetointegrador.grupoIII.api.repository;

import br.com.projetointegrador.grupoIII.api.domain.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutosRepository extends JpaRepository<Produtos, Integer> {
}
