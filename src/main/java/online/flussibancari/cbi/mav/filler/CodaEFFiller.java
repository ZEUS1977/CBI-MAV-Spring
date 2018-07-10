package online.flussibancari.cbi.mav.filler;

import online.flussibancari.cbi.mav.beans.CodaEF;
import online.flussibancari.cbi.mav.beans.input.ExcelFixedFormat;
import online.flussibancari.cbi.mav.consts.Constants;
import online.flussibancari.cbi.mav.utils.CleanImport;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class CodaEFFiller {
	
	public void populateCodiceFisso(CodaEF codaEF, ExcelFixedFormat rowZero, int progressivo, BigDecimal tot){
		
		codaEF.setDataCreazione(Constants.TODAY);
		codaEF.setCodiceDivisa(Constants.CODICE_DIVISA);
		codaEF.setMittenteSia(rowZero.getCodSia());
		codaEF.setNomeSupporto( rowZero.getCreditore());
		codaEF.setRiceventeABI(rowZero.getIban().substring(5,10));
		codaEF.setTotRecord(Integer.toString(progressivo*7+2));
		codaEF.setNumeroDisposizioni(Integer.toString(progressivo));
		codaEF.setTotImportiNegativi(CleanImport.cleanImport(NumberFormat.getCurrencyInstance().format(tot)));
		
	}
}
