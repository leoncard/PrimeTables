package primetables;

/**
 *
 * @author Leonardo Cardoso
 */
class MultiplicationTableDisplay implements IMatrixDisplayBehaviour {

    public MultiplicationTableDisplay() {
    }

    @Override
    public void display(int[] primesArray, int[][] matrixProduct) {
        int maxElement = matrixProduct[matrixProduct.length-1][matrixProduct.length-1];
        int maxDigits = (int) Math.ceil(Math.log10(maxElement));
        int additionalSpace = 2;
        int spaceToAdd=maxDigits+additionalSpace;
        System.out.printf("|","%"+spaceToAdd+"s");
        System.out.printf("%"+spaceToAdd+"s","|");
        for (int i=0;i<primesArray.length;i++) {
                System.out.printf("%"+spaceToAdd+"s", primesArray[i]+"|");
        }
        System.out.println();
        for (int i=0;i<matrixProduct.length;i++) {
            System.out.printf("|","%"+spaceToAdd+"s");
            System.out.printf("%"+spaceToAdd+"s", primesArray[i]+"|");
            for (int j=0; j<matrixProduct[i].length; j++) {
                System.out.printf("%"+spaceToAdd+"s", matrixProduct[i][j]+"|");
            }
            System.out.println();
        }
        System.out.println();
    }
    
}
