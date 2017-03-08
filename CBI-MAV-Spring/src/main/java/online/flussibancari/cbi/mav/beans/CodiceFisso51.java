package online.flussibancari.cbi.mav.beans;

import org.apache.commons.lang.StringUtils;

import lombok.Data;
import online.flussibancari.cbi.mav.consts.Constants;
@Data
public class CodiceFisso51 extends CodiceFisso{

	private String numeroDisposizione = StringUtils.EMPTY;
	private String codiceIdentificativoUnivoco = StringUtils.EMPTY;	
	
	public CodiceFisso51() {
		super();
		tipoRecord = Constants.TIPO_RECORD_51;
	}

	public String getNumeroDisposizione() {
		return numeroDisposizione;
	}
	public void setNumeroDisposizione(String numeroDisposizione) {
		this.numeroDisposizione = numeroDisposizione;
	}
	public String getCodiceIdentificativoUnivoco() {
		return codiceIdentificativoUnivoco;
	}
	public void setCodiceIdentificativoUnivoco(String codiceIdentificativoUnivoco) {
		this.codiceIdentificativoUnivoco = codiceIdentificativoUnivoco;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(", CodiceFisso51: ");
		sb.append(", numeroDisposizione: " + numeroDisposizione);
		sb.append(", codiceIdentificativoUnivoco: " + codiceIdentificativoUnivoco);
		return sb.toString();
	}
}
