package cpmj.Utils;

public class PropertiesLoaderImpl {

	 private static PropertiesLoader loader = new PropertiesLoader();
	    
	    public static String getValor(String chave){
	            return (String)loader.getValor(chave);
	    }

	
}
