package primetables;

/**
 *
 * Interface for the matrix computation behaviours
 * @author Leonardo Cardoso
 */
public interface IMatrixComputationBehaviour {

	/**
	 * Method to be implemented by ComputationBehaviour classes. Calculates the resulting array after a computation was applied to it.
	 * @param n The number of primes
	 * @return the matrix after the computation
	 * */
    public long[][] calculate(int[] n);
    
}
