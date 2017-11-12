package primetables;

import java.util.Arrays;

/**
 *
 * @author Leonardo Cardoso
 */
class PrimeFinder {

    int[] findPrimes(int n) {
        if(numberNotAcceptedCondition(n)){
            return defaultValue;
        }
        int [] primesArray = new int[n];
        boolean[] numbersToCheckArray = new boolean[upperBoundary(n)];
        Arrays.fill(numbersToCheckArray, true);
        for(int primeCandidate = lowerBoundary; primeCandidate<upperBoundary(n); primeCandidate++){
            if(numbersToCheckArray[primeCandidate]==true){
                for (int nonPrime = (int)Math.pow(primeCandidate, 2); nonPrime<upperBoundary(n);nonPrime+=primeCandidate){
                    numbersToCheckArray[nonPrime]=false;
                }
            }
        }
        int primesFound = 0;
        for (int i =lowerBoundary; i<upperBoundary(n) && primesFound<n;i++){
            if(numbersToCheckArray[i]==true){
                primesArray[primesFound]=i;
                primesFound++;
            }
        }
        return primesArray;
    }
    protected final int[] defaultValue = null;
    protected int lowerBoundary = 2;
    protected int upperBoundary(int n){
            return n==1 ? 3 : (int)Math.ceil(n*(Math.log(n)+Math.log(Math.log(n)))+8); //Barkley Rosser, 1938
    }
    protected boolean numberNotAcceptedCondition(int n) {
        return n<1;
    }
    
}