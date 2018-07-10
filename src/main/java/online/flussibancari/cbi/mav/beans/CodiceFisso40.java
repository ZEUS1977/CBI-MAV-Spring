package online.flussibancari.cbi.mav.beans;

import org.apache.commons.lang.StringUtils;

import lombok.Data;
import online.flussibancari.cbi.mav.consts.Constants;
@Data
public class CodiceFisso40 extends CodiceFisso{

	private String viaCivicoFrazione  = StringUtils.EMPTY;
	private String cap = StringUtils.EMPTY;
	private String comuneProvincia = StringUtils.EMPTY;
	private String completamentoIndirizzo = StringUtils.EMPTY;
	private String codicePaese = StringUtils.EMPTY;
	
	public CodiceFisso40() {
		super();
		tipoRecord = Constants.TIPO_RECORD_40;
	}

	public String getViaCivicoFrazione() {
		return viaCivicoFrazione;
	}
	public void setViaCivicoFrazione(String viaCivicoFrazione) {
		this.viaCivicoFrazione = viaCivicoFrazione;
	}
	public String getCap() {
		return cap;
	}
	public void setCap(String cap) {
		this.cap = cap;
	}
	public String getComuneProvincia() {
		return comuneProvincia;
	}
	public void setComuneProvincia(String comuneProvincia) {
		this.comuneProvincia = comuneProvincia;
	}
	public String getCompletamentoIndirizzo() {
		return completamentoIndirizzo;
	}
	public void setCompletamentoIndirizzo(String completamentoIndirizzo) {
		this.completamentoIndirizzo = completamentoIndirizzo;
	}
	public String getCodicePaese() {
		return codicePaese;
	}
	public void setCodicePaese(String codicePaese) {
		this.codicePaese = codicePaese;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(", CodiceFisso40: ");
		sb.append(", cap: " + cap);
		sb.append(", completamentoIndirizzo: " + completamentoIndirizzo);
		sb.append(", codicePaese: " + codicePaese );
		return sb.toString();
	}
}
