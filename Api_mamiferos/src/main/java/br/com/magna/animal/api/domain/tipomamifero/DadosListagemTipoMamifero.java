package br.com.magna.animal.api.domain.tipomamifero;

public record DadosListagemTipoMamifero(Long idTipo, String nomeTipo, Boolean mamilos, Boolean marsupio, Boolean placenta) {

	public DadosListagemTipoMamifero(TipoMamifero tipoMamifero) {
		this(tipoMamifero.getIdTipo(), tipoMamifero.getNomeTipo(), tipoMamifero.getMamilos(), 
				tipoMamifero.getMarsupio(), tipoMamifero.getPlacenta());
	}
}
