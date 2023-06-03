package br.com.projetointegrador.grupoIII.api.presentation;

import br.com.projetointegrador.grupoIII.api.presentation.request.AlterarCadastroFornecedorRequest;
import br.com.projetointegrador.grupoIII.api.presentation.request.CadastrarFornecedorRequest;
import br.com.projetointegrador.grupoIII.api.presentation.response.AlterarCadastroFornecedorResponse;
import br.com.projetointegrador.grupoIII.api.presentation.response.CadastrarFornecedorResponse;
import br.com.projetointegrador.grupoIII.api.presentation.response.FornecedorResponse;
//import br.com.projetointegrador.grupoIII.api.security.domain.Funcao;
import br.com.projetointegrador.grupoIII.api.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

//import static br.com.projetointegrador.grupoIII.api.security.domain.Funcao.Nomes.ADMIN;
import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/fornecedores")
public class FornecedoresController {

//    @Autowired
//    MensagemPrivadaService mensagemPrivadaService;

    @Autowired
    CadastrarFornecedorService cadastrarFornecedorService;

    @Autowired
    ListarFornecedoresService listarFornecedoresService;

    @Autowired
    AlterarCadastroFornecedorService alterarCadastroFornecedorService;

    @Autowired
    ExcluirFornecedorService excluirFornecedorService;

//    @GetMapping()
//    public String privado() {
//        return mensagemPrivadaService.gerarMensagem();
//    }

//    @Secured(ADMIN)
    @PostMapping("/cadastrar-fornecedor")
    @ResponseStatus(CREATED)
    public ResponseEntity<CadastrarFornecedorResponse> cadastrarFornecedor(@Valid @RequestBody CadastrarFornecedorRequest request) {
        CadastrarFornecedorResponse response = cadastrarFornecedorService.cadastrarFornecedor(request);
        return ResponseEntity.ok(response);
    }

//    @Secured(ADMIN)
    @GetMapping("/listar-fornecedores")
    public ResponseEntity<List<FornecedorResponse>> listarFornecedores() {
        List<FornecedorResponse> response = listarFornecedoresService.listarFornecedores();
        return ResponseEntity.ok(response);
    }

//    @Secured(ADMIN)
    @GetMapping("/listar-fornecedor-por-codigo")
    public ResponseEntity<List<FornecedorResponse>> listarFornecedoresPorCodigo(@RequestParam List<Integer> codigos) {
        List<FornecedorResponse> response = listarFornecedoresService.listarFornecedoresPorCodigo(codigos);
        return ResponseEntity.ok(response);
    }

//    @Secured(ADMIN)
    @PutMapping("alterar-cadastro/{id}")
    public ResponseEntity<AlterarCadastroFornecedorResponse>
    alterarCadastroFornecedor(@Valid @RequestBody AlterarCadastroFornecedorRequest request, @PathVariable Integer id) {
        AlterarCadastroFornecedorResponse response = alterarCadastroFornecedorService.alterarCadastroFornecedor(request, id);
        return ResponseEntity.ok(response);
    }

//    @Secured(ADMIN)
    @DeleteMapping("/excluirFornecedor/{id}")
    @ResponseStatus(OK)
    public void excluirFornecedor(@PathVariable Integer id) {
        excluirFornecedorService.excluirFornecedor(id);
    }
}
