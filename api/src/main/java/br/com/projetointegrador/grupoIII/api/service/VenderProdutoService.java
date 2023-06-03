package br.com.projetointegrador.grupoIII.api.service;

import br.com.projetointegrador.grupoIII.api.domain.Estoque;
import br.com.projetointegrador.grupoIII.api.mapper.VenderProdutoMapper;
import br.com.projetointegrador.grupoIII.api.presentation.request.VenderProdutoRequest;
import br.com.projetointegrador.grupoIII.api.presentation.response.VenderProdutoResponse;
import br.com.projetointegrador.grupoIII.api.repository.EstoqueRepository;
import br.com.projetointegrador.grupoIII.api.service.exception.EstoqueBaixoException;
import br.com.projetointegrador.grupoIII.api.service.exception.EstoqueInsuficienteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static br.com.projetointegrador.grupoIII.api.mapper.VenderProdutoMapper.*;

@Service
public class VenderProdutoService {

    @Autowired
    private EstoqueRepository estoqueRepository;

    @Autowired
    private BuscarProdutoNoEstoqueService buscarProdutoNoEstoqueService;

    @Transactional
    public VenderProdutoResponse venderProduto(Integer id, VenderProdutoRequest request) {
        Estoque estoque = buscarProdutoNoEstoqueService.porId(id);
        Integer quantidadeDeSeguranca = 10;
        String mensagemEstoqueBaixo = "Estoque baixo. Por favor, reabasteça!";
        String mensagemEstoqueInsuficiente = "Estoque baixo. Por favor, reabasteça!";

        if (estoque.getQuantidade() <= quantidadeDeSeguranca) {
            throw new EstoqueBaixoException(mensagemEstoqueBaixo);
        }

        Estoque produtoVendido = toEntity(request);
        Integer quantidadeAtual = estoque.getQuantidade();
        Integer quantidadeVendida = produtoVendido.getQuantidade();

        if(quantidadeAtual < quantidadeVendida) {
            throw new EstoqueInsuficienteException(mensagemEstoqueInsuficiente);
        }

        Integer novaQuantidade = quantidadeAtual - quantidadeVendida;
        estoque.setQuantidade(novaQuantidade);

        estoqueRepository.save(estoque);

        return  toResponse(estoque.getId());
    }
}
