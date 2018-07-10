package online.flussibancari.cbi.mav.filler;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import online.flussibancari.cbi.mav.beans.CodiceFisso14;
import online.flussibancari.cbi.mav.beans.input.ExcelFixedFormat;
import online.flussibancari.cbi.mav.consts.Constants;
import online.flussibancari.cbi.mav.utils.CleanImport;

public class CodiceFisso14Filler {
	
	private static final Logger logger = LoggerFactory.getLogger(CodiceFisso14Filler.class);
	
	public BigDecimal populateCodiceFisso(CodiceFisso14 codiceFisso14, ExcelFixedFormat row, int progressivo, BigDecimal tot) {
		
		int decimalPlace = 2;
		
		BigDecimal importRata =  new BigDecimal(row.getRata());
		
		importRata = importRata.setScale(decimalPlace, BigDecimal.ROUND_HALF_EVEN);
		tot = tot.setScale(decimalPlace, BigDecimal.ROUND_HALF_EVEN);
		tot = tot.add(importRata);
		
		codiceFisso14.setProgressivo(Integer.toString(progressivo));
		SimpleDateFormat simple2 = new SimpleDateFormat(Constants.DATE_FORMAT);
		Date scadenza = null;
		try{
			scadenza = simple2.parse(row.getScadenza());
		}catch(Exception e){
			//inserire log dell'errore di parsing 
			e.printStackTrace();
		}
		codiceFisso14.setDataScadenza(Constants.simple.format(scadenza));
		codiceFisso14.setCausale(Constants.CAUSALE_RICHIESTA_MAV_CBI);
		codiceFisso14.setSegno(Constants.SIGN);
		codiceFisso14.setAbiCreditore(row.getIban().substring(5,10));
		codiceFisso14.setCabAssuntrice(row.getIban().substring(10,15));
		//il conto di accrerdito � diverso dall'IBAN nell'iban del creditore
		codiceFisso14.setContoAccredito(row.getConto()); 
				
		//viene assegnato dalla banca al creditore
		codiceFisso14.setCodiceSia(row.getCodSia());
		//codiceFisso14.setCodiceDebitore();
		//importd.setScale(decimalPlace, BigDecimal.ROUND_UP);
		//importo arrotondato a due cifre decimali
		codiceFisso14.setImporto(CleanImport.cleanImport(NumberFormat.getCurrencyInstance().format(importRata)));
		logger.info(CleanImport.cleanImport(NumberFormat.getCurrencyInstance().format(importRata)));
		logger.info(codiceFisso14.toString());
		return tot;
	}

	
	
}
