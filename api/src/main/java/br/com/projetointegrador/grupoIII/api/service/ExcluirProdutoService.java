package br.com.projetointegrador.grupoIII.api.service;

import br.com.projetointegrador.grupoIII.api.domain.Fornecedores;
import br.com.projetointegrador.grupoIII.api.domain.Produtos;
import br.com.projetointegrador.grupoIII.api.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ExcluirProdutoService {

    @Autowired
    private ProdutosRepository produtosRepository;

    @Autowired
    private BuscarProdutoService buscarProdutoService;

    @Transactional
    public void excluir(Integer id) {
        Produtos produto = buscarProdutoService.porId(id);
        if (produto != null) {
            Fornecedores fornecedor = produto.getFornecedores();
            if (fornecedor != null) {
                fornecedor.setProdutos(null);
            }
        }
        produtosRepository.delete(produto);
    }
}
