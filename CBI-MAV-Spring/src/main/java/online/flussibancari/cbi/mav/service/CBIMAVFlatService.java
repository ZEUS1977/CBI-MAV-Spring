package online.flussibancari.cbi.mav.service;

import java.io.InputStream;

import com.blackbear.flatworm.FileCreator;

import online.flussibancari.cbi.mav.beans.Result;

public interface CBIMAVFlatService {
	
	public void closeFile( FileCreator fileCreator)  throws Exception;
	
	public FileCreator getCBIMAVFileCreator(String output) throws Exception;
	
	public Result manageSteps(String inputExcel) throws Exception;
	
	public Result manageSteps(String inputExcel, String outputTxt) throws Exception;
	
	public Result manageSteps(InputStream input) throws Exception;
	
}
