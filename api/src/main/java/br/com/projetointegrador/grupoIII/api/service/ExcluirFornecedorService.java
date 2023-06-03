package br.com.projetointegrador.grupoIII.api.service;

import br.com.projetointegrador.grupoIII.api.domain.Fornecedores;
import br.com.projetointegrador.grupoIII.api.repository.FornecedoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ExcluirFornecedorService {

    @Autowired
    FornecedoresRepository fornecedoresRepository;

    @Autowired
    private BuscarFornecedoresService buscarFornecedoresService;

    @Transactional
    public void excluirFornecedor(Integer id) {
        Fornecedores fornecedor = buscarFornecedoresService.porId(id);

        fornecedoresRepository.delete(fornecedor);
    }
}
