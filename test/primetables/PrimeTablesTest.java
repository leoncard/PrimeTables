package primetables;

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
        int result = pf.findPrime(1); //Act
        assertEquals(result,2); //Assert
    }
    
    @Test
    public void findPrime_nEqualsZero_ReturnNull(){
        PrimeFinder pf = new PrimeFinder(); //Arrange
        int result = pf.findPrime(0); //Act
        assertEquals(result,null); //Assert
    }
    
}
