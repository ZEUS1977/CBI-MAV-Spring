package online.flussibancari.cbi.mav.filler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import online.flussibancari.cbi.mav.beans.CodiceFisso40;
import online.flussibancari.cbi.mav.beans.input.ExcelFixedFormat;
import online.flussibancari.cbi.mav.consts.Constants;

public class CodiceFisso40Filler {
	private static final Logger logger = LoggerFactory.getLogger(CodiceFisso40Filler.class);
	
	public void populateCodiceFisso(CodiceFisso40 cf40, ExcelFixedFormat row, int progressivo) throws Exception{
		
		cf40.setProgressivo(Integer.toString(progressivo));
		cf40.setViaCivicoFrazione(row.getIndirizzo_via_civico());
		cf40.setCap(row.getIndirizzo_cap());
		cf40.setComuneProvincia(row.getIndirizzo_comune() + " " + row.getIndirizzo_provincia());
		cf40.setCodicePaese(Constants.COUNTRY_COD);		
		logger.info(cf40.toString());
	}
}
