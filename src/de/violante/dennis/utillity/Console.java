package de.violante.dennis.utillity;

public class Console implements Singleton {

	private static Console c;
	
	private Console(){
		
	}
	
	public static synchronized Console getInstance(){
		if(c == null){
			
			c = new Console();
			
		}
		return c;
	}
	/**
	 * Du faule Sau solltest das mal implementieren
	 * @return Der eingelesene String
	 */
	public String readLine(){
		return "Not implemented";
	}
	/**
	 * Übergibt einen String an die Konsole
	 * @param s Der zu übergebende String
	 */
	public void toConsole(String s){
		System.out.println(s);
	}
}
