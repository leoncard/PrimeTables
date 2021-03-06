package primetables;

/**
 *
 * Class that implements the IParserBehaviour providing a parser behaviour to allow only valid numbers.
 * @author Leonardo Cardoso
 */
public class Parser {

	IParserBehaviour parseBehaviour;
	
	/**
	 * Receives a parser behaviour as parameter to provide that behaviour 
	 * IParserBehaviour the be behaviour passed as parameter
	 * @param selectedParserBehaviour The selected behaviour
	 * */
	public Parser(IParserBehaviour selectedParserBehaviour) {
		parseBehaviour=selectedParserBehaviour;
	}
	
	/**
	 * Parses to Int according to the parseBehaviour passed
	 * @param n the String to be converted to int
	 * @return an integer converted from the string
	 * */
	public Integer parseToInt(String n){
		return parseBehaviour.getParsedOutput(n);
	}

}
