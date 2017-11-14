package primetables;

/**
 *
 * Class that implements the IMatrixDisplayBehaviour providing the console display behaviour 
 * to show the primes' multiplication table.
 * @author Leonardo Cardoso
 */
class MultiplicationTableDisplay implements IMatrixDisplayBehaviour {

    public MultiplicationTableDisplay() {
    }

    /**
     * Prints the multiplication table in the console.
     * @param factorsArray the factors of the multiplication table
     * @matrixProduct the products of the factors
     * */
    @Override
    public void display(int[] factorsArray, long[][] matrixProduct) {
    	if(inputIsNull(factorsArray, matrixProduct)){
    		System.out.printf("");
    	}
    	else{
	        long maxElement = matrixProduct[matrixProduct.length-1][matrixProduct.length-1];
	        int maxDigits = (int) Math.ceil(Math.log10(maxElement));
	        int additionalSpace = 2;
	        int spaceToAdd=maxDigits+additionalSpace;
	        System.out.printf("|","%"+spaceToAdd+"s");
	        System.out.printf("%"+spaceToAdd+"s","|");
	        for (int i=0;i<factorsArray.length;i++) {
	                System.out.printf("%"+spaceToAdd+"s", factorsArray[i]+"|");
	        }
	        System.out.println();
	        for (int i=0;i<matrixProduct.length;i++) {
	            System.out.printf("|","%"+spaceToAdd+"s");
	            System.out.printf("%"+spaceToAdd+"s", factorsArray[i]+"|");
	            for (int j=0; j<matrixProduct[i].length; j++) {
	                System.out.printf("%"+spaceToAdd+"s", matrixProduct[i][j]+"|");
	            }
	            System.out.println();
	        }
	        System.out.println();
    	}
	}

    /**
     * Verifies if the arrays passed as input are null.
     * */
	private boolean inputIsNull(int[] factorsArray, long[][] matrixProduct) {
		return factorsArray==null || matrixProduct==null;
	}
    
}
