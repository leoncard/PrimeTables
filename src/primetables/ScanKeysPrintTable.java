package primetables;

/**
 *
 * @author Leonardo Cardoso
 */

import java.util.Scanner;
public class ScanKeysPrintTable {

    
    public void scanKeys(java.io.InputStream in) {
        Scanner keys = new Scanner(in);
                System.out.println("How many primes would you like to generate? (type exit to quit):");
                String input = keys.nextLine();
                if (isNumber(input)) {
                	MultiplicationTableBuilder.buildMultiplicationTable(input);
                }
                else if ("exit".equals(input)) {
                    System.out.println("Exiting...");
                    running = false;
                    keys.close();
                }
    }

    protected boolean isNumber(String n) {
		return n.matches("\\d+");
	}
    
    protected boolean running = true;
    
}
