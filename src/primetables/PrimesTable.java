package primetables;
/**
*
* @author Leonardo Cardoso
*/
public class PrimesTable {

	public static void main(String[] args) {
		ScanKeysPrintTable sp = new ScanKeysPrintTable();
        while(sp.running){
        	sp.scanKeys(System.in);}
    }

}
