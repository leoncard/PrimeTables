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
                { 4, new int[]{2,3,5,7}}
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
