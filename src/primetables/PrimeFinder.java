package primetables;

/**
 *
 * Handles the prime finder algorithms
 * @author Leonardo Cardoso
 */

public class PrimeFinder {

	IFinderBehaviour primeFinderBehaviour;
	/**
	 * Constructor that receives a finder behaviour to find primes
	 * @param selectedBehaviour the finder behaviour to be used
	 * */    
	public PrimeFinder(IFinderBehaviour selectedBehaviour){
		primeFinderBehaviour = selectedBehaviour;
	}
        
	/**
	 * Find primes according to the finder behaviour passed
	 * @param n The number of primes to be found
	 * @return The array of primes that were found.
	 * */
       public int [] find(Integer n){
		return primeFinderBehaviour.findPrimes(n);
	}

}


