package primetables;

/**
 *
 * Interface for the find primes behaviours.
 * @author Leonardo Cardoso
 */
public interface IFinderBehaviour {
	/**
	 * Method that find the primes 
	 * @param n number of primes
	 * @return The primes
	 * */
    public abstract int[] findPrimes(Integer n);
    
}
