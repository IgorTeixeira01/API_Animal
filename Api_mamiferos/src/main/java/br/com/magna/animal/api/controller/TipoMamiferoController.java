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

import br.com.magna.animal.api.domain.tipomamifero.DadosAtualizacaoTipoMamifero;
import br.com.magna.animal.api.domain.tipomamifero.DadosCadastroTipoMamifero;
import br.com.magna.animal.api.domain.tipomamifero.DadosListagemTipoMamifero;
import br.com.magna.animal.api.domain.tipomamifero.TipoMamifero;
import br.com.magna.animal.api.domain.tipomamifero.TipoMamiferoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("tipomamifero")
public class TipoMamiferoController {
	
	@Autowired
	private TipoMamiferoRepository repository;
	
	@PostMapping
    @Transactional
	public ResponseEntity<DadosListagemTipoMamifero> cadastrar(@RequestBody @Valid DadosCadastroTipoMamifero dados, UriComponentsBuilder uriBuilder) {
		TipoMamifero tipoMamifero = new TipoMamifero(dados);
		repository.save(tipoMamifero);
		var uri = uriBuilder.path("/tipomamifero/{idTipo}").buildAndExpand(tipoMamifero.getIdTipo()).toUri(); 
        return ResponseEntity.created(uri).body(new DadosListagemTipoMamifero(tipoMamifero));
	}
	
	@GetMapping
	public ResponseEntity<Page<DadosListagemTipoMamifero>> listar(Pageable paginacao){
		var page = repository.findAll(paginacao).map(DadosListagemTipoMamifero::new);
        return ResponseEntity.ok(page);
	}
	
	@GetMapping("/{idTipo}")
	public ResponseEntity<DadosListagemTipoMamifero> listarPorId(@PathVariable Long idTipo) {
		var tipoMamifero = repository.getReferenceById(idTipo);
		return ResponseEntity.ok(new DadosListagemTipoMamifero(tipoMamifero));
	}
	
	@PutMapping
	@Transactional
	public ResponseEntity<DadosListagemTipoMamifero> atualizar(@RequestBody @Valid DadosAtualizacaoTipoMamifero dados) {
		TipoMamifero tipoMamifero = repository.getReferenceById(dados.idTipo());
		tipoMamifero.atualizarInformacoes(dados);
		return ResponseEntity.ok(new DadosListagemTipoMamifero(tipoMamifero));
	}
	
	@DeleteMapping("/{idTipo}")
	@Transactional
	public ResponseEntity<String>excluir(@PathVariable Long idTipo) {
		repository.getReferenceById(idTipo);
		repository.deleteById(idTipo);
		return ResponseEntity.noContent().build();
	}

}
