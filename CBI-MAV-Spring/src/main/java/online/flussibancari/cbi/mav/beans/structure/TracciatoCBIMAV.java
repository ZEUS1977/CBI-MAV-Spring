package online.flussibancari.cbi.mav.beans.structure;

import online.flussibancari.cbi.mav.beans.CodaEF;
import online.flussibancari.cbi.mav.beans.TestaIM;

import java.util.List;

public class TracciatoCBIMAV {
	
	private TestaIM tastaIM;
	private List<RecordCodiceFissoCBIMAV> recordCodiciFissiList;
	private CodaEF codaEF;
	
	public TestaIM getTastaIM() {
		return tastaIM;
	}
	public void setTastaIM(TestaIM tastaIM) {
		this.tastaIM = tastaIM;
	}
	public List<RecordCodiceFissoCBIMAV> getRecordCodiciFissiList() {
		return recordCodiciFissiList;
	}
	public void setRecordCodiciFissiList(
			List<RecordCodiceFissoCBIMAV> recordCodiciFissiList) {
		this.recordCodiciFissiList = recordCodiciFissiList;
	}
	public CodaEF getCodaEF() {
		return codaEF;
	}
	public void setCodaEF(CodaEF codaEF) {
		this.codaEF = codaEF;
	}

}
