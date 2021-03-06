package online.flussibancari.cbi.mav.beans;

import online.flussibancari.cbi.mav.consts.Constants;

import org.apache.commons.lang.StringUtils;

import lombok.Data;
@Data
public class CodiceFisso14 extends CodiceFisso{

	private String dataScadenza = StringUtils.EMPTY;
	private String causale = StringUtils.EMPTY;
	private String importo = StringUtils.EMPTY;
	private String segno = StringUtils.EMPTY;
	private String abiCreditore = StringUtils.EMPTY;
	private String cabAssuntrice = StringUtils.EMPTY;
	private String contoAccredito = StringUtils.EMPTY;
	private String codiceSia = StringUtils.EMPTY;
	private String tipo = StringUtils.EMPTY;
	private String codiceDebitore = StringUtils.EMPTY;
	private String codiceDvisa = StringUtils.EMPTY;
	
	public CodiceFisso14() {
		super();
		tipoRecord = Constants.TIPO_RECORD_14;
	}
	
	public String getDataScadenza() {
		return dataScadenza;
	}
	public void setDataScadenza(String dataScadenza) {
		this.dataScadenza = dataScadenza;
	}
	public String getCausale() {
		return causale;
	}
	public void setCausale(String causale) {
		this.causale = causale;
	}
	public String getImporto() {
		return importo;
	}
	public void setImporto(String importo) {
		this.importo = importo;
	}
	public String getSegno() {
		return segno;
	}
	public void setSegno(String segno) {
		this.segno = segno;
	}
	public String getAbiCreditore() {
		return abiCreditore;
	}
	public void setAbiCreditore(String abiCreditore) {
		this.abiCreditore = abiCreditore;
	}
	public String getCabAssuntrice() {
		return cabAssuntrice;
	}
	public void setCabAssuntrice(String cabAssuntrice) {
		this.cabAssuntrice = cabAssuntrice;
	}
	public String getContoAccredito() {
		return contoAccredito;
	}
	public void setContoAccredito(String contoAccredito) {
		this.contoAccredito = contoAccredito;
	}
	public String getCodiceSia() {
		return codiceSia;
	}
	public void setCodiceSia(String codiceSia) {
		this.codiceSia = codiceSia;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String codiceV) {
		this.tipo = codiceV;
	}
	public String getCodiceDebitore() {
		return codiceDebitore;
	}
	public void setCodiceDebitore(String codiceDebitore) {
		this.codiceDebitore = codiceDebitore;
	}
	public String getCodiceDvisa() {
		return codiceDvisa;
	}
	public void setCodiceDvisa(String codiceDvisa) {
		this.codiceDvisa = codiceDvisa;
	}	
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(", CodiceFisso14: ");
		sb.append(", dataScadenza: "+  dataScadenza);
		sb.append(", causale: " + causale);
		sb.append(", importo: " + importo);
		sb.append(", segno: " +segno );
		sb.append(", abiCreditore: " + abiCreditore);
		sb.append(", cabAssuntrice: " + cabAssuntrice);
		sb.append(", contoAccredito: " + contoAccredito);
		sb.append(", codiceSia: " + codiceSia);
		sb.append(", tipo: " + tipo);
		sb.append(", codiceDebitore: " + codiceDebitore);
		sb.append(", codiceDvisa: " + codiceDvisa);
		return sb.toString();
	}
}
