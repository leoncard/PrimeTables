package primetables;

/**
 *
 * @author Leonardo Cardoso
 */

public class MatrixHandler {

	IMatrixComputationBehaviour computationBehaviour;
	public MatrixHandler(IMatrixComputationBehaviour selectedBehaviour){
		computationBehaviour = selectedBehaviour;
	}
        
       public int [][] calculateMatrix(int []n){
		return computationBehaviour.calculate(n);
	}

}


