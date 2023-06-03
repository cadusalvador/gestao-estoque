package br.com.projetointegrador.grupoIII.api.service;

import br.com.projetointegrador.grupoIII.api.domain.Fornecedores;
import br.com.projetointegrador.grupoIII.api.domain.Produtos;
import br.com.projetointegrador.grupoIII.api.presentation.request.AlterarCadastroProdutoRequest;
import br.com.projetointegrador.grupoIII.api.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static br.com.projetointegrador.grupoIII.api.mapper.AlterarCadastroProdutoMapper.toEntity;

@Service
public class AlterarCadastroProdutoService {

    @Autowired
    private ProdutosRepository produtosRepository;

    @Autowired
    private BuscarProdutoService buscarProdutoService;

    @Transactional
    public void alterar(AlterarCadastroProdutoRequest request, Integer id) {
        Produtos produto = buscarProdutoService.porId(id);

        Produtos produtoAlterado = toEntity(request);
        produto.setNome(produtoAlterado.getNome());
        produto.setDescricao(produtoAlterado.getDescricao());

        Fornecedores novoFornecedor = produtoAlterado.getFornecedores();
        Fornecedores fornecedorAtual = produto.getFornecedores();

        if (!novoFornecedor.getId().equals(fornecedorAtual.getId())) {
            produto.setFornecedores(novoFornecedor);
        }

        produtosRepository.save(produto);
    }
}
