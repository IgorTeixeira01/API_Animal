package br.com.magna.animal.api.domain.tipomamifero;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "tipos_mamiferos")
@Entity(name = "TipoMamifero")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idTipo")
public class TipoMamifero {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTipo;
	private String nomeTipo;
	private Boolean mamilos;
	private Boolean marsupio;
	private Boolean placenta;
	
	
	public TipoMamifero(DadosCadastroTipoMamifero dados) {
		this.nomeTipo = dados.nomeTipo();
		this.mamilos = dados.mamilos();
		this.marsupio = dados.marsupio();
		this.placenta = dados.placenta();
	}
	
	public void atualizarInformacoes(DadosAtualizacaoTipoMamifero dados) {
		if(dados.nomeTipo() != null) {
			this.nomeTipo = dados.nomeTipo();
		}
		
		if(dados.mamilos() != null) {
			this.mamilos = dados.mamilos();
		}
		
		if(dados.marsupio() != null) {
			this.marsupio = dados.marsupio();
		}
		
		if(dados.placenta() != null) {
			this.placenta = dados.placenta();
		}
		
	}

}
