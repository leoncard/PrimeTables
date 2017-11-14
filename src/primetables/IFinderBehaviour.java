package primetables;

/**
 *
 * @author Leonardo Cardoso
 * Interface for the find primes behaviours.
 */
public interface IFinderBehaviour {
	/*
	 * Method that find the primes 
	 * @param n number of primes
	 * */
    public abstract int[] findPrimes(Integer n);
    
}
