package online.flussibancari.cbi.mav.beans;

import org.apache.commons.lang.StringUtils;

import lombok.Data;
import online.flussibancari.cbi.mav.consts.Constants;
@Data
public class CodiceFisso20 extends CodiceFisso{

	private String primoSegmentoF = StringUtils.EMPTY;
	private String secondoSegmentoF = StringUtils.EMPTY;
	private String terzoSegmentoF = StringUtils.EMPTY;
	private String quartoSegmentoF = StringUtils.EMPTY;
	
	public CodiceFisso20() {
		super();
		tipoRecord = Constants.TIPO_RECORD_20;
	}

	public String getPrimoSegmentoF() {
		return primoSegmentoF;
	}
	public void setPrimoSegmentoF(String primoSegmentoF) {
		this.primoSegmentoF = primoSegmentoF;
	}
	public String getSecondoSegmentoF() {
		return secondoSegmentoF;
	}
	public void setSecondoSegmentoF(String secondoSegmentoF) {
		this.secondoSegmentoF = secondoSegmentoF;
	}
	public String getTerzoSegmentoF() {
		return terzoSegmentoF;
	}
	public void setTerzoSegmentoF(String terzoSegmentoF) {
		this.terzoSegmentoF = terzoSegmentoF;
	}
	public String getQuartoSegmentoF() {
		return quartoSegmentoF;
	}
	public void setQuartoSegmentoF(String quartoSegmentoF) {
		this.quartoSegmentoF = quartoSegmentoF;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(", CodiceFisso20: ");
		sb.append(", primoSegmentoF: " + primoSegmentoF);
		sb.append(", secondoSegmentoF: " +secondoSegmentoF);
		sb.append(", terzoSegmentoF: " + terzoSegmentoF );
		sb.append(", quartoSegmentoF: " + quartoSegmentoF);
		return sb.toString();
	}
}
