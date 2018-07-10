package online.flussibancari.cbi.mav.utils;

import org.apache.commons.lang.StringUtils;

public class CleanImport {
	
	public static String cleanImport(String imp){
		
		return imp.replace(",",StringUtils.EMPTY).
					replace(".",StringUtils.EMPTY).
					replace("€",StringUtils.EMPTY).
					replace(" ",StringUtils.EMPTY);
				
	}
}
