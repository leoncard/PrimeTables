package primetables;

import java.util.ArrayList;
import static java.util.Arrays.asList;
import java.util.Collection;

/**
 *
 * @author Leonardo Cardoso
 */
class PrimeFinder {

    int[] findPrime(int n) {
        if(numberNotAcceptedCondition(n)){
            return defaultValue;
        }
        return new int[]{2};
    }
    protected final int[] defaultValue = null;

    protected boolean numberNotAcceptedCondition(int n) {
        return n<1;
    }
    
}
