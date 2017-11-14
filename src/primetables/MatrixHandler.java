package primetables;

/**
 *
 * @author Leonardo Cardoso
 * Handles matrix product and matrix display
 */
public class MatrixHandler {

	IMatrixComputationBehaviour computationBehaviour;
    IMatrixDisplayBehaviour displayBehaviour;
        
    /*
     * Constructor that receives a computation behaviour
     * @param IMatrixComputationBehaviour the computation behaviour to be used
     * */    
	public MatrixHandler(IMatrixComputationBehaviour selectedComputationBehaviour){
		computationBehaviour = selectedComputationBehaviour;
	}
        
		/*
		 * Constructor that receives a display behaviour
		 * @param IMatrixDisplayBehaviour the display behaviour to be used
		 * */    
        public MatrixHandler(IMatrixDisplayBehaviour selectedDisplayBehaviour){
		displayBehaviour = selectedDisplayBehaviour;
	}
        
	   /*
	   * Calculates a resulting matrix according to the computation behaviour
	   * @param n The number of primes
	   * */
       public long [][] calculateMatrix(int []n){
		return computationBehaviour.calculate(n);
	}

       /*
        * Generates the display according to the display behaviour passed
        * @param primesFound the array of primes that were found
        * @param matrixProduct the array of products of those primes 
        * */
    void generateMultiplicationTableDisplay(int[] primesFound, long[][] matrixProduct) {
    	displayBehaviour.display(primesFound, matrixProduct);
    }

}


