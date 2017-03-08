package online.flussibancari.cbi.mav.service;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;

import org.apache.poi.ss.usermodel.Cell;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.blackbear.flatworm.FileCreator;
import com.blackbear.flatworm.FileFormat;
import com.blackbear.flatworm.config.ConfigurationReader;
import com.blackbear.flatworm.config.impl.DefaultConfigurationReaderImpl;

import online.flussibancari.cbi.mav.beans.Result;
import online.flussibancari.cbi.mav.beans.input.ExcelFixedFormat;
import online.flussibancari.cbi.mav.beans.structure.TracciatoCBIMAV;
import online.flussibancari.cbi.mav.consts.Constants;
import online.flussibancari.cbi.mav.formatters.FormatStepOne;
import online.flussibancari.cbi.mav.formatters.FormatStepThree;
import online.flussibancari.cbi.mav.formatters.FormatStepTwo;
@Component
public class CBIMAVFlatServiceImpl implements CBIMAVFlatService {
	
	private static final Logger logger = LoggerFactory.getLogger(CBIMAVFlatServiceImpl.class);
	
	public FileCreator openFile(String conf, String out) throws Exception{
		FileCreator file= null;
		file = new FileCreator(conf, out);
		file.open(); 
		file.setRecordSeparator(Constants.NEW_LINE);
		logger.info("Letta configurazione di flatworm");
		return file;
	}
	
	public FileCreator openFile(InputStream conf, OutputStream out)  throws Exception{
		FileCreator fileCreator= null;

		fileCreator = new FileCreator(conf, out);
		fileCreator.open(); 
		fileCreator.setRecordSeparator(Constants.NEW_LINE); 
		logger.info("Letta configurazione di flatworm");
		return fileCreator;
	}
	
	public void closeFile( FileCreator fileCreator) throws Exception{

		if(fileCreator != null)
				fileCreator.close();  
		
		logger.info("Chiusa configurazione di flatworm");
	}
	
	
	
	public FileFormat getCBIMAVFileFormat() throws Exception{ 
		
		InputStream is = getClass().getClassLoader().getResourceAsStream("flatworm/cbi-mav.xml");
		ConfigurationReader parser = new DefaultConfigurationReaderImpl();
		BufferedInputStream bis =new BufferedInputStream(is);
		FileFormat fileFormat = parser.loadConfigurationFile(bis);
		logger.info("Letta configurazione di flatworm");
		return fileFormat;

	}
	
	public FileCreator getCBIMAVFileCreator(OutputStream out) throws Exception{ 
		
		InputStream is = getClass().getClassLoader().getResourceAsStream("flatworm/cbi-mav.xml");
		BufferedInputStream bis =new BufferedInputStream(is);
		BufferedOutputStream bos = new BufferedOutputStream(out);
		FileCreator fileCreator = new FileCreator(bis, bos);
		logger.info("Letta configurazione di flatworm");
		return fileCreator;

	}
	
	public FileCreator getCBIMAVFileCreator(String out) throws Exception{ 
		
		InputStream is = getClass().getClassLoader().getResourceAsStream("flatworm/cbi-mav.xml");
		BufferedInputStream bis =new BufferedInputStream(is);
		FileCreator fileCreator = new FileCreator(bis, out);
		logger.info("Letta configurazione di flatworm");
		return fileCreator;

	}
	
	public Result manageSteps(String inputExcel) throws Exception{
	    	
			Vector<Vector<Cell>> dataHolder = FormatStepOne.readExcel(inputExcel);
			FormatStepOne.logCellData(dataHolder);
			logger.info("Eseguito format step one");
			Vector<ExcelFixedFormat> rows = FormatStepTwo.excelToVector(dataHolder);
			logger.info("Eseguito format step two");
			TracciatoCBIMAV tracciato = new TracciatoCBIMAV();
			FileCreator file = null;
			CBIMAVFlatService service = new CBIMAVFlatServiceImpl();
			
			file = service.getCBIMAVFileCreator(Constants.OUT_FILE);
			file.setRecordSeparator(Constants.NEW_LINE);
			
			Result res = FormatStepThree.populateTracciato(rows, tracciato);
			logger.info("Eseguito format step three");
			FormatStepThree.writeTracciato(tracciato,file);

			service.closeFile(file);
			
			return res;
			
	}
	
	public Result manageSteps(String inputExcel, String outputTxt) throws Exception{
    	
		Vector<Vector<Cell>> dataHolder = FormatStepOne.readExcel(inputExcel);
		FormatStepOne.logCellData(dataHolder);
		logger.info("Eseguito format step one");
		Vector<ExcelFixedFormat> rows = FormatStepTwo.excelToVector(dataHolder);
		logger.info("Eseguito format step two");
		TracciatoCBIMAV tracciato = new TracciatoCBIMAV();
		FileCreator file = null;
		CBIMAVFlatService service = new CBIMAVFlatServiceImpl();
		
		file = service.getCBIMAVFileCreator(outputTxt);
		file.setRecordSeparator(Constants.NEW_LINE);
		
		Result res = FormatStepThree.populateTracciato(rows, tracciato);
		logger.info("Eseguito format step three");
		FormatStepThree.writeTracciato(tracciato,file);

		service.closeFile(file);
		
		return res;
		
	}

	
	public Result manageSteps(InputStream inputExcel) throws Exception{
    	
		Vector<Vector<Cell>> dataHolder = FormatStepOne.readExcel(inputExcel);
		FormatStepOne.logCellData(dataHolder);
		logger.info("Eseguito format step one");
		
		Vector<ExcelFixedFormat> rows = FormatStepTwo.excelToVector(dataHolder);
		logger.info("Eseguito format step two");
		
		TracciatoCBIMAV tracciato = new TracciatoCBIMAV();
		FileCreator file = null;
		CBIMAVFlatService service = new CBIMAVFlatServiceImpl();

		file = service.getCBIMAVFileCreator(Constants.OUT_FILE);
		file.setRecordSeparator(Constants.NEW_LINE);


		Result res = FormatStepThree.populateTracciato(rows, tracciato);
		
		FormatStepThree.writeTracciato(tracciato,file);
		logger.info("Eseguito format step three");
		service.closeFile(file);
		
		return res;
		
	}

}
