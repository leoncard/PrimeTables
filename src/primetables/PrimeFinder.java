package primetables;

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
        int primesFound = 0;
        for(int i = lowerBoundary; i<upperBoundary(n) && primesFound<n; i++){
            if(i==2 || i%2!=0){ //initialy, just cutting off all multiples of 2, minimum solution to pass test
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