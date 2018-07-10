package online.flussibancari.cbi.mav.beans;

import org.apache.commons.lang.StringUtils;

import lombok.Data;
import online.flussibancari.cbi.mav.consts.Constants;
@Data
public class TestaIM extends FattoreTracciatoMAV{
                  
	private String mittenteSia = StringUtils.EMPTY;
	private String riceventeABI = StringUtils.EMPTY;
	private String dataCreazione = StringUtils.EMPTY;
	private String nomeSupporto = StringUtils.EMPTY;
	private String campoADisposizione = StringUtils.EMPTY;
	private String codiceDivisa = StringUtils.EMPTY;
	private String campoNonDisponibile = StringUtils.EMPTY;
	
	public TestaIM() {
		super();
		tipoRecord = Constants.TIPO_RECORD_IM;
	}

	public String getMittenteSia() {
		return mittenteSia;
	}
	public void setMittenteSia(String mittenteSia) {
		this.mittenteSia = mittenteSia;
	}
	public String getRiceventeABI() {
		return riceventeABI;
	}
	public void setRiceventeABI(String riceventeABI) {
		this.riceventeABI = riceventeABI;
	}
	public String getDataCreazione() {
		return dataCreazione;
	}
	public void setDataCreazione(String dataCreazione) {
		this.dataCreazione = dataCreazione;
	}
	public String getNomeSupporto() {
		return nomeSupporto;
	}
	public void setNomeSupporto(String nomeSupporto) {
		this.nomeSupporto = nomeSupporto;
	}
	public String getCampoADisposizione() {
		return campoADisposizione;
	}
	public void setCampoADisposizione(String campoADisposizione) {
		this.campoADisposizione = campoADisposizione;
	}
	public String getCodiceDivisa() {
		return codiceDivisa;
	}
	public void setCodiceDivisa(String codiceDivisa) {
		this.codiceDivisa = codiceDivisa;
	}
	public String getCampoNonDisponibile() {
		return campoNonDisponibile;
	}
	public void setCampoNonDisponibile(String campoNonDisponibile) {
		this.campoNonDisponibile = campoNonDisponibile;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(", TestaIM: ");
		sb.append(", mittenteSia: " + mittenteSia);
		sb.append(", riceventeABI: " + riceventeABI);
		sb.append(", dataCreazione: " + dataCreazione);
		sb.append(", nomeSupporto: " + nomeSupporto);
		sb.append(", campoADisposizione: " + campoADisposizione);
		sb.append(", codiceDivisa: " + codiceDivisa);
		sb.append(", campoNonDisponibile: " + codiceDivisa);
		return sb.toString();
	}
	
}
