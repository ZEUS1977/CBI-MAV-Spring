package online.flussibancari.cbi.mav.formatters;



import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Vector;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import online.flussibancari.cbi.mav.beans.input.ExcelFixedFormat;
import online.flussibancari.cbi.mav.consts.Constants;

public class FormatStepTwo {
	
	private static final Logger logger = LoggerFactory.getLogger(FormatStepTwo.class);
	
	public static Vector<ExcelFixedFormat> excelToVector(Vector<Vector<Cell>> input) throws Exception{
				
		Vector<ExcelFixedFormat> rows = new Vector<ExcelFixedFormat>();
		Iterator<Vector<Cell>> it = input.iterator();
		while(it.hasNext()) {
			Vector<Cell> cellStoreVector = (Vector<Cell>) it.next();
			ExcelFixedFormat row = new ExcelFixedFormat();
			Iterator<Cell> itCell = cellStoreVector.iterator();
			if(itCell.hasNext())
				row.setCreditore(getStringData(itCell.next()));
			if(itCell.hasNext())
					row.setTitolo(getStringData(itCell.next()));
			if(itCell.hasNext())
				row.setDebitore(getStringData(itCell.next()));
			if(itCell.hasNext())
				row.setIndirizzo_via_civico(getStringData(itCell.next()));
			if(itCell.hasNext())
				row.setIndirizzo_cap(getStringData(itCell.next()));
			if(itCell.hasNext())
				row.setIndirizzo_comune(getStringData(itCell.next()));
			if(itCell.hasNext())
				row.setIndirizzo_provincia(getStringData(itCell.next()));	
			if(itCell.hasNext())
				row.setRata(getStringData(itCell.next()));
			if(itCell.hasNext())
				row.setScadenza(getStringData(itCell.next()));
			if(itCell.hasNext())
				row.setCausale(getStringData(itCell.next()));
			if(itCell.hasNext())
				row.setIban(getStringData(itCell.next()));
			if(itCell.hasNext())
				row.setCodSia(getStringData(itCell.next()));
			if(itCell.hasNext())
				row.setConto(getStringData(itCell.next()));
			
			rows.add(row);
			logger.info("Popolato il secondo vettore di utilità");
			logger.info(row.toString());
		}
		
		return rows;
	}
	
	private static String getStringData(Cell cell) throws Exception{
		if(cell.getCellType() == Cell.CELL_TYPE_STRING){
			return cell.getStringCellValue();
		}else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC ){
			if(DateUtil.isCellDateFormatted(cell)){
				SimpleDateFormat sdf = new SimpleDateFormat(Constants.DATE_FORMAT);
				return sdf.format(cell.getDateCellValue());
			}else{
				return String.valueOf(cell.getNumericCellValue());
			}
		}else if(cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
			double d;
			try{
				d = Double.valueOf(cell.getStringCellValue());
			}catch (Exception e) {
				return cell.getStringCellValue();
			}
			return String.valueOf(d);
		}else{
			logger.error("Tipo dato non gestito");
			throw new Exception(Constants.CELL_FORMAT_ERROR);
		}
	}
	
}
