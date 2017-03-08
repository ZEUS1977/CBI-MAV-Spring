package online.flussibancari.cbi.mav.filler;

import online.flussibancari.cbi.mav.beans.CodiceFisso;
import online.flussibancari.cbi.mav.beans.input.ExcelFixedFormat;

public abstract class AbstractCodiceFissoFiller {
	
	public abstract void populateCodiceFisso(CodiceFisso codiceFisso, ExcelFixedFormat row, int progressivo);

}
