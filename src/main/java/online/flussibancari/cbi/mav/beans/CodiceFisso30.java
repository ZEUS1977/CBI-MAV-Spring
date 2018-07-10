package online.flussibancari.cbi.mav.beans;

import online.flussibancari.cbi.mav.consts.Constants;

import org.apache.commons.lang.StringUtils;

import lombok.Data;
@Data
public class CodiceFisso30 extends CodiceFisso {

	private String primoSegmentoF = StringUtils.EMPTY;
	private String secondoSegmentoF = StringUtils.EMPTY;
	private String codiceFiscaleDebitore = StringUtils.EMPTY;
	
	public CodiceFisso30() {
		super();
		tipoRecord = Constants.TIPO_RECORD_30;
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
	public String getCodiceFiscaleDebitore() {
		return codiceFiscaleDebitore;
	}
	public void setCodiceFiscaleDebitore(String codiceFiscaleDebitore) {
		this.codiceFiscaleDebitore = codiceFiscaleDebitore;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(", CodiceFisso30: ");
		sb.append(", primoSegmentoF: " + primoSegmentoF);
		sb.append(", secondoSegmentoF: " + secondoSegmentoF);
		sb.append(", codiceFiscaleDebitore: " + codiceFiscaleDebitore );
		return sb.toString();
	}
		
}
