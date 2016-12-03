
package puzzle;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author PhilJav3
 */
public class Test2 {
    
    @Test
    public void testSumManhattan() {

        PuzzleState test1 = new PuzzleState(9,2,7,6,1,8,3,4);
            //new PuzzleState('5','2','7','8',' ','4','3','6','1');

        // Here is test1:
        //          +---+---+---+
        //          | 5 | 2 | 7 |
        //          +---+---+---+
        //          | 8 |   | 4 |
        //          +---+---+---+
        //          | 3 | 6 | 1 |
        //          +---+---+---+

        PuzzleState test2 = new PuzzleState(9,8,7,4,1,2,3,6);
            //new PuzzleState('5','6','7','4',' ','8','3','2','1');

        // Here is test2:
        //          +---+---+---+
        //          | 5 | 6 | 7 |
        //          +---+---+---+
        //          | 4 |   | 8 |
        //          +---+---+---+
        //          | 3 | 2 | 1 |
        //          +---+---+---+

        assertTrue(test1.sumManhattan() == 16);
        assertTrue(test2.sumManhattan() == 24);
    }
    
}
