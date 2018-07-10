package online.flussibancari.cbi.mav.filler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import online.flussibancari.cbi.mav.beans.CodiceFisso70;
import online.flussibancari.cbi.mav.beans.input.ExcelFixedFormat;

public class CodiceFisso70Filler {
	private static final Logger logger = LoggerFactory.getLogger(CodiceFisso70Filler.class);
	
	public void populateCodiceFisso(CodiceFisso70 cf70, ExcelFixedFormat row, int progressivo){
		cf70.setProgressivo(Integer.toString(progressivo));
		logger.info(cf70.toString());
	}
}
