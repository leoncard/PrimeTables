package primetables;

import java.util.Arrays;

/**
 *
 * @author Leonardo Cardoso
 */
class PrimeFinder {

    int[] findPrimes(int n) {
        if(numberNotAccepted(n)){
            return defaultValue;
        }
        int [] primesArray = new int[n];
        int upperBoundary = upperBoundaryCalculator(n);
        boolean[] numbersToCheckArray = new boolean[upperBoundary];
        Arrays.fill(numbersToCheckArray, true);
        for(int primeCandidate = lowerBoundary; primeCandidate<Math.sqrt(upperBoundary); primeCandidate++){
            if(numbersToCheckArray[primeCandidate]==true){
                for (int nonPrime = (int)Math.pow(primeCandidate, 2); nonPrime<upperBoundary;nonPrime+=primeCandidate){
                    numbersToCheckArray[nonPrime]=false;
                }
            }
        }
        int primesFound = 0;
        for (int primeCandidate =lowerBoundary; primeCandidate<upperBoundary && primesFound<n;primeCandidate++){
            if(numbersToCheckArray[primeCandidate]==true){
                primesArray[primesFound]=primeCandidate;
                primesFound++;
            }
        }
        return primesArray;
    }
    protected final int[] defaultValue = null;
    protected int lowerBoundary = 2;
    protected int upperBoundaryCalculator(int n){
            return n==1 ? 3 : 
                    n<=6 ? (int)Math.ceil(n*(Math.log(n)+Math.log(Math.log(n)))+8) :
                    (int)Math.ceil(n*(Math.log(n)+Math.log(Math.log(n)))); //Barkley Rosser, 1938
    }
    protected boolean numberNotAccepted(int n) {
        return n<1;
    }
    
}