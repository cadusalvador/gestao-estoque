package br.com.projetointegrador.grupoIII.api.service;

import br.com.projetointegrador.grupoIII.api.domain.Fornecedores;
import br.com.projetointegrador.grupoIII.api.presentation.request.CadastrarFornecedorRequest;
import br.com.projetointegrador.grupoIII.api.presentation.response.CadastrarFornecedorResponse;
import br.com.projetointegrador.grupoIII.api.repository.FornecedoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static br.com.projetointegrador.grupoIII.api.mapper.CadastrarFornecedorMapper.toEntity;
import static br.com.projetointegrador.grupoIII.api.mapper.CadastrarFornecedorMapper.toResponse;

@Service
public class CadastrarFornecedorService {

    @Autowired
    private FornecedoresRepository fornecedoresRepository;
    public CadastrarFornecedorResponse cadastrarFornecedor(CadastrarFornecedorRequest request) {

        Fornecedores fornecedores = toEntity(request);

        fornecedoresRepository.save(fornecedores);

        return toResponse(fornecedores.getId());
    }
}
