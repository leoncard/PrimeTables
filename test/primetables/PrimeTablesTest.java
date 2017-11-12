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
                { 46, new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199}} 
	  };
  }
    
    @Test
    public void findPrime_nEqualsZero_ReturnNull(){
        PrimeFinder pf = new PrimeFinder(); //Arrange
        int[] result = pf.findPrimes(0); //Act
        int [] expected = null;
        assertEquals(result,expected); //Assert
    }
    
    @Test(dataProvider = "expectedPrimes")
    public void findPrime_n_ReturnExpectedPrimes(int n, int[] expected){
        PrimeFinder pf = new PrimeFinder();
        assertEquals(pf.findPrimes(n),expected);
    }
}
