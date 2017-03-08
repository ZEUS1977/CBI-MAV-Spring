package online.flussibancari.cbi.mav.beans;

import org.apache.commons.lang.StringUtils;

import lombok.Data;
import online.flussibancari.cbi.mav.consts.Constants;
@Data
public class CodiceFisso70 extends CodiceFisso{

	private String tipoBollettino = StringUtils.EMPTY;
	private String campoADisposizione = StringUtils.EMPTY;
	private String chiaviDiControllo = StringUtils.EMPTY;
		
	public CodiceFisso70() {
		super();
		tipoRecord = Constants.TIPO_RECORD_70;
	}

	public String getTipoBollettino() {
		return tipoBollettino;
	}
	public void setTipoBollettino(String tipoBollettino) {
		this.tipoBollettino = tipoBollettino;
	}
	public String getCampoADisposizione() {
		return campoADisposizione;
	}
	public void setCampoADisposizione(String campoADisposizione) {
		this.campoADisposizione = campoADisposizione;
	}
	public String getChiaviDiControllo() {
		return chiaviDiControllo;
	}
	public void setChiaviDiControllo(String chiaviDiControllo) {
		this.chiaviDiControllo = chiaviDiControllo;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(", CodiceFisso70: ");
		sb.append(", tipoBollettino: " + tipoBollettino);
		sb.append(", campoADisposizione: " + campoADisposizione);
		sb.append(", chiaviDiControllo: " + chiaviDiControllo);
		return sb.toString();
	}

}
