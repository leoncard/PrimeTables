package primetables;

import java.util.Arrays;

/**
 *
 * @author Leonardo Cardoso
 */
public class EratosthenesFinder implements IFinderBehaviour{

    @Override
    public int[] findPrimes(Integer n) {
        if(numberNotAccepted(n)){
            return null;
        }
        boolean[] checkedIndexesArray = crossOutNonPrimes(n);
        int [] primesArray = getPrimes(n, checkedIndexesArray);
        return primesArray;
    }

        protected boolean[] crossOutNonPrimes(int n) {
        int upperBoundary = getUpperBoundary(n);
        boolean[] numbersToCheckArray = new boolean[upperBoundary];
        Arrays.fill(numbersToCheckArray, true);
        for(int primeCandidate = firstPrime; primeCandidate<Math.sqrt(upperBoundary); primeCandidate++){
            if(isCandidatePrime(numbersToCheckArray, primeCandidate)){
                for (int nonPrime = (int)Math.pow(primeCandidate, 2); nonPrime<upperBoundary;nonPrime+=primeCandidate){
                    numbersToCheckArray[nonPrime]=false;
                }
            }
        }
        return numbersToCheckArray;
    }

    protected static boolean isCandidatePrime(boolean[] numbersToCheckArray, int primeCandidate) {
        return numbersToCheckArray[primeCandidate]==true;
    }
    
    protected int[] getPrimes(int n, boolean[] checkedNumbersArray) {
        int [] primesArray = new int[n];
        int primesFound=0;
        for (int primeCandidate = firstPrimeCandidate; primesFound<n;primeCandidate++){
            if(isCandidatePrime(checkedNumbersArray, primeCandidate)){
                primesArray[primesFound]=primeCandidate;
                primesFound++;
            }
        }
        return primesArray;
    }
    protected final int[] defaultValue = null;
    protected final int firstPrime = 2;
    protected int firstPrimeCandidate = firstPrime;
    protected int getUpperBoundary(int n){
        int numerOfPrimesToConsider = n+firstPrimeCandidate-firstPrime;
        return numerOfPrimesToConsider==1 ? 3 : 
                numerOfPrimesToConsider<=6 ? (int)Math.ceil(numerOfPrimesToConsider*(Math.log(numerOfPrimesToConsider)+Math.log(Math.log(numerOfPrimesToConsider)))+8) :
                (int)Math.ceil(numerOfPrimesToConsider*(Math.log(numerOfPrimesToConsider)+Math.log(Math.log(numerOfPrimesToConsider)))); //Barkley Rosser, 1938
    }
    protected boolean numberNotAccepted(Integer n) {
        return (n==null || n<1);
    }
    
}