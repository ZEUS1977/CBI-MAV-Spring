package online.flussibancari.cbi.mav.beans;


import org.apache.commons.lang.StringUtils;

public class CodiceFisso extends FattoreTracciatoMAV{

	protected String progressivo = StringUtils.EMPTY;

	public String getProgressivo() {
		return progressivo;
	}

	public void setProgressivo(String progressivo) {
		this.progressivo = progressivo;
	}
	
	public CodiceFisso(){
		super();
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(", progressivo: " + progressivo);
		return sb.toString();
	}
}
