package primetables;

public class MultiplicationTableBuilder 
{
	public static void buildMultiplicationTable(String input) {
		IParserBehaviour parseInt = new IntParser();
		Parser parser = new Parser(parseInt);
		Integer n = parser.parseToInt(input);
		IFinderBehaviour eratosthenes = new EratosthenesFinder();
		PrimeFinder eratosthenesFinder = new PrimeFinder(eratosthenes);
		IMatrixDisplayBehaviour displayMultiplicationTable = new MultiplicationTableDisplay();
		int[]primesFound = eratosthenesFinder.find(n);
		IMatrixComputationBehaviour computeMatrixProduct = new MatrixProduct();
		MatrixHandler matrixProductComputation = new MatrixHandler(computeMatrixProduct);
		long [][] matrixProduct = matrixProductComputation.calculateMatrix(primesFound);
		MatrixHandler outputMatrix = new MatrixHandler(displayMultiplicationTable);
		outputMatrix.generateMultiplicationTableDisplay(primesFound, matrixProduct);
	}
   
   
}
