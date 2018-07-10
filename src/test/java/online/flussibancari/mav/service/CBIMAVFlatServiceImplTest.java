package online.flussibancari.mav.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.InputStream;

import org.junit.Test;

import com.blackbear.flatworm.FileCreator;

import online.flussibancari.cbi.mav.consts.Constants;
import online.flussibancari.cbi.mav.service.CBIMAVFlatService;
import online.flussibancari.cbi.mav.service.CBIMAVFlatServiceImpl;

public class CBIMAVFlatServiceImplTest {

	private CBIMAVFlatService service = new CBIMAVFlatServiceImpl();
		
	@Test
	public void testConfXmlFromFile() throws Exception {
		FileCreator fileCreator = service.getCBIMAVFileCreator(Constants.OUT_FILE);
		assertNotNull(fileCreator);
	}
	
	@Test
	public void testManageSteps() throws Exception {
		File file = new File(Constants.OUT_FILE);
		if(file.exists())
			file.delete();
		InputStream input = getClass().getClassLoader().getResourceAsStream("input/input_complex_data.xls"); 
		service.manageSteps(input);
		assertTrue(file.exists());
	}
	
}
