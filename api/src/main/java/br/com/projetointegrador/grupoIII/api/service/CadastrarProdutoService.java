package br.com.projetointegrador.grupoIII.api.service;

import br.com.projetointegrador.grupoIII.api.domain.Produtos;
import br.com.projetointegrador.grupoIII.api.presentation.request.CadastrarProdutoRequest;
import br.com.projetointegrador.grupoIII.api.presentation.response.CadastrarProdutoResponse;
import br.com.projetointegrador.grupoIII.api.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static br.com.projetointegrador.grupoIII.api.mapper.CadastrarProdutoMapper.toEntity;
import static br.com.projetointegrador.grupoIII.api.mapper.CadastrarProdutoMapper.toResponse;

@Service
public class CadastrarProdutoService {

    @Autowired
    private ProdutosRepository produtosRepository;

    @Transactional
    public CadastrarProdutoResponse cadastrarProduto(CadastrarProdutoRequest request) {

        Produtos produtos = toEntity(request);

        produtosRepository.save(produtos);

        return toResponse(produtos.getId());
    }
}
