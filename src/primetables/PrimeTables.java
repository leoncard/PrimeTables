package primetables;

import java.io.InputStream;

/**
*Generates primes and their multiplication tables from user input.
* @author Leonardo Cardoso
*/
public class PrimeTables {

	public static void main(String[] args) {
		createPrimeTables(System.in);
    }

	/**
	 * Creates the prime tables
	 * @param in The number the user inputs through the console
	 */
	protected static void createPrimeTables(InputStream input) {
		ScanKeysPrintTable sp = new ScanKeysPrintTable();
        while(sp.running){
        	sp.scanKeys(input);}
	}

}
