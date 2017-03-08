package online.flussibancari.cbi.mav.beans;

import org.apache.commons.lang.StringUtils;

import lombok.Data;
import online.flussibancari.cbi.mav.consts.Constants;
@Data
public class CodiceFisso50 extends CodiceFisso{

   	private String primoSegmentoF = StringUtils.EMPTY;
	private String secondoSegmentoF = StringUtils.EMPTY;
	
	public CodiceFisso50() {
		super();
		tipoRecord = Constants.TIPO_RECORD_50;
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
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(", CodiceFisso50: ");
		sb.append(", primoSegmentoF: " + primoSegmentoF);
		sb.append(", secondoSegmentoF: " + secondoSegmentoF);
		return sb.toString();
	}
}
