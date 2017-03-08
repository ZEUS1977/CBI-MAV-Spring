package online.flussibancari.cbi.mav.filler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import online.flussibancari.cbi.mav.beans.CodiceFisso30;
import online.flussibancari.cbi.mav.beans.input.ExcelFixedFormat;
import online.flussibancari.cbi.mav.consts.Constants;

public class CodiceFisso30Filler {
	
	private static final Logger logger = LoggerFactory.getLogger(CodiceFisso30Filler.class);
	
	public void populateCodiceFisso(CodiceFisso30 cf30, ExcelFixedFormat row, int progressivo){
		cf30.setProgressivo(Integer.toString(progressivo));
		String descrizioneDebitore = row.getTitolo() + Constants.SPACE + row.getDebitore();
		if(descrizioneDebitore.length() > 0  && descrizioneDebitore.length() > 30)
			cf30.setPrimoSegmentoF(descrizioneDebitore.substring(0,30));
		else if(descrizioneDebitore.length() > 0 && descrizioneDebitore.length() <= 30)					
			cf30.setPrimoSegmentoF(descrizioneDebitore.substring(0,descrizioneDebitore.length()));
		if(descrizioneDebitore.length() > 30  && descrizioneDebitore.length() > 60)
			cf30.setSecondoSegmentoF(descrizioneDebitore.substring(30,60));
		else if(descrizioneDebitore.length() > 30 && descrizioneDebitore.length() <= 60)					
			cf30.setSecondoSegmentoF(descrizioneDebitore.substring(30,descrizioneDebitore.length()));
		logger.info(cf30.toString());
	}
}
