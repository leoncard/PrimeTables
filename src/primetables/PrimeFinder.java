package primetables;

/**
 *
 * @author Leonardo Cardoso
 */

public class PrimeFinder {

	IFinderBehaviour primeFinderBehaviour;
	public PrimeFinder(IFinderBehaviour selectedBehaviour){
		primeFinderBehaviour = selectedBehaviour;
	}
        
       public int [] find(int n){
		return primeFinderBehaviour.findPrimes(n);
	}

}


