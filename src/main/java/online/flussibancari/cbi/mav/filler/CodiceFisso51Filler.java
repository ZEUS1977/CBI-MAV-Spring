package online.flussibancari.cbi.mav.filler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import online.flussibancari.cbi.mav.beans.CodiceFisso51;
import online.flussibancari.cbi.mav.beans.input.ExcelFixedFormat;

public class CodiceFisso51Filler {
	private static final Logger logger = LoggerFactory.getLogger(CodiceFisso51Filler.class);
	
	public void populateCodiceFisso(CodiceFisso51 cf51, ExcelFixedFormat row, int progressivo){
		cf51.setProgressivo(Integer.toString(progressivo));
		cf51.setNumeroDisposizione(Integer.toString(progressivo));
		logger.info(cf51.toString());
	}
}
