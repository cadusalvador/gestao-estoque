package br.com.projetointegrador.grupoIII.api.service;

import br.com.projetointegrador.grupoIII.api.mapper.ListarEstoqueMapper;
import br.com.projetointegrador.grupoIII.api.presentation.response.ListarEstoqueResponse;
import br.com.projetointegrador.grupoIII.api.repository.EstoqueRepository;
import br.com.projetointegrador.grupoIII.api.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListarEstoqueService {

    @Autowired
    private EstoqueRepository estoqueRepository;

    @Autowired
    private ProdutosRepository produtosRepository;

    public List<ListarEstoqueResponse> listar(List<Integer> codigos) {
        return estoqueRepository.findAllById(codigos).stream()
                .map(ListarEstoqueMapper::toResponse)
                .collect(Collectors.toList());
    }

    private List<Integer> buscarIdsProdutos(List<Integer> codigosProduto) {
        return estoqueRepository.findDistinctProdutoIdByEstoqueIdIn(codigosProduto);
    }
}
