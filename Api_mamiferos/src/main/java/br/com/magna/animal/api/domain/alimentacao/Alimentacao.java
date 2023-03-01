package br.com.magna.animal.api.domain.alimentacao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "alimentacao")
@Entity(name = "Alimentacao")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idAlimentacao")
public class Alimentacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAlimentacao;
	private String nomeAlimentacao;
	private Boolean fonteAnimal;
	private Boolean fonteVegetal;
	
	
	public Alimentacao(DadosCadastroAlimentacao dados) {
		this.nomeAlimentacao = dados.nomeAlimentacao();
		this.fonteAnimal = dados.fonteAnimal();
		this.fonteVegetal = dados.fonteVegetal();
	}
	
	public void atualizarInformacoes(DadosAtualizacaoAlimentacao dados) {
		if(dados.nomeAlimentacao() != null) {
			this.nomeAlimentacao = dados.nomeAlimentacao();
		}
		
		if(dados.fonteAnimal() != null) {
			this.fonteAnimal = dados.fonteAnimal();
		}
		
		if(dados.fonteVegetal() != null) {
			this.fonteVegetal = dados.fonteVegetal();
		}
		
	}

}
