package primetables;

public class Parser {

	IParserBehaviour parseBehaviour;
	public Parser(IParserBehaviour selectedParserBehaviour) {
		parseBehaviour=selectedParserBehaviour;
	}
	
	public int parseToInt(String n){
		return parseBehaviour.getParsedOutput(n);
	}

}
