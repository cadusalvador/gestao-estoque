package br.com.projetointegrador.grupoIII.api.presentation;

import br.com.projetointegrador.grupoIII.api.presentation.request.AdicionarProdutoNoEstoqueRequest;
import br.com.projetointegrador.grupoIII.api.presentation.request.CadastrarEntradaRequest;
import br.com.projetointegrador.grupoIII.api.presentation.request.VenderProdutoRequest;
import br.com.projetointegrador.grupoIII.api.presentation.response.AdicionarProdutoNoEstoqueResponse;
import br.com.projetointegrador.grupoIII.api.presentation.response.CadastrarEntradaResponse;
import br.com.projetointegrador.grupoIII.api.presentation.response.ListarEstoqueResponse;
import br.com.projetointegrador.grupoIII.api.presentation.response.VenderProdutoResponse;
//import br.com.projetointegrador.grupoIII.api.security.domain.Funcao;
import br.com.projetointegrador.grupoIII.api.service.AdicionarProdutoNoEstoqueService;
import br.com.projetointegrador.grupoIII.api.service.CadastrarEntradaService;
//import br.com.projetointegrador.grupoIII.api.service.MensagemPrivadaService;
import br.com.projetointegrador.grupoIII.api.service.ListarEstoqueService;
import br.com.projetointegrador.grupoIII.api.service.VenderProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//import static br.com.projetointegrador.grupoIII.api.security.domain.Funcao.Nomes.ADMIN;
//import static br.com.projetointegrador.grupoIII.api.security.domain.Funcao.Nomes.USUARIO;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {

//    @Autowired
//    private MensagemPrivadaService mensagemPrivadaService;

    @Autowired
    private CadastrarEntradaService cadastrarEntradaService;

    @Autowired
    private ListarEstoqueService listarEstoqueService;

    @Autowired
    private VenderProdutoService venderProdutoService;

    @Autowired
    private AdicionarProdutoNoEstoqueService adicionarProdutoNoEstoqueService;

//    @GetMapping()
//    public String privado() {
//        return mensagemPrivadaService.gerarMensagem();
//    }

//    @Secured(ADMIN)
    @PostMapping("/cadastrar-entrada")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CadastrarEntradaResponse> cadastrarEntrada(@Valid @RequestBody CadastrarEntradaRequest request) {
        CadastrarEntradaResponse response = cadastrarEntradaService.cadastrarEntrada(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ListarEstoqueResponse>> listarEstoque(@RequestParam List<Integer> codigos) {
        List<ListarEstoqueResponse> response = listarEstoqueService.listar(codigos);
        return ResponseEntity.ok(response);
    }

//    @Secured(USUARIO)
    @PutMapping("/vender/{id}")
    public ResponseEntity<VenderProdutoResponse> venderProduto(@PathVariable Integer id, @Valid @RequestBody VenderProdutoRequest request) {
        VenderProdutoResponse response = venderProdutoService.venderProduto(id, request);
        return ResponseEntity.ok(response);
    }

//    @Secured(ADMIN)
    @PutMapping("/adicionar-produto/{id}")
    public ResponseEntity<AdicionarProdutoNoEstoqueResponse> adicionarProdutoNoEstoque(@PathVariable Integer id, @Valid @RequestBody AdicionarProdutoNoEstoqueRequest request) {
        AdicionarProdutoNoEstoqueResponse response = adicionarProdutoNoEstoqueService.adicionarProduto(id, request);
        return ResponseEntity.ok(response);
    }
}
