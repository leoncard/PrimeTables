package primetables;

import static org.testng.Assert.*;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

/**
 *
 * @author Leonardo Cardoso
 */
public class PrimeTablesTest {
    
  @DataProvider(name="expectedPrimes")
  public Object[][] createData() {
	  return new Object[][] {
		{ 1, new int[]{2}},
                { 2, new int[]{2,3}},
                { 3, new int[]{2,3,5}},
                { 4, new int[]{2,3,5,7}},
                { 5, new int[]{2,3,5,7,11}},
                { 6, new int[]{2,3,5,7,11,13}},
                { 7, new int[]{2,3,5,7,11,13,17}},
                { 50, new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229}},
                {100, new int[]{2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101,103,107,109,113,127,131,137,139,149,151,157,163,167,173,179,181,191,193,197,199,211,223,227,229,233,239,241,251,257,263,269,271,277,281,283,293,307,311,313,317,331,337,347,349,353,359,367,373,379,383,389,397,401,409,419,421,431,433,439,443,449,457,461,463,467,479,487,491,499,503,509,521,523,541}}
	  };
  }
    
  @DataProvider(name="invalidInputs")
  public Object[][] createInvalidInputData() {
	  return new Object[][] {
              {Integer.MIN_VALUE,null},
              {0,null}
          };
  }
  
    @Test(dataProvider = "invalidInputs")
    public void findPrime_nInvalidNumber_ReturnNull(int n, int[] expected){
        IFinderBehaviour eratosthenes = new EratosthenesFinder();
        PrimeFinder eratosthenesFinder = new PrimeFinder(eratosthenes); //Arrange
        assertEquals(eratosthenesFinder.find(n),expected); //Assert
    }
    
    @Test(dataProvider = "expectedPrimes")
    public void findPrime_n_ReturnExpectedPrimes(int n, int[] expected){
        IFinderBehaviour eratosthenes = new EratosthenesFinder();
        PrimeFinder eratosthenesFinder = new PrimeFinder(eratosthenes);
        assertEquals(eratosthenesFinder.find(n),expected);
    }
    
    @Test
    public void findPrime_n10Million_ReturnExpectedPrimes(){
        IFinderBehaviour eratosthenes = new EratosthenesFinder();
        PrimeFinder eratosthenesFinder = new PrimeFinder(eratosthenes);
        assertEquals(eratosthenesFinder.find(10000000).length,10000000);
    }
    
    @Test
    public void buildMultiplicationMatrix_n2_ReturnMultiplicationMatrix(){
        IFinderBehaviour eratosthenes = new EratosthenesFinder();
        PrimeFinder eratosthenesFinder = new PrimeFinder(eratosthenes);
        int [] primesFound = eratosthenesFinder.find(2);
        IMatrixComputationBehaviour computeMatrixProduct = new MatrixProduct();
        MatrixHandler matrixProductComputation = new MatrixHandler(computeMatrixProduct);
        int [][] matrixFound = matrixProductComputation.calculateMatrixProduct(primesFound);
        int [][] expected = new int[][]{{4,6},{6,9}};
        assertEquals(expected,matrixFound);
    }
    
}
