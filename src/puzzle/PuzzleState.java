
package puzzle;

import framework.State;
import graph.SimpleVertex;

/**
 * This class represents the states of the 8-Puzzle problem.
 * Creates new puzzle state and tests them for equality.
 * This class implements the <b>State</b> interface
 * and therefor imports <b>framework.State</b>.
 * @author Phil Javinsky III
 */
public class PuzzleState extends SimpleVertex implements State {
    
    private int tile1, tile2, tile3, tile4, tile5, tile6, tile7, tile8;
    
    /**
     * Creates a new puzzle state.
     * Stores the positions of the tiles.
     * @param pos1 position of tile 1
     * @param pos2 position of tile 2
     * @param pos3 position of tile 3
     * @param pos4 position of tile 4
     * @param pos5 position of tile 5
     * @param pos6 position of tile 6
     * @param pos7 position of tile 7
     * @param pos8 position of tile 8
     */
    
    public PuzzleState(int pos1, int pos2, int pos3, int pos4,
                        int pos5, int pos6, int pos7, int pos8) {
        tile1 = pos1;
        tile2 = pos2;
        tile3 = pos3;
        tile4 = pos4;
        tile5 = pos5;
        tile6 = pos6;
        tile7 = pos7;
        tile8 = pos8;
    }
    
    /**
     * Compares this puzzle state with another for equality
     * @param other the other puzzle state
     * @return true if the two states are equal, false if not
     */
    public boolean equals(Object other) {
        PuzzleState state = (PuzzleState) other;
        boolean equal = false;
        
        if (tile1 == state.getTile1Pos() &&
            tile2 == state.getTile2Pos() &&
            tile3 == state.getTile3Pos() &&
            tile4 == state.getTile4Pos() &&
            tile5 == state.getTile5Pos() &&
            tile6 == state.getTile6Pos() &&
            tile7 == state.getTile7Pos() &&
            tile8 == state.getTile8Pos()) {
                equal = true;
        }
        
        return equal;
    }
    
    /**
     * Accessor for the position of tile1.
     * @return the int value of tile1 position
     */
    public int getTile1Pos() { return tile1; }
    
    /**
     * Accessor for the position of tile2.
     * @return the int value of tile2 position
     */
    public int getTile2Pos() { return tile2; }
    
    /**
     * Accessor for the position of tile3.
     * @return the int value of tile3 position
     */
    public int getTile3Pos() { return tile3; }
    
    /**
     * Accessor for the position of tile4.
     * @return the int value of tile4 position
    */
    public int getTile4Pos() { return tile4; }
    /**
     * Accessor for the position of tile5.
     * @return the int value of tile5 position
    */ 
    public int getTile5Pos() { return tile5; }
    
    /**
     * Accessor for the position of tile6.
     * @return the int value of tile6 position
     */
    public int getTile6Pos() { return tile6; }
    
    /**
     * Accessor for the position of tile7.
     * @return the int value of tile7 position
     */
    public int getTile7Pos() { return tile7; }
    
    /**
     * Accessor for the position of tile8.
     * @return the int value of tile8 position
     */
    public int getTile8Pos() { return tile8; }

    @Override
    public int getHeuristic(State goal) {
        return tilesOutOfPlace();
    }
    
    public int tilesOutOfPlace() {
        int sum = 0;
        
        if (tile1 != 1)
            sum += 1;
        if (tile2 != 2)
            sum += 1;
        if (tile3 != 3)
            sum += 1;
        if (tile4 != 6)
            sum += 1;
        if (tile5 != 9)
            sum += 1;
        if (tile6 != 8)
            sum += 1;
        if (tile7 != 7)
            sum += 1;
        if (tile8 != 4)
            sum += 1;
        
        return sum;
    }
    
    public int sumManhattan() {
        int sum = 0;
        
        if      (tile1 == 2)
            sum += 1;
        else if (tile1 == 3)
            sum += 2;
        else if (tile1 == 4)
            sum += 1;
        else if (tile1 == 5)
            sum += 2;
        else if (tile1 == 6)
            sum += 3;
        else if (tile1 == 7)
            sum += 2;
        else if (tile1 == 8)
            sum += 3;
        else if (tile1 == 9)
            sum += 4;
        
        if      (tile2 == 1)
            sum += 1;
        else if (tile2 == 3)
            sum += 1;
        else if (tile2 == 4)
            sum += 2;
        else if (tile2 == 5)
            sum += 1;
        else if (tile2 == 6)
            sum += 2;
        else if (tile2 == 7)
            sum += 3;
        else if (tile2 == 8)
            sum += 2;
        else if (tile2 == 9)
            sum += 3;
        
        if      (tile3 == 1)
            sum += 2;
        else if (tile3 == 2)
            sum += 1;
        else if (tile3 == 4)
            sum += 3;
        else if (tile3 == 5)
            sum += 2;
        else if (tile3 == 6)
            sum += 1;
        else if (tile3 == 7)
            sum += 4;
        else if (tile3 == 8)
            sum += 3;
        else if (tile3 == 9)
            sum += 2;
        
        if      (tile4 == 1)
            sum += 3;
        else if (tile4 == 2)
            sum += 2;
        else if (tile4 == 3)
            sum += 1;
        else if (tile4 == 4)
            sum += 2;
        else if (tile4 == 5)
            sum += 1;
        else if (tile4 == 7)
            sum += 3;
        else if (tile4 == 8)
            sum += 2;
        else if (tile4 == 9)
            sum += 1;
        
        if      (tile5 == 1)
            sum += 4;
        else if (tile5 == 2)
            sum += 3;
        else if (tile5 == 3)
            sum += 2;
        else if (tile5 == 4)
            sum += 3;
        else if (tile5 == 5)
            sum += 2;
        else if (tile5 == 6)
            sum += 1;
        else if (tile5 == 7)
            sum += 2;
        else if (tile5 == 8)
            sum += 1;
        
        if      (tile6 == 1)
            sum += 3;
        else if (tile6 == 2)
            sum += 2;
        else if (tile6 == 3)
            sum += 3;
        else if (tile6 == 4)
            sum += 2;
        else if (tile6 == 5)
            sum += 1;
        else if (tile6 == 6)
            sum += 2;
        else if (tile6 == 7)
            sum += 1;
        else if (tile6 == 9)
            sum += 1;
        
        if      (tile7 == 1)
            sum += 2;
        else if (tile7 == 2)
            sum += 3;
        else if (tile7 == 3)
            sum += 4;
        else if (tile7 == 4)
            sum += 1;
        else if (tile7 == 5)
            sum += 2;
        else if (tile7 == 6)
            sum += 3;
        else if (tile7 == 8)
            sum += 1;
        else if (tile7 == 9)
            sum += 2;
        
        if      (tile8 == 1)
            sum += 1;
        else if (tile8 == 2)
            sum += 2;
        else if (tile8 == 3)
            sum += 3;
        else if (tile8 == 5)
            sum += 1;
        else if (tile8 == 6)
            sum += 2;
        else if (tile8 == 7)
            sum += 1;
        else if (tile8 == 8)
            sum += 2;
        else if (tile8 == 9)
            sum += 3;
        
        System.out.println("sum: " + sum);
        
        return sum;
    }
}
