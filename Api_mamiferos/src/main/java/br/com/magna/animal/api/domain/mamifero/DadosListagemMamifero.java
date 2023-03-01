package br.com.magna.animal.api.domain.mamifero;

import br.com.magna.animal.api.domain.alimentacao.Alimentacao;
import br.com.magna.animal.api.domain.tipomamifero.TipoMamifero;

public record DadosListagemMamifero(Long id, String nome, String cor, Double peso, VertebradoInvertebrado vertebradoInvertebrado, TipoSangue tipoSangue,
		Boolean pelos, Boolean glandulasMamarias, Integer patas, TipoMamifero tipoMamifero, Alimentacao alimentacao) {
	
	public DadosListagemMamifero(Mamifero mamifero) {
		this(mamifero.getId(), mamifero.getNome(), mamifero.getCor(), mamifero.getPeso(), mamifero.getVertebradoInvertebrado(), 
				mamifero.getTipoSangue(), mamifero.getPelos(), mamifero.getGlandulasMamarias(), mamifero.getPatas(), mamifero.getTipoMamifero(), mamifero.getAlimentacao());
	}

}
