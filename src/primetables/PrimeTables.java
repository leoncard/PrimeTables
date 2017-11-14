package primetables;

import java.io.InputStream;

/**
*
* @author Leonardo Cardoso
*/
public class PrimeTables {

	public static void main(String[] args) {
		createPrimeTables(System.in);
    }

	protected static void createPrimeTables(InputStream in) {
		ScanKeysPrintTable sp = new ScanKeysPrintTable();
        while(sp.running){
        	sp.scanKeys(in);}
	}

}
