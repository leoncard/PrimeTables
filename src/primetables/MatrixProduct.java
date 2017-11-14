package primetables;

/**
 *
 * Class that implements the IMatrixComputationBehaviour and provides the MatrixProduct computation behaviour.
 * @author Leonardo Cardoso
 */
public class MatrixProduct implements IMatrixComputationBehaviour {

	/**
	 * Calculates the matrix product
	 * @param factorsArray The array of numbers used in the computation
	 * @return the Matrix Product
	 * */
    @Override
    public long[][] calculate(int[] factorsArray) {
        if(factorsArray==null){
            return null;}
        int size = factorsArray.length;
        long [][] matrixProduct = new long[size][size];
        for(int i =0;i<size;i++){
            for (int j=0;j<size;j++){
                matrixProduct[i][j]=(long)factorsArray[i]*(long)factorsArray[j];
            }
        }
        return matrixProduct;
    }
    
}
