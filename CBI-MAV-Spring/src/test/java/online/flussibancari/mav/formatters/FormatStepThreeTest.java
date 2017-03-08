package online.flussibancari.mav.formatters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.InputStream;
import java.util.Vector;

import org.apache.poi.ss.usermodel.Cell;
import org.junit.Before;
import org.junit.Test;

import online.flussibancari.cbi.mav.beans.Result;
import online.flussibancari.cbi.mav.beans.input.ExcelFixedFormat;
import online.flussibancari.cbi.mav.beans.structure.TracciatoCBIMAV;
import online.flussibancari.cbi.mav.formatters.FormatStepOne;
import online.flussibancari.cbi.mav.formatters.FormatStepThree;
import online.flussibancari.cbi.mav.formatters.FormatStepTwo;

public class FormatStepThreeTest {
	
	Vector<ExcelFixedFormat> rows;
	TracciatoCBIMAV tracciato = new TracciatoCBIMAV();
	
	@Before
	public void prepare(){
		try{
			InputStream is = getClass().getClassLoader().getResourceAsStream("input/input_complex_data.xls");
			Vector<Vector<Cell>> dataHolder = FormatStepOne.readExcel(is);
			rows = FormatStepTwo.excelToVector(dataHolder);
		}catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void populateTracciatoTest() {
		try{
			Result res = FormatStepThree.populateTracciato(rows, tracciato);
			assertEquals(961L, Long.valueOf(res.getRows().intValue()).longValue());
		}catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
}
	