package primetables;

/**
 *
 * Interface for the Parser behaviours
 * @author Leonardo Cardoso
 */
public interface IParserBehaviour {

	/**
	 * Returns the parsed output
	 * @param n The input for the parser.
	 * @return The parsed string to int
	 * */
	Integer getParsedOutput(String n);

}
