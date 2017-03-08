package online.flussibancari.cbi.mav.formatters;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.blackbear.flatworm.FileCreator;

import online.flussibancari.cbi.mav.beans.CodaEF;
import online.flussibancari.cbi.mav.beans.CodiceFisso14;
import online.flussibancari.cbi.mav.beans.CodiceFisso20;
import online.flussibancari.cbi.mav.beans.CodiceFisso30;
import online.flussibancari.cbi.mav.beans.CodiceFisso40;
import online.flussibancari.cbi.mav.beans.CodiceFisso50;
import online.flussibancari.cbi.mav.beans.CodiceFisso51;
import online.flussibancari.cbi.mav.beans.CodiceFisso70;
import online.flussibancari.cbi.mav.beans.Result;
import online.flussibancari.cbi.mav.beans.TestaIM;
import online.flussibancari.cbi.mav.beans.input.ExcelFixedFormat;
import online.flussibancari.cbi.mav.beans.structure.RecordCodiceFissoCBIMAV;
import online.flussibancari.cbi.mav.beans.structure.TracciatoCBIMAV;
import online.flussibancari.cbi.mav.consts.Constants;
import online.flussibancari.cbi.mav.filler.CodaEFFiller;
import online.flussibancari.cbi.mav.filler.CodiceFisso14Filler;
import online.flussibancari.cbi.mav.filler.CodiceFisso20Filler;
import online.flussibancari.cbi.mav.filler.CodiceFisso30Filler;
import online.flussibancari.cbi.mav.filler.CodiceFisso40Filler;
import online.flussibancari.cbi.mav.filler.CodiceFisso50Filler;
import online.flussibancari.cbi.mav.filler.CodiceFisso51Filler;
import online.flussibancari.cbi.mav.filler.CodiceFisso70Filler;
import online.flussibancari.cbi.mav.filler.TestaIMFiller;

public class FormatStepThree {
	
	private static final Logger logger = LoggerFactory.getLogger(FormatStepThree.class);
	
	public static Result populateTracciato(Vector<ExcelFixedFormat> rows, TracciatoCBIMAV tracciato) throws Exception{
		AbstractApplicationContext    context = 	
	             new ClassPathXmlApplicationContext(Constants.APP_CONTEXT);

		
		//la testa dall'execel ha bisogno di info che ci sono in tutte le righe dell'excel, prendo la prima
		ExcelFixedFormat rowZero = rows.get(0);
		
		TestaIMFiller fTesta = (TestaIMFiller) context.getBean(Constants.FILLER_IM);

		TestaIM testaIM = (TestaIM)context.getBean(Constants.BEAN_IM);
		fTesta.populateCodiceFisso(testaIM, rowZero);		
		tracciato.setTastaIM(testaIM);
		logger.info("Popolata testa");
		
		BigDecimal tot = BigDecimal.ZERO;
		int progressivo = 0;
		
		ExcelFixedFormat row =null;
		List<RecordCodiceFissoCBIMAV> records = new ArrayList<RecordCodiceFissoCBIMAV>();
		
		CodiceFisso14Filler f14 = (CodiceFisso14Filler) context.getBean(Constants.FILLER_14);
		CodiceFisso20Filler f20 = (CodiceFisso20Filler) context.getBean(Constants.FILLER_20);
		CodiceFisso30Filler f30 = (CodiceFisso30Filler) context.getBean(Constants.FILLER_30);
		CodiceFisso40Filler f40 = (CodiceFisso40Filler) context.getBean(Constants.FILLER_40);
		CodiceFisso50Filler f50 = (CodiceFisso50Filler) context.getBean(Constants.FILLER_50);
		CodiceFisso51Filler f51 = (CodiceFisso51Filler) context.getBean(Constants.FILLER_51);
		CodiceFisso70Filler f70 = (CodiceFisso70Filler) context.getBean(Constants.FILLER_70);
		
		for(int i = 0; i < rows.size(); i++){ 
			
			
			CodiceFisso14 cf14 = (CodiceFisso14)context.getBean(Constants.BEAN_14);
			CodiceFisso20 cf20 = (CodiceFisso20)context.getBean(Constants.BEAN_20);
			CodiceFisso30 cf30 = (CodiceFisso30)context.getBean(Constants.BEAN_30);
			CodiceFisso40 cf40 = (CodiceFisso40)context.getBean(Constants.BEAN_40);
			CodiceFisso50 cf50 = (CodiceFisso50)context.getBean(Constants.BEAN_50);
			CodiceFisso51 cf51 = (CodiceFisso51)context.getBean(Constants.BEAN_51);
			CodiceFisso70 cf70 = (CodiceFisso70)context.getBean(Constants.BEAN_70);
		
			row = rows.get(i);
			if(row != null && row.getScadenza() != null && !StringUtils.EMPTY.equals(row.getScadenza())) {

				RecordCodiceFissoCBIMAV record = new RecordCodiceFissoCBIMAV(); 
				//il progressivo parte da uno ed � presente in ogni richiesta di mav
				progressivo = i+1;		
				logger.info(i + row.toString());			
				
				tot = f14.populateCodiceFisso(cf14, row, progressivo, tot);
				logger.info("Parziale importi: " + tot);
				record.setCodiceFisso14(cf14);
				
				f20.populateCodiceFisso(cf20, row, progressivo);
				record.setCodiceFisso20(cf20);				
				
				f30.populateCodiceFisso(cf30, row, progressivo);
				record.setCodiceFisso30(cf30);
				
				
				f40.populateCodiceFisso(cf40, row, progressivo);
				record.setCodiceFisso40(cf40);
			
				
				f50.populateCodiceFisso(cf50, row, progressivo);
				record.setCodiceFisso50(cf50);
				
				f51.populateCodiceFisso(cf51, row, progressivo);
				record.setCodiceFisso51(cf51);
				
				f70.populateCodiceFisso(cf70, row, progressivo);
				record.setCodiceFisso70(cf70);
				
				records.add(record);
				logger.info("Popolata MAV numero: " + progressivo);
			}	
			
			tracciato.setRecordCodiciFissiList(records);
		}
		
		CodaEF codaEF = (CodaEF)context.getBean(Constants.BEAN_EF);
		
		CodaEFFiller fCoda = (CodaEFFiller) context.getBean(Constants.FILLER_EF);
		fCoda.populateCodiceFisso(codaEF, rowZero, progressivo, tot);
		tracciato.setCodaEF(codaEF);
		logger.info("Popolata coda");
		logger.info(String.valueOf(tot));
		Result res = new Result();
		res.setRows(Integer.valueOf(progressivo));
		res.setTot(String.valueOf(tot));
		return res;
	
	}
	
	public static void writeTracciato(TracciatoCBIMAV tracciato, FileCreator file) throws Exception{
		logger.info("Inizio scrittura file piatto");
		file.open();
		writeRecord(file, tracciato.getTastaIM(), Constants.FW_BEAN_TESTA_IM, Constants.FW_RECORD_TESTA_IM);
		logger.info("Scritta testa");
		Iterator<RecordCodiceFissoCBIMAV> recordIterator = tracciato.getRecordCodiciFissiList().iterator();
		RecordCodiceFissoCBIMAV record = null;
		int i = 1;
		while(recordIterator.hasNext()){
			record = recordIterator.next();
			writeRecord(file, record.getCodiceFisso14(), Constants.FW_BEAN_14, Constants.FW_RECORD_14);
			writeRecord(file, record.getCodiceFisso20(), Constants.FW_BEAN_20, Constants.FW_RECORD_20);
			writeRecord(file, record.getCodiceFisso30(), Constants.FW_BEAN_30, Constants.FW_RECORD_30);
			writeRecord(file, record.getCodiceFisso40(), Constants.FW_BEAN_40, Constants.FW_RECORD_40);
			writeRecord(file, record.getCodiceFisso50(), Constants.FW_BEAN_50, Constants.FW_RECORD_50);
			writeRecord(file, record.getCodiceFisso51(), Constants.FW_BEAN_51, Constants.FW_RECORD_51);
			writeRecord(file, record.getCodiceFisso70(), Constants.FW_BEAN_70, Constants.FW_RECORD_70);
			logger.info("Scritta MAV: " + i);
			i++;
		}
		logger.info("Scritta coda");
		writeRecord(file, tracciato.getCodaEF(), Constants.FW_BEAN_CODA_EF, Constants.FW_RECORD_CODA_EF);
	}
	
	
	public static void writeRecord(FileCreator file,  Object bean, String beanName, String recordName) {
		
		try {
			file.setBean(beanName, bean);
			file.write(recordName);
			
		}catch (Exception e) {
			e.printStackTrace();
		} finally {  
			
		}  
	}
}
