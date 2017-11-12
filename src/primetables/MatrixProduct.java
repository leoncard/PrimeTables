package primetables;

/**
 *
 * @author Leonardo Cardoso
 */
public class MatrixProduct implements IMatrixComputationBehaviour {

    @Override
    public int[][] calculate(int[] factorsArray) {
        int size = factorsArray.length;
        int [][] matrixProduct = new int[size][size];
        for(int i =0;i<size;i++){
            for (int j=0;j<size;j++){
                matrixProduct[i][j]=factorsArray[i]*factorsArray[j];
            }
        }
        return matrixProduct;
    }
    
}
