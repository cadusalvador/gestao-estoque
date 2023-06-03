package br.com.projetointegrador.grupoIII.api.service;

import br.com.projetointegrador.grupoIII.api.domain.Estoque;
import br.com.projetointegrador.grupoIII.api.presentation.request.CadastrarEntradaRequest;
import br.com.projetointegrador.grupoIII.api.presentation.response.CadastrarEntradaResponse;
import br.com.projetointegrador.grupoIII.api.repository.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static br.com.projetointegrador.grupoIII.api.mapper.CadastrarEntradaMapper.toEntity;
import static br.com.projetointegrador.grupoIII.api.mapper.CadastrarEntradaMapper.toResponse;

@Service
public class CadastrarEntradaService {

    @Autowired
    private EstoqueRepository estoqueRepository;

    public CadastrarEntradaResponse cadastrarEntrada(CadastrarEntradaRequest request) {

        Estoque estoque = toEntity(request);

        estoqueRepository.save(estoque);

        return toResponse(estoque.getId());
    }
}
