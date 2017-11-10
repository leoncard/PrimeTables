package primetables;

import java.util.ArrayList;
import static java.util.Arrays.asList;
import java.util.Collection;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author Leonardo Cardoso
 */
public class PrimeTablesTest {
    
    @Test
    public void findPrime_nEqualsOne_ReturnTwo(){
        PrimeFinder pf = new PrimeFinder(); //Arrange
        int[] result = pf.findPrime(1); //Act
        int[] expected = new int[]{2};
        assertEquals(result,expected); //Assert
    }
    
    @Test
    public void findPrime_nEqualsZero_ReturnNull(){
        PrimeFinder pf = new PrimeFinder(); //Arrange
        int[] result = pf.findPrime(0); //Act
        int [] expected = null;
        assertEquals(result,expected); //Assert
    }
    
}
