package primetables;

/**
 *
 * @author Leonardo Cardoso
 * Interface for the display behaviours.
 */
public interface IMatrixDisplayBehaviour {

	/*
	 * Method to be implemented by the DisplayBehaviour classes to produce a display
	 * */
	public void display(int[] primesFound, long[][] matrixProduct);
    
}
