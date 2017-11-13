package primetables;

public class Parser {

	IParserBehaviour parseBehaviour;
	public Parser(IParserBehaviour selectedParserBehaviour) {
		parseBehaviour=selectedParserBehaviour;
	}
	
	public Integer parseToInt(String n){
		return parseBehaviour.getParsedOutput(n);
	}

}
