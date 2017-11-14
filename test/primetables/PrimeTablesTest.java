package primetables;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.testng.annotations.Test;
import static org.testng.Assert.*;
import org.testng.internal.junit.ArrayAsserts;
import org.testng.annotations.DataProvider;

/**
 *
 * @author Leonardo Cardoso
 */
public class PrimeTablesTest {
    
  //N and expected primes according to N, where N is the number of primes to be found.	
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
  
  //Inputs for the parser to  convert to Integer
  @DataProvider(name="stringInputsToIntParser")
  public Object[][] createStringInputsToIntParserData() {
	  return new Object[][] {
              {"",null},
              {"0",0},
              {"-1",null},
              {String.valueOf(Integer.MAX_VALUE),Integer.MAX_VALUE},
              {"87ydwes8g23dewf",null},
          };
  }
  
  //Inputs to the scanner to generate the multiplication table
  @DataProvider(name="scannerInputs")
  public Object[][] createScannerInputData() {
	  return new Object[][] {
              {"exit","Exiting..."},
              {"2","|  | 2| 3|\n" +"| 2| 4| 6|\n" +"| 3| 6| 9|\n\n"},
              {"3", "|   |  2|  3|  5|\n" + "|  2|  4|  6| 10|\n" + "|  3|  6|  9| 15|\n" + "|  5| 10| 15| 25|\n\n"}
          };
  }
    
  //Invalid inputs for the primes finder to test Erathostenes behaviour
  @DataProvider(name="invalidInputs")
  public Object[][] createInvalidInputData() {
	  return new Object[][] {
              {Integer.MIN_VALUE,null},
              {0,null},
              {null,null}
          };
  }
  
  //Matrices product to test the MatrixProduct beahviour
  @DataProvider(name="matricesProduct")
  public Object[][] createMatrixProductData() {
	  return new Object[][] {
              {new int[]{2,3},new long[][]{{4,6},{6,9}}},
              {new int[]{2}, new long[][]{{4}}},
              {new int[]{104729}, new long[][]{{10968163441L}}},
              {new int[]{}, new long[][]{}},
              {null,null}
          };
  }
  
  //Integration test to check the modules behaviour when working together
  @DataProvider(name="integrationTest_Parser_Finder_MatrixProduct_MultiplicationTableData")
  public Object[][] createParser_Finder_MatrixProduct_MultiplicationTableData() {
	  return new Object[][] {
              {"2","|  | 2| 3|\n" +"| 2| 4| 6|\n" +"| 3| 6| 9|\n\n"},
              {"3", "|   |  2|  3|  5|\n" + "|  2|  4|  6| 10|\n" + "|  3|  6|  9| 15|\n" + "|  5| 10| 15| 25|\n\n"},
              {"65fyt",""}
          };
  }
  
  //Resulting multiplication tables according to the factors and their matrix product
  @DataProvider(name="multiplicationTables")
  public Object[][] createMultiplicationTableData() {
	  return new Object[][] {
              {new int[]{2,3},new long[][]{{4,6},{6,9}},"|  | 2| 3|\n" +"| 2| 4| 6|\n" +"| 3| 6| 9|\n\n"},
              {new int[]{2,3,5}, new long[][]{{4,6,10},{6,9,15},{10,15,25}}, "|   |  2|  3|  5|\n" + "|  2|  4|  6| 10|\n" + "|  3|  6|  9| 15|\n" + "|  5| 10| 15| 25|\n\n"},
              {null,new long[][]{{4,6,10},{6,9,15},{10,15,25}},""},
              {new int[]{2,3,5},null,""},
			  {null,null,""},
          };
  }
  
  //Testing erathostenes for invalid inputs
    @Test(dataProvider = "invalidInputs")
    public void findPrime_nInvalidNumber_ReturnNull(Integer n, int[] expected){
        IFinderBehaviour eratosthenes = new EratosthenesFinder();
        PrimeFinder eratosthenesFinder = new PrimeFinder(eratosthenes); //Arrange
        assertEquals(eratosthenesFinder.find(n),expected); //Assert
    }
    
    //Testing erathostenes for valid inputs
    @Test(dataProvider = "expectedPrimes")
    public void findPrime_n_ReturnExpectedPrimes(int n, int[] expected){
        IFinderBehaviour eratosthenes = new EratosthenesFinder();
        PrimeFinder eratosthenesFinder = new PrimeFinder(eratosthenes);
        assertEquals(eratosthenesFinder.find(n),expected);
    }
    
    //Testing if the algorithm is able to generate a large number of primes
    @Test
    public void findPrime_n10Million_ReturnExpectedNumberofPrimes(){
        IFinderBehaviour eratosthenes = new EratosthenesFinder();
        PrimeFinder eratosthenesFinder = new PrimeFinder(eratosthenes);
        assertEquals(eratosthenesFinder.find(10000000).length,10000000);
    }
    

    //Testing the matrix product
    @Test(dataProvider = "matricesProduct")
    public void calculateMatrixProduct_n_ReturnExpectedMatrixProduct(int[] primesFound, long[][]expected){
        IMatrixComputationBehaviour computeMatrixProduct = new MatrixProduct();
        MatrixHandler matrixProductComputation = new MatrixHandler(computeMatrixProduct);
        long [][] matrixFound = matrixProductComputation.calculateMatrix(primesFound);
        ArrayAsserts.assertArrayEquals(matrixFound,expected); //So that it passes on Eclipse's TestNG 6.12
    }
    
    //Testing if the multiplication tables are correctly displayed
    @Test(dataProvider = "multiplicationTables")
    public void displayMultiplicationTable_n_ReturnMultiplicationTable(int[] primesFound, long[][] MatrixProduct, String expected){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        IMatrixDisplayBehaviour displayMultiplicationTable = new MultiplicationTableDisplay();
        MatrixHandler outputMatrix = new MatrixHandler(displayMultiplicationTable);
        outputMatrix.generateMultiplicationTableDisplay(primesFound, MatrixProduct);
        assertEquals(outContent.toString(),expected);
    }
    
    //Testing if the parser is able to parse the inputs to int and identify what is not valid
    @Test(dataProvider = "stringInputsToIntParser")
    public void parser_n_ReturnedParsedInt(String input, Integer expected){
    	IParserBehaviour parseInt = new IntParser();
        Parser parser = new Parser(parseInt);
        assertEquals(parser.parseToInt(input),expected);
    }
    
    //Integration test to check the behaviour of the different classes together
    @Test(dataProvider="integrationTest_Parser_Finder_MatrixProduct_MultiplicationTableData")
    public void integrationTest_ParseAndGeneratePrimesAndGenerateMatrixProduct_GenerateDisplay(String input, String expected){
    	IParserBehaviour parseInt = new IntParser();
        Parser parser = new Parser(parseInt);
        Integer n = parser.parseToInt(input);
        IFinderBehaviour eratosthenes = new EratosthenesFinder();
        PrimeFinder eratosthenesFinder = new PrimeFinder(eratosthenes);
        IMatrixDisplayBehaviour displayMultiplicationTable = new MultiplicationTableDisplay();
        int[]primesFound = eratosthenesFinder.find(n);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        IMatrixComputationBehaviour computeMatrixProduct = new MatrixProduct();
        MatrixHandler matrixProductComputation = new MatrixHandler(computeMatrixProduct);
        long [][] matrixProduct = matrixProductComputation.calculateMatrix(primesFound);
        MatrixHandler outputMatrix = new MatrixHandler(displayMultiplicationTable);
        outputMatrix.generateMultiplicationTableDisplay(primesFound, matrixProduct);
        assertEquals(outContent.toString(),expected);
    }
    
    //Testing if the data passed to the scanner results in the proper display
    @Test(dataProvider="scannerInputs")
    public void testScanner(String input, String expected){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        ScanKeysPrintTable sp = new ScanKeysPrintTable();
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        sp.scanKeys(System.in);
        System.setIn(System.in);
        assertTrue(outContent.toString().contains(expected));
    }
    
}
