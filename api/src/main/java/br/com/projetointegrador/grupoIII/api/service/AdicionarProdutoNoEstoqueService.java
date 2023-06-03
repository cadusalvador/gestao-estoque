package br.com.projetointegrador.grupoIII.api.service;

import br.com.projetointegrador.grupoIII.api.domain.Estoque;
import br.com.projetointegrador.grupoIII.api.mapper.AdicionarProdutoNoEstoqueMapper;
import br.com.projetointegrador.grupoIII.api.presentation.request.AdicionarProdutoNoEstoqueRequest;
import br.com.projetointegrador.grupoIII.api.presentation.response.AdicionarProdutoNoEstoqueResponse;
import br.com.projetointegrador.grupoIII.api.repository.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdicionarProdutoNoEstoqueService {

    @Autowired
    private EstoqueRepository estoqueRepository;

    @Autowired
    private BuscarProdutoNoEstoqueService buscarProdutoNoEstoqueService;

    @Transactional
    public AdicionarProdutoNoEstoqueResponse adicionarProduto(Integer id, AdicionarProdutoNoEstoqueRequest request) {
        Estoque estoque = buscarProdutoNoEstoqueService.porId(id);

        Estoque produtoVendido = AdicionarProdutoNoEstoqueMapper.toEntity(request);
        Integer quantidadeAtual = estoque.getQuantidade();
        Integer quantidadeParaAdicionar = produtoVendido.getQuantidade();

        Integer novaQuantidade = quantidadeAtual + quantidadeParaAdicionar;
        estoque.setQuantidade(novaQuantidade);

        estoqueRepository.save(estoque);

        return AdicionarProdutoNoEstoqueMapper.toResponse(estoque.getId());
    }
}
