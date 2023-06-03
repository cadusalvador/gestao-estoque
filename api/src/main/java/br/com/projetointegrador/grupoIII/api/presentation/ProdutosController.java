package br.com.projetointegrador.grupoIII.api.presentation;

import br.com.projetointegrador.grupoIII.api.presentation.request.AlterarCadastroProdutoRequest;
import br.com.projetointegrador.grupoIII.api.presentation.request.CadastrarProdutoRequest;
import br.com.projetointegrador.grupoIII.api.presentation.response.CadastrarProdutoResponse;
import br.com.projetointegrador.grupoIII.api.presentation.response.ListarProdutosResponse;
//import br.com.projetointegrador.grupoIII.api.security.domain.Funcao;
import br.com.projetointegrador.grupoIII.api.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//import static br.com.projetointegrador.grupoIII.api.security.domain.Funcao.Nomes.ADMIN;
//import static br.com.projetointegrador.grupoIII.api.security.domain.Funcao.Nomes.USUARIO;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {

//    @Autowired
//    private MensagemPrivadaService mensagemPrivadaService;

    @Autowired
    private CadastrarProdutoService cadastrarProdutoService;

    @Autowired
    private ListarProdutosService listarProdutosService;

    @Autowired
    private AlterarCadastroProdutoService alterarCadastroProdutoService;

    @Autowired
    private ExcluirProdutoService excluirProdutoService;

//    @GetMapping()
//    public String privado() {
//        return mensagemPrivadaService.gerarMensagem();
//    }

//    @Secured(ADMIN)
    @PostMapping("/cadastrar-produto")
    @ResponseStatus(CREATED)
    public ResponseEntity<CadastrarProdutoResponse> cadastrarProduto(@Valid @RequestBody CadastrarProdutoRequest request) {
        CadastrarProdutoResponse response = cadastrarProdutoService.cadastrarProduto(request);
        return ResponseEntity.ok(response);
    }

//    @Secured(USUARIO)
    @GetMapping("/listar-produtos")
    public ResponseEntity<List<ListarProdutosResponse>> listarProdutos() {
        List<ListarProdutosResponse> response = listarProdutosService.listarProdutos();
        return ResponseEntity.ok(response);
    }

//    @Secured(USUARIO)
    @GetMapping("/listar-por-codigo")
    public ResponseEntity<List<ListarProdutosResponse>> listarProdutoPorCodigo(@RequestParam List<Integer> codigos) {
        List<ListarProdutosResponse> response = listarProdutosService.listarProdutosPorCodigo(codigos);
        return ResponseEntity.ok(response);
    }

//    @Secured(ADMIN)
    @PutMapping("/alterar/{id}")
    public void alterarProduto(@Valid @RequestBody AlterarCadastroProdutoRequest request, @PathVariable Integer id) {
        alterarCadastroProdutoService.alterar(request, id);
    }

//    @Secured(ADMIN)
    @DeleteMapping("/excluir/{id}")
    @ResponseStatus(OK)
    public void excluir(@PathVariable Integer id) {
        excluirProdutoService.excluir(id);
    }
}
