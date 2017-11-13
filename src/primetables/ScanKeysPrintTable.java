package primetables;

/**
 *
 * @author Leonardo Cardoso
 */

import java.util.Scanner;
public class ScanKeysPrintTable {

    
    public void scanKeys(java.io.InputStream in) throws NumberFormatException {
        try (Scanner keys = new Scanner(in)) {
            boolean quit = false;
            while (!quit) {
                System.out.println("How many primes would you like to generate? (type exit to quit):");
                String input = keys.nextLine();
                if (isNumber(input)) {
                    System.out.println("isNumber");
                }
                else if ("exit".equals(input)) {
                    System.out.println("Exiting...");
                    quit = true;
                }
            }
        }
    }
    
    private boolean isNumber(String n) {
		return n.matches("\\d+");
	}
    
}
