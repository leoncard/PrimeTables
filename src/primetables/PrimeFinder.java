package primetables;

/**
 *
 * @author Leonardo Cardoso
 * Handles the prime finder algorithms
 */

public class PrimeFinder {

	IFinderBehaviour primeFinderBehaviour;
	/*
	 * Constructor that receives a finder behaviour to find primes
	 * @param IFinderBehaviour the finder behaviour to be used
	 * */    
	public PrimeFinder(IFinderBehaviour selectedBehaviour){
		primeFinderBehaviour = selectedBehaviour;
	}
        
	/*
	 * Find primes according to the finder behaviour passed
	 * @param n The number of primes to be found
	 * */
       public int [] find(Integer n){
		return primeFinderBehaviour.findPrimes(n);
	}

}


