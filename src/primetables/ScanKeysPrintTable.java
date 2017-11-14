package primetables;

import java.util.Scanner;
/**
*
* Searches for user inputs to find primes and build the multplication table
* @author Leonardo Cardoso
*/
public class ScanKeysPrintTable {

    /**
     * Searches for the user input and builds the multiplication table
     * @param in The user input, which should be a valid number
     * */
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

    /**
     * Verifies if the entry can be converted from String to int.
     * */
    protected boolean isNumber(String n) {
		return n.matches("\\d+");
	}
    
    protected boolean running = true; //True while the program is running, false otherwise
    
}
