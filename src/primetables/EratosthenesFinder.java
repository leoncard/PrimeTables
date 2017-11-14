package primetables;

import java.util.Arrays;

/**
 *
 * @author Leonardo Cardoso
 * Class that implements the IFinderBehaviour providing the Erasthotenes algorithm behaviour to find N primes.
 */
public class EratosthenesFinder implements IFinderBehaviour{

	/*
	 * Method that find the primes 
	 * @param n number of primes
	 * @return primesArray The array of n primes
	 * */
    @Override
    public int[] findPrimes(Integer n) {
        if(numberNotAccepted(n)){
            return null;
        }
        boolean[] checkedIndexesArray = crossOutNonPrimes(n);
        int [] primesArray = getPrimes(n, checkedIndexesArray);
        return primesArray;
    }
    	/*
    	 * Crosses out all the non prime numbers less than Math.sqrt(upperBoundary)
    	 * @param n: The number of primes.
    	 * */
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
        
    /*
     * Checks if the corresponding a number has been crossed out
     * @param numbersToCheckArray The boolean array representing the numbers that will be crossed out or not.
     * @param primeCandidate The number to check if was crossed out or not.
     * */
    protected static boolean isCandidatePrime(boolean[] numbersToCheckArray, int primeCandidate) {
        return numbersToCheckArray[primeCandidate]==true;
    }
    
    /*
     * Returns the primes found
     * @param n The number of primes.
     * @param checkedNumbersArray The boolean array containing the crossed out and non crossed out numbers.
     * */
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
    
    /*
     *Returns a number higher than the nth prime.
     * @param n The number of primes.
     * */
    protected int getUpperBoundary(int n){
        int numerOfPrimesToConsider = n+firstPrimeCandidate-firstPrime;
        return numerOfPrimesToConsider==1 ? 3 : 
                numerOfPrimesToConsider<=6 ? (int)Math.ceil(numerOfPrimesToConsider*(Math.log(numerOfPrimesToConsider)+Math.log(Math.log(numerOfPrimesToConsider)))+8) :
                (int)Math.ceil(numerOfPrimesToConsider*(Math.log(numerOfPrimesToConsider)+Math.log(Math.log(numerOfPrimesToConsider)))); //Barkley Rosser, 1938
    }
    /*
     * Verifies if the passed parameter is accepted (null or less than) 1
     * @param n The number of primes
     * */
    protected boolean numberNotAccepted(Integer n) {
        return (n==null || n<1);
    }
    
}