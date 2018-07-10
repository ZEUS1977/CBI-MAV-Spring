package online.flussibancari.cbi.mav.filler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import online.flussibancari.cbi.gui.FileChooser;
import online.flussibancari.cbi.mav.beans.TestaIM;
import online.flussibancari.cbi.mav.beans.input.ExcelFixedFormat;
import online.flussibancari.cbi.mav.consts.Constants;

public class TestaIMFiller {
	private static final Logger logger = LoggerFactory.getLogger(TestaIMFiller.class);
	public void populateCodiceFisso(TestaIM testaIM, ExcelFixedFormat rowZero){
		testaIM.setDataCreazione(Constants.TODAY);
		testaIM.setCodiceDivisa(Constants.CODICE_DIVISA);
		testaIM.setMittenteSia(rowZero.getCodSia());
		testaIM.setNomeSupporto(rowZero.getCreditore());
		testaIM.setRiceventeABI(rowZero.getIban().substring(5,10));
		logger.info(testaIM.toString());
	}
}
