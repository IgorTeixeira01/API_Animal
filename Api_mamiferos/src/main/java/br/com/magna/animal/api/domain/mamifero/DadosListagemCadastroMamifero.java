package br.com.magna.animal.api.domain.mamifero;

public record DadosListagemCadastroMamifero(Long id, String nome, String cor, Double peso, VertebradoInvertebrado vertebradoInvertebrado, TipoSangue tipoSangue,
		Boolean pelos, Boolean glandulasMamarias, Integer patas) {
	
	public DadosListagemCadastroMamifero(Mamifero mamifero) {
		this(mamifero.getId(), mamifero.getNome(), mamifero.getCor(), mamifero.getPeso(), mamifero.getVertebradoInvertebrado(), 
				mamifero.getTipoSangue(), mamifero.getPelos(), mamifero.getGlandulasMamarias(), mamifero.getPatas());
	}

}
