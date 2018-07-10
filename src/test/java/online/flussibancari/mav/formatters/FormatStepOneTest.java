package online.flussibancari.mav.formatters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.InputStream;
import java.util.Iterator;
import java.util.Vector;

import org.apache.poi.ss.usermodel.Cell;
import org.junit.Test;

import online.flussibancari.cbi.mav.formatters.FormatStepOne;

public class FormatStepOneTest {
	
	@Test
	public void readExcelTest() {
		try{
			InputStream is = getClass().getClassLoader().getResourceAsStream("input/input_complex_data.xls");
			Vector<Vector<Cell>> dataHolder = FormatStepOne.readExcel(is);
			assertNotNull(dataHolder);
			assertEquals(961L, Long.valueOf(dataHolder.size()).longValue());
			
			Iterator<Vector<Cell>> it = dataHolder.iterator();
			while(it.hasNext()){
				Vector<Cell> row = it.next();
				assertEquals(13L, Long.valueOf(row.size()).longValue());
			}
		}catch (Exception e) {
			fail();
		}
	}
}
