package primetables;

/**
 *
 * @author Leonardo Cardoso
 */
public class IntParser implements IParserBehaviour{

	@Override
	public Integer getParsedOutput(String n) {
		if(isNumber(n)){
			return Integer.parseInt(n);
		}
		return null;
	}

	private boolean isNumber(String n) {
		return n.matches("\\d+");
	}
}
