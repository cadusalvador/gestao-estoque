package br.com.projetointegrador.grupoIII.api.service;

import br.com.projetointegrador.grupoIII.api.domain.Estoque;
import br.com.projetointegrador.grupoIII.api.repository.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

@Service
public class BuscarProdutoNoEstoqueService {

    @Autowired
    private EstoqueRepository estoqueRepository;

    public Estoque porId(Integer id) {
        return estoqueRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(UNPROCESSABLE_ENTITY,
                        "Produto não cadastrado/encontrado no estoque"));
    }
}
