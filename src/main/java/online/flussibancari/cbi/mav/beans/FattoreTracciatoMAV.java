package online.flussibancari.cbi.mav.beans;


import org.apache.commons.lang.StringUtils;

import online.flussibancari.cbi.mav.consts.Constants;

public class FattoreTracciatoMAV implements FattoreInterface{

	protected String tipoRecord = StringUtils.EMPTY;
	
	public String empty = Constants.SPACE;
	
	public String getEmpty() {
		return empty;
	}

	public void setEmpty(String empty) {
		this.empty = empty;
	}

	public String getTipoRecord() {
		return tipoRecord;
	}

	public void setTipoRecord(String tipoRecord) {
		this.tipoRecord = tipoRecord;
	}

	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("tipoRecord: " + tipoRecord);
		return sb.toString();
	}
}
