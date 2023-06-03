package br.com.projetointegrador.grupoIII.api.service;

import br.com.projetointegrador.grupoIII.api.mapper.ListarProdutosMapper;
import br.com.projetointegrador.grupoIII.api.presentation.response.ListarProdutosResponse;
import br.com.projetointegrador.grupoIII.api.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class ListarProdutosService {

    @Autowired
    private ProdutosRepository produtosRepository;

    public List<ListarProdutosResponse> listarProdutos() {
        return produtosRepository.findAll().stream()
                .map(ListarProdutosMapper::toResponse)
                .collect(toList());
    }

    public List<ListarProdutosResponse> listarProdutosPorCodigo(List<Integer> codigos) {

        return produtosRepository.findAllById(codigos).stream()
                .map(ListarProdutosMapper::toResponse)
                .collect(toList());
    }
}
