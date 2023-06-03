package br.com.projetointegrador.grupoIII.api.service;

import br.com.projetointegrador.grupoIII.api.mapper.ListarFornecedoresMapper;
import br.com.projetointegrador.grupoIII.api.presentation.response.FornecedorResponse;
import br.com.projetointegrador.grupoIII.api.repository.FornecedoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class ListarFornecedoresService {

    @Autowired
    private FornecedoresRepository fornecedoresRepository;

    public List<FornecedorResponse> listarFornecedores() {
        return fornecedoresRepository.findAll().stream()
                .map(ListarFornecedoresMapper::toResponse)
                .collect(toList());
    }

    public List<FornecedorResponse> listarFornecedoresPorCodigo(List<Integer> codigos) {
        return fornecedoresRepository.findAllById(codigos).stream()
                .map(ListarFornecedoresMapper::toResponse)
                .collect(toList());
    }
}
