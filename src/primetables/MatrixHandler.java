package primetables;

/**
 *
 * @author Leonardo Cardoso
 */

public class MatrixHandler {

	IMatrixComputationBehaviour computationBehaviour;
        IMatrixDisplayBehaviour displayBehaviour;
	public MatrixHandler(IMatrixComputationBehaviour selectedComputationBehaviour){
		computationBehaviour = selectedComputationBehaviour;
	}
        
        public MatrixHandler(IMatrixDisplayBehaviour selectedDisplayBehaviour){
		displayBehaviour = selectedDisplayBehaviour;
	}
        
       public int [][] calculateMatrix(int []n){
		return computationBehaviour.calculate(n);
	}

    void generateMultiplicationTableDisplay(int[] primesFound, int[][] matrixProduct) {
    	displayBehaviour.display(primesFound, matrixProduct);
    }

}


