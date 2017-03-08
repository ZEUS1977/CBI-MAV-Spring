package online.flussibancari.cbi.mav.consts;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Constants {

	public static final String TIPO_RECORD_IM = "IM";
	public static final String TIPO_RECORD_EF = "EF";
	public static final String TIPO_RECORD_14 = "14";
	public static final String TIPO_RECORD_20 = "20";
	public static final String TIPO_RECORD_30 = "30";
	public static final String TIPO_RECORD_40 = "40";
	public static final String TIPO_RECORD_50 = "50";
	public static final String TIPO_RECORD_51 = "51";
	public static final String TIPO_RECORD_70 = "70";
	
	public static final String FILLER_IM = "fTesta";
	public static final String FILLER_EF = "fCoda";
	public static final String FILLER_14 = "f14";
	public static final String FILLER_20 = "f20";
	public static final String FILLER_30 = "f30";
	public static final String FILLER_40 = "f40";
	public static final String FILLER_50 = "f50";
	public static final String FILLER_51 = "f51";
	public static final String FILLER_70 = "f70";
	
	public static final String BEAN_IM = "testaIM";
	public static final String BEAN_EF = "codaEF";
	public static final String BEAN_14 = "cf14";
	public static final String BEAN_20 = "cf20";
	public static final String BEAN_30 = "cf30";
	public static final String BEAN_40 = "cf40";
	public static final String BEAN_50 = "cf50";
	public static final String BEAN_51 = "cf51";
	public static final String BEAN_70 = "cf70";
	
	public static final String FW_BEAN_TESTA_IM = "testaIM";
	public static final String FW_BEAN_14 = "codiceFisso14Bean";
	public static final String FW_BEAN_20 = "codiceFisso20Bean";
	public static final String FW_BEAN_30 = "codiceFisso30Bean";
	public static final String FW_BEAN_40 = "codiceFisso40Bean";
	public static final String FW_BEAN_50 = "codiceFisso50Bean";
	public static final String FW_BEAN_51 = "codiceFisso51Bean";
	public static final String FW_BEAN_70 = "codiceFisso70Bean";
	public static final String FW_BEAN_CODA_EF = "codaEF";
	
	public static final String FW_RECORD_TESTA_IM = "testata";
	public static final String FW_RECORD_14 = "codiceFisso14";
	public static final String FW_RECORD_20 = "codiceFisso20";
	public static final String FW_RECORD_30 = "codiceFisso30";
	public static final String FW_RECORD_40 = "codiceFisso40";
	public static final String FW_RECORD_50 = "codiceFisso50";
	public static final String FW_RECORD_51 = "codiceFisso51";
	public static final String FW_RECORD_70 = "codiceFisso70";
	public static final String FW_RECORD_CODA_EF = "coda";
	
	public static final String CAUSALE_RICHIESTA_MAV_CBI = "07000";
	public static final String SPACE = " ";
	public static final String TAB = "\t";
	public static final String SPLIT_ADDRESS_SEPARATOR = "\\s+";
	public static final String COUNTRY_COD = "IT";
	public static final Date date = new Date();
	public static final SimpleDateFormat simple = new SimpleDateFormat("ddMMyy");
	public static final String DATE_FORMAT = "dd/MM/yyyy";
	public static final String TODAY = simple.format(date);
	public static final String CODICE_DIVISA = "E";
	public static final String NEW_LINE = "\n";
	public static final String CELL_FORMAT_ERROR = "Formato cella non gestito, controlla i campi dell'Excel, sono ammessi i seguenti formati: testo, data, numero!";
	public static final String LOG_ROW_NUM = "Row No.: ";
	
	public static final String CUR_DIR = System.getProperty("user.dir");
	public static final String CONF_FILE_DEBUG = CUR_DIR +  "/src/main/resources/flatworm/cbi-mav.xml";
	public static final String CONF_FILE = CUR_DIR + "/resources/flatworm/cbi-mav.xml";
	public static final String OUT_FILE =  CUR_DIR + "/scambiodati/out/output.txt";
	public static final String GUI_NAME = "CBI MAV Converter";
	public static final String SIGN = "-";
	public static final String APP_CONTEXT = "classpath:META-INF/spring/app-context.xml";
}
