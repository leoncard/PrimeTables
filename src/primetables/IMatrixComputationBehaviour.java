package primetables;

/**
 *
 * @author Leonardo Cardoso
 * Interface for the matrix computation behaviours
 */
public interface IMatrixComputationBehaviour {

	/*
	 * Method to be implemented by ComputationBehaviour classes. Calculates the resulting array after a computation was applied to it.
	 * @param n The number of primes
	 * */
    public long[][] calculate(int[] n);
    
}
