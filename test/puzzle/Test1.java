
package puzzle;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author PhilJav3
 */
public class Test1 {

    @Test
    public void testTilesOutOfPlace() {

        PuzzleState finalState = new PuzzleState(1,2,3,6,9,8,7,4);
	    //new PuzzleState('1', '2', '3', '8', ' ', '4', '7', '6', '5');

        // Here is finalState:
        //          +---+---+---+
        //          | 1 | 2 | 3 |
        //          +---+---+---+
        //          | 8 |   | 4 |
        //          +---+---+---+
        //          | 7 | 6 | 5 |
        //          +---+---+---+
        
        PuzzleState startState = new PuzzleState(4,1,3,6,9,5,7,2);
            //new PuzzleState('2','8','3','1','6','4','7',' ','5');
        
        // Here is startState:
        //          +---+---+---+
        //          | 2 | 8 | 3 |
        //          +---+---+---+
        //          | 1 | 6 | 4 |
        //          +---+---+---+
        //          | 7 |   | 5 |
        //          +---+---+---+

        assertTrue(finalState.tilesOutOfPlace() == 0);
        assertTrue(startState.tilesOutOfPlace() == 4);
    }
    
}
