package primetables;

/**
 *
 * Interface for the display behaviours.
 * @author Leonardo Cardoso
 */
public interface IMatrixDisplayBehaviour {

	/**
	 * Method to be implemented by the DisplayBehaviour classes to produce a display
	 * @param primesFound The primes found so far.
	 * @param matrixProduct The matrix product previously found.
	 * */
	public void display(int[] primesFound, long[][] matrixProduct);
    
}
