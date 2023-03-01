package br.com.magna.animal.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.magna.animal.api.domain.alimentacao.Alimentacao;
import br.com.magna.animal.api.domain.alimentacao.AlimentacaoRepository;
import br.com.magna.animal.api.domain.alimentacao.DadosAtualizacaoAlimentacao;
import br.com.magna.animal.api.domain.alimentacao.DadosCadastroAlimentacao;
import br.com.magna.animal.api.domain.alimentacao.DadosListagemAlimentacao;
import jakarta.validation.Valid;

@RestController
@RequestMapping("alimentacao")
public class AlimentacaoController {
	
	@Autowired
	private AlimentacaoRepository repository;
	
	@PostMapping
    @Transactional
	public ResponseEntity<DadosListagemAlimentacao> cadastrar(@RequestBody @Valid DadosCadastroAlimentacao dados, UriComponentsBuilder uriBuilder) {
		Alimentacao alimentacao = new Alimentacao(dados);
		repository.save(alimentacao);
		var uri = uriBuilder.path("/alimentacao/{id}").buildAndExpand(alimentacao.getIdAlimentacao()).toUri(); 
        return ResponseEntity.created(uri).body(new DadosListagemAlimentacao(alimentacao));
	}
	
	
	@GetMapping
	public ResponseEntity<Page<DadosListagemAlimentacao>> listar(Pageable paginacao){
		var page = repository.findAll(paginacao).map(DadosListagemAlimentacao::new);
        return ResponseEntity.ok(page);
	}
	
	@GetMapping("/{idAlimentacao}")
	public ResponseEntity<DadosListagemAlimentacao> listarPorId(@PathVariable Long idAlimentacao) {
		var alimentacao = repository.getReferenceById(idAlimentacao);
		return ResponseEntity.ok(new DadosListagemAlimentacao(alimentacao));
	}
	
	@PutMapping
	@Transactional
	public ResponseEntity<DadosListagemAlimentacao> atualizar(@RequestBody @Valid DadosAtualizacaoAlimentacao dados) {
		Alimentacao alimentacao = repository.getReferenceById(dados.idAlimentacao());
		alimentacao.atualizarInformacoes(dados);
		return ResponseEntity.ok(new DadosListagemAlimentacao(alimentacao));
	}
	
	@DeleteMapping("/{idAlimentacao}")
	@Transactional
	public ResponseEntity<String>excluir(@PathVariable Long idAlimentacao) {
		repository.getReferenceById(idAlimentacao);
		repository.deleteById(idAlimentacao);
		return ResponseEntity.noContent().build();
	}
	
}
