package online.flussibancari.cbi.mav.formatters;

import java.io.File;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Vector;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import online.flussibancari.cbi.mav.consts.Constants;

public class FormatStepOne {
	
	private static final Logger logger = LoggerFactory.getLogger(FormatStepOne.class);
	
	public static Workbook getWorkBook(String fileName) throws Exception{
		Workbook wb = null;
		wb = WorkbookFactory.create(new File(fileName));
		logger.info("Letto il file Exceldi di input: " + fileName);
		return wb;
	}
	
	public static Workbook getWorkBook(InputStream input) throws Exception{
		Workbook wb = null;
		wb = WorkbookFactory.create(input);
		logger.info("Letto il file Exceldi di input");
		return wb;
	}
	
	public static Vector<Vector<Cell>> readExcel(String fileName) throws Exception{
		Workbook wb = getWorkBook(fileName);
		return getExcelAsVector(wb);
	}
	
	public static Vector<Vector<Cell>> getExcelAsVector(Workbook wb) throws Exception{
		
		Vector<Vector<Cell>> cellVectorHolder = new Vector<Vector<Cell>>();
			
		Sheet mySheet = wb.getSheetAt(0);

		Iterator<Row> rowIter = mySheet.rowIterator();
		while (rowIter.hasNext()) {
			Row myRow = (Row) rowIter.next();
			Iterator<org.apache.poi.ss.usermodel.Cell> cellIter = myRow.cellIterator();
			Vector<Cell> cellStoreVector = new Vector<Cell>();
			while (cellIter.hasNext()) {
				Cell myCell = (Cell) cellIter.next();
				cellStoreVector.add(myCell);
			}
			cellVectorHolder.add(cellStoreVector);
		}
		logger.info("Popolato il primo vettore");
		return cellVectorHolder;
	}

	public static Vector<Vector<Cell>> readExcel(InputStream input) throws Exception{
		Workbook wb = getWorkBook(input);
		return getExcelAsVector(wb);
	}
	
	public static void logCellData(Vector<Vector<Cell>> dataHolder) {
		Vector<Cell> cellStoreVector;
		for (int i = 0; i < dataHolder.size(); i++) {
			cellStoreVector = (Vector<Cell>) dataHolder.elementAt(i);
			
			for (int j = 0; j < cellStoreVector.size(); j++) {
				
				Cell myCell = (Cell) cellStoreVector.elementAt(j);
				
				int type = myCell.getCellType();
				
				if(type == Cell.CELL_TYPE_STRING)
					logger.info(myCell.getStringCellValue() + Constants.TAB);
				else if (type == Cell.CELL_TYPE_NUMERIC ){
					if (DateUtil.isCellDateFormatted(myCell)) {
				        logger.info(Constants.LOG_ROW_NUM + myCell.getDateCellValue() + Constants.SPACE);
				    }
					logger.info(myCell.getNumericCellValue() + Constants.TAB);
				}
			}
		}
	}
}
