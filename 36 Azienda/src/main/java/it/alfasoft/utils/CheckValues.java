package it.alfasoft.utils;

public class CheckValues {
	
	//Questo metodo controlla la correttezza della stringa passata
	public static boolean checkString(String temp) {
		
		if (temp != null && !temp.isEmpty())
			return true;
		
		return false;
	}
}
