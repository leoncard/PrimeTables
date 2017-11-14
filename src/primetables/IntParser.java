package primetables;

/**
 *
 * @author Leonardo Cardoso
 * Parses a valid input int to String 
 */
public class IntParser implements IParserBehaviour{

	/*
	 * Returns the parsed Integer output from a valid string
	 * @param Number of primes in string format
	 * @return Returns the parsed int
	 * */
	@Override
	public Integer getParsedOutput(String n) {
		if(isNumber(n)){
			return Integer.parseInt(n);
		}
		return null;
	}
	/*
	 * Checks if the string n is a number
	 * @return true for number or false for not a number
	 * */
	private boolean isNumber(String n) {
		return n.matches("\\d+");
	}
}
