package br.com.projetointegrador.grupoIII.api.service;

import br.com.projetointegrador.grupoIII.api.domain.Fornecedores;
import br.com.projetointegrador.grupoIII.api.mapper.AlterarCadastroFornecedorMapper;
import br.com.projetointegrador.grupoIII.api.presentation.request.AlterarCadastroFornecedorRequest;
import br.com.projetointegrador.grupoIII.api.presentation.response.AlterarCadastroFornecedorResponse;
import br.com.projetointegrador.grupoIII.api.repository.FornecedoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AlterarCadastroFornecedorService {

    @Autowired
    private FornecedoresRepository fornecedoresRepository;

    @Autowired
    private BuscarFornecedoresService buscarFornecedoresService;

    @Transactional
    public AlterarCadastroFornecedorResponse alterarCadastroFornecedor(AlterarCadastroFornecedorRequest request, Integer id) {
        Fornecedores fornecedor = buscarFornecedoresService.porId(id);

        Fornecedores fornecedorAlterado = AlterarCadastroFornecedorMapper.toEntity(request);
        fornecedor.setNome(fornecedorAlterado.getNome());
        fornecedor.setEndereco(fornecedorAlterado.getEndereco());
        fornecedor.setCidade(fornecedorAlterado.getCidade());
        fornecedor.setEstado(fornecedorAlterado.getEstado());
        fornecedor.setTelefone(fornecedorAlterado.getTelefone());

        fornecedoresRepository.save(fornecedor);

        return AlterarCadastroFornecedorMapper.toResponse(fornecedor);
    }
}
