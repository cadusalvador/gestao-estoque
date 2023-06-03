package br.com.projetointegrador.grupoIII.api.repository;

import br.com.projetointegrador.grupoIII.api.domain.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EstoqueRepository extends JpaRepository<Estoque, Integer> {

    @Query("SELECT DISTINCT e.produtos FROM Estoque e WHERE e.id IN :codigos")
    List<Integer> findDistinctProdutoIdByEstoqueIdIn(@Param("codigos") List<Integer> codigos);
}
