package de.violante.dennis.model.enums;

public enum Charsets {
UTF8("UTF-8");

private String charset;	
	
private Charsets(String charset) {
	this.charset = charset;
}
public String getCharset(){
	return this.charset;
}
}
