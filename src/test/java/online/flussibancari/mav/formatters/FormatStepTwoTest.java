package online.flussibancari.mav.formatters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.InputStream;
import java.util.Iterator;
import java.util.Vector;

import org.apache.poi.ss.usermodel.Cell;
import org.junit.Before;
import org.junit.Test;

import online.flussibancari.cbi.mav.beans.input.ExcelFixedFormat;
import online.flussibancari.cbi.mav.formatters.FormatStepOne;
import online.flussibancari.cbi.mav.formatters.FormatStepTwo;

public class FormatStepTwoTest {

	Vector<Vector<Cell>> dataHolder; 
	
	
	@Before
	public void excel(){
		try{
			InputStream is = getClass().getClassLoader().getResourceAsStream("input/input_complex_data.xls");
			dataHolder = FormatStepOne.readExcel(is);
		}catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void excelToVectorTest(){
		try{
			Vector<ExcelFixedFormat> vector = FormatStepTwo.excelToVector(dataHolder);
			assertNotNull(vector);
			assertEquals(961L, Long.valueOf(vector.size()).longValue());
		}catch (Exception e) {
			fail();
		}
	}
	
}
