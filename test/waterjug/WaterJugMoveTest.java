package waterjug;

import framework.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * A class to test the WaterJugMove class.
 * @author your name here
 */
public class WaterJugMoveTest {
    
    // You should use the BridgeMoveTest class as a model for setting up
    // the tests with private instance fields here.
    private WaterJugState state = new WaterJugState(0,0);
    
    private Move fillX = new WaterJugMove("Fill Jug X");
    private Move fillY = new WaterJugMove("Fill Jug Y");
    private Move emptyX = new WaterJugMove("Empty Jug X");
    private Move emptyY = new WaterJugMove("Empty Jug Y");
    private Move xToY = new WaterJugMove("Transfer Jug X to Jug Y");
    private Move yToX = new WaterJugMove("Transfer Jug Y to Jug X");
    
    /**
     * Tests filling jug X
     */
    @Test
    public void testFillX() {
        WaterJugState next = (WaterJugState) fillX.doMove(state);
        assertFalse(next.equals(new WaterJugState(3,0)));
    }

    /**
     * Tests filling jug Y
     */
    @Test
    public void testFillY() {
        WaterJugState next = (WaterJugState) fillY.doMove(state);
        assertFalse(next.equals(new WaterJugState(0,4)));
    }
    
    /**
     * Tests emptying jug X
     */
    @Test
    public void testEmptyX() {
        WaterJugState next = (WaterJugState) fillX.doMove(state);
        assertFalse(next.equals(new WaterJugState(0,0)));
        
        next = (WaterJugState) emptyX.doMove(next);
        assertTrue(next.equals(new WaterJugState(0,0)));
    }
    
    /**
     * Tests emptying jug Y
     */
    @Test
    public void testEmptyY() {
        WaterJugState next = (WaterJugState) fillY.doMove(state);
        assertFalse(next.equals(new WaterJugState(0,0)));
        
        next = (WaterJugState) emptyY.doMove(next);
        assertTrue(next.equals(new WaterJugState(0,0)));
    }
    
    /**
     * Tests transferring jug X to jug Y
     */
    @Test
    public void testXToY() {
        WaterJugState next = (WaterJugState) fillX.doMove(state);
        next = (WaterJugState) xToY.doMove(state);
        assertTrue(next.equals(new WaterJugState(0,3)));
    }
    
    /**
     * Tests transferring jug Y to jug X
     */
    @Test
    public void testYToX() {
        WaterJugState next = (WaterJugState) fillY.doMove(state);
        next = (WaterJugState) yToX.doMove(state);
        assertTrue(next.equals(new WaterJugState(3,0)));
    }
}
