package primetables;

/*
 * Class to build the multiplication table by following all the required steps, i.e. parsing, finding the primes,
 * calculating the matrix product and displaying the multiplication matrix.
 * @author Leonardo Cardoso
 * */
public class MultiplicationTableBuilder 
{
	/*
	 * Static method used to build the multiplication table passing the input given by the user
	 * @input the number of primes, given by the user.
	 * */
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
