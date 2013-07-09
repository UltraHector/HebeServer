package com.TroyEmpire.HebeServer.constants;

/**
 * Hold all the constants used in the Hebe Webserver
 */
public class Constant {
	public static final String DB_PATH = "C:\\Documents and Settings\\Administrator\\×ÀÃæ\\Hebe-Version-1.0-Server\\Eclipse_Workplace\\HebeServer\\WebContent\\DBData";
	
	// Grab News Constants
	public static final String JWC_NEWS_PORTAL_URL = "http://jwcweb.jnu.edu.cn/SmallClass_index.asp?SmallClassName=%CD%A8%D6%AA&BigClassName=%BD%CC%CE%F1%B4%A6";
	public static final String XSC_PORTAL_URL = "http://xsc.jnu.edu.cn/";
	public static final String JWC_ROOT_URL = "http://jwcweb.jnu.edu.cn/";
	// the interval to grab the news
	public static final int INTERVAL_GRAB_NEWS = 3600000;
	
	// the number of returned news to the client side
	public static final int NUMBER_UPDATE_NEWS_TO_CLIENT = 20;
	
	
	
	
	
}
