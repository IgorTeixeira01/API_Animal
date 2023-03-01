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

import br.com.magna.animal.api.domain.mamifero.Mamifero;
import br.com.magna.animal.api.domain.mamifero.MamiferoRepository;
import br.com.magna.animal.api.domain.mamifero.DadosAtualizacaoMamifero;
import br.com.magna.animal.api.domain.mamifero.DadosCadastroMamifero;
import br.com.magna.animal.api.domain.mamifero.DadosListagemMamifero;
import br.com.magna.animal.api.domain.mamifero.DadosListagemCadastroMamifero;
import jakarta.validation.Valid;

@RestController
@RequestMapping("mamiferos")
public class MamiferoController {
	
	@Autowired
	private MamiferoRepository repository;
	
	@PostMapping
    @Transactional
	public ResponseEntity<DadosListagemMamifero> cadastrar(@RequestBody @Valid DadosCadastroMamifero dados, UriComponentsBuilder uriBuilder) {
		Mamifero mamifero = new Mamifero(dados);
		repository.save(mamifero);
		var uri = uriBuilder.path("/mamiferos/{id}").buildAndExpand(mamifero.getId()).toUri(); 
        return ResponseEntity.created(uri).body(new DadosListagemMamifero(mamifero));
	}
	
	
	@GetMapping
	public ResponseEntity<Page<DadosListagemMamifero>> listar(Pageable paginacao){
		var page = repository.findAll(paginacao).map(DadosListagemMamifero::new);
        return ResponseEntity.ok(page);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DadosListagemMamifero> listarPorId(@PathVariable Long id) {
		var mamifero = repository.getReferenceById(id);
		return ResponseEntity.ok(new DadosListagemMamifero(mamifero));
	}
	
	@PutMapping
	@Transactional
	public ResponseEntity<DadosListagemMamifero> atualizar(@RequestBody @Valid DadosAtualizacaoMamifero dados) {
		Mamifero mamifero = repository.getReferenceById(dados.id());
		mamifero.atualizarInformacoes(dados);
		return ResponseEntity.ok(new DadosListagemMamifero(mamifero));
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<String>excluir(@PathVariable Long id) {
		repository.getReferenceById(id);
		repository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
}
