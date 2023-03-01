package br.com.magna.animal.api.domain.mamifero;

import br.com.magna.animal.api.domain.alimentacao.Alimentacao;
import br.com.magna.animal.api.domain.tipomamifero.TipoMamifero;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "mamiferos")
@Entity(name = "Mamifero")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Mamifero {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String cor;
	private Double peso;

	@Enumerated(EnumType.STRING)
	private VertebradoInvertebrado vertebradoInvertebrado;
	@Enumerated(EnumType.STRING)
	private TipoSangue tipoSangue;

	private Boolean pelos;
	private Boolean glandulasMamarias;
	private Integer patas;
	
	@ManyToOne
	@JoinColumn(name = "id_tipo")
	private TipoMamifero tipoMamifero;
	
	@ManyToOne
	@JoinColumn(name = "id_alimentacao")
	private Alimentacao alimentacao;

	public Mamifero(DadosCadastroMamifero dados) {
		this.nome = dados.nome();
		this.cor = dados.cor();
		this.peso = dados.peso();
		this.vertebradoInvertebrado = dados.vertebradoInvertebrado();
		this.tipoSangue = dados.tipoSangue();
		this.pelos = dados.pelos();
		this.glandulasMamarias = dados.glandulasMamarias();
		this.patas = dados.patas();
		this.tipoMamifero = dados.tipoMamifero();
		this.alimentacao = dados.alimentacao();
	}

	public void atualizarInformacoes(DadosAtualizacaoMamifero dados) {
		if(dados.nome() != null) {
			this.nome = dados.nome();
		}
		
		if(dados.cor() != null) {
			this.cor = dados.cor();
		}
		
		if(dados.peso() != null) {
			this.peso = dados.peso();
		}
		
		if(dados.pelos() != null) {
			this.pelos = dados.pelos();
		}
		
		if(dados.patas() != null) {
			this.patas = dados.patas();
		}
		
	}

}
