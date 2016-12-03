package puzzle;

import framework.Move;
import framework.State;

/**
 * This class represents moves in the 8-Puzzle problem.
 * A move object stores its move name and knows how to apply itself
 * to a bridge state to create a new state representing the result
 * of the move.
 * Note that this class extends the abstract class <b>Move</b> and
 * therefore imports <b>framework.Move</b>.
 * This class inherits the <b>getMoveName()</b> method from its parent
 * and thus it should not have an instance field for the move name.
 * @author Phil Javinsky III
 */
public class PuzzleMove extends Move
{
    private int openTile;

    public PuzzleMove(String moveName)
    {
        super(moveName);
    }
    
    /**
     * Attempts to perform this move on a given bridge state.
     * Note that this method implements the abstract <b>doMove</b> method declared
     * in the parent.
     * Thus the argument of type <b>State</b> must be cast to type
     * <b>PuzzleState</b> before processing.
     * The move to perform is determined by this object's move name.
     * If the move can be performed a new bridge state object is returned that
     * reflects this move.
     * A move cannot be performed if the flashlight is not on the same side
     * as the crossing person(s), or if a pair of persons who are crossing are not
     * on the same side.
     * If the move cannot be performed <b>null</b> is returned.
     * @param otherState the bridge state on which this move is to be performed
     * @return a new bridge state reflecting the move, or <b>null</b> if it
     * cannot be performed
     */
    public State doMove(State otherState) {
        PuzzleState state = (PuzzleState) otherState, newState = null;
        
        int tile1 = state.getTile1Pos();
        int tile2 = state.getTile2Pos();
        int tile3 = state.getTile3Pos();
        int tile4 = state.getTile4Pos();
        int tile5 = state.getTile5Pos();
        int tile6 = state.getTile6Pos();
        int tile7 = state.getTile7Pos();
        int tile8 = state.getTile8Pos();
        
        final int allTiles = 45;
        int tilesSum = tile1 + tile2 + tile3 + tile4 + tile5 + tile6 + tile7 + tile8;
        openTile = allTiles - tilesSum;
        
        if (getMoveName().equals("Slide Tile 1")) {
            if (canMove(tile1))
                newState = new PuzzleState (openTile, tile2, tile3,
                                    tile4, tile5, tile6, tile7, tile8);
        }
        else if (getMoveName().equals("Slide Tile 2")) {
            if (canMove(tile2))
                newState = new PuzzleState (tile1, openTile, tile3,
                                    tile4, tile5, tile6, tile7, tile8);
        }
        else if (getMoveName().equals("Slide Tile 3")) {
            if (canMove(tile3))
                newState = new PuzzleState (tile1, tile2, openTile,
                                    tile4, tile5, tile6, tile7, tile8);
        }
        else if (getMoveName().equals("Slide Tile 4")) {
            if (canMove(tile4))
                newState = new PuzzleState (tile1, tile2, tile3,
                                    openTile, tile5, tile6, tile7, tile8);
        }
        else if (getMoveName().equals("Slide Tile 5")) {
            if (canMove(tile5))
                newState = new PuzzleState (tile1, tile2, tile3,
                                    tile4, openTile, tile6, tile7, tile8);
        }
        else if (getMoveName().equals("Slide Tile 6")) {
            if (canMove(tile6))
                newState = new PuzzleState (tile1, tile2, tile3,
                                    tile4, tile5, openTile, tile7, tile8);
        }
        else if (getMoveName().equals("Slide Tile 7")) {
            if (canMove(tile7))
                newState = new PuzzleState (tile1, tile2, tile3,
                                    tile4, tile5, tile6, openTile, tile8);
        }
        else if (getMoveName().equals("Slide Tile 8")) {
            if (canMove(tile8))
                newState = new PuzzleState (tile1, tile2, tile3,
                                    tile4, tile5, tile6, tile7, openTile);
        }
        
        return newState;
    }
    
    /**
     * Checks to see if the selected tile can be moved.
     * @param tilePos
     * @return 
     */
    public boolean canMove(int tilePos) {
        boolean goodMove = false;
        
        if (tilePos != openTile) {
            if (tilePos == 1) {
                if (openTile == 2 || openTile == 4)
                    goodMove = true;
            }
            else if (tilePos == 2) {
                if (openTile == 1 || openTile == 3 || openTile == 5)
                    goodMove = true;
            }
            else if (tilePos == 3) {
                if (openTile == 2 || openTile == 6)
                    goodMove = true;
            }
            else if (tilePos == 4) {
                if (openTile == 1 || openTile == 5 || openTile == 7)
                    goodMove = true;
            }
            else if (tilePos == 5) {
                if (openTile % 2 == 0)
                    goodMove = true;
            }
            else if (tilePos == 6) {
                if (openTile == 3 || openTile == 5 || openTile == 9)
                    goodMove = true;
            }
            else if (tilePos == 7) {
                if (openTile == 4 || openTile == 8)
                    goodMove = true;
            }
            else if (tilePos == 8) {
                if (openTile == 5 || openTile == 7 || openTile == 9)
                    goodMove = true;
            }
            else if (tilePos == 9) {
                if (openTile == 6 || openTile == 8)
                    goodMove = true;
            }
        }
        
        return goodMove;
    }
}
