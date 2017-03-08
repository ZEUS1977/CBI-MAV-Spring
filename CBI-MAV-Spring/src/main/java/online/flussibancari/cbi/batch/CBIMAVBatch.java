package online.flussibancari.cbi.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import online.flussibancari.cbi.mav.beans.Result;
import online.flussibancari.cbi.mav.consts.Constants;
import online.flussibancari.cbi.mav.service.CBIMAVFlatService;
import online.flussibancari.cbi.mav.service.CBIMAVFlatServiceImpl;

public class CBIMAVBatch {
	
	private static final Logger logger = LoggerFactory.getLogger(CBIMAVBatch.class);
	
	
	public static void main(String[] args){
		String excelFilePath;
		
		if(args.length != 1){
			logger.error("Nessun parametro di input");
			System.out.println("Passare come parametro il cammino del file Excel da elaborare");
			return;
		}else{
			logger.info("Richiesta elaborazione dell'Excel:" + args[0]);
			excelFilePath = args[0];
		}

		CBIMAVFlatService service = null;
		
		service = new CBIMAVFlatServiceImpl(); 
		try {
			Result res = service.manageSteps(excelFilePath);
			logger.info("Creato il file CBI in ./scambiodati/out/output.txt" + Constants.NEW_LINE);
			System.out.println("Creato il file CBI in ./scambiodati/out/output.txt");
			logger.info("Righe: " + res.getRows() + " Totale importi MAV: " + res.getTot() + Constants.NEW_LINE);
			System.out.println("Righe: " + res.getRows() + " Totale importi MAV: " + res.getTot());
 		}catch (Exception ex) {
        	ex.printStackTrace();
		}
	}
}
