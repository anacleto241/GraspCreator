package model;

import java.util.HashMap;
import java.util.Map;

public class Database {
	private static Map<String, String[]> products = new HashMap <String, String[]> ();
	
	static {
		products.put("at", new String[] {"Arroz Tatiana","30"});
		products.put("ff", new String[] {"Feijão Feijó","20"});
		products.put("msa", new String[] {"Macarrão Santa Amália","12"});
	}
	
	public static String[] selectProduct(String code) {
		return products.get(code);
	}
	
}