package waterjug;

import framework.State;
import graph.SimpleVertex;

/**
 * This class represents states of the Water Jug problem.
 * It creates new water jug states, tests states for equality,
 * and produces string representations of them.
 * Note that this class implements the <b>State</b> interface
 * and therefore imports <b>framework.State</b>.
 */
public class WaterJugState extends SimpleVertex implements State {

    // You must provide a constructor
    public WaterJugState(int jugXLevel, int jugYLevel) {
        xLvl = jugXLevel;
        yLvl = jugYLevel;
        if (xLvl > 3)
            xLvl = 3;
        if (yLvl > 4)
            yLvl = 4;
        xPlusY = xLvl+yLvl;
    }

    /**
       Tests for equality between this state and the argument state.
       Two states are equal if the X jugs have the same amount of water
       and the Y jugs have the same amount of water.
       @param other the state to test against this state
       @return whether the states are equal
    */
    public boolean equals(Object other) {
        WaterJugState state = (WaterJugState) other;
        boolean equal = false;
        
        if (xLvl == yLvl)
            equal = true;
        
	return equal;
    }

    /**
       Creates a primitive, non-GUI representation of this WaterJugState object.
       @return the string representation of this water jug state
     */
    public String toString() {
        String jugs = ""; 
              
        if (xLvl == 0 && yLvl == 0) {
               jugs = "       |   |\n"
                    + "|   |  |   |\n"
                    + "|   |  |   |\n"
                    + "|   |  |   |\n"
                    + "+---+  +---+\n"
                    + "  X      Y  \n";
        }
        else if (xLvl == 1 && yLvl == 0) {
               jugs = "       |   |\n"
                    + "|   |  |   |\n"
                    + "|   |  |   |\n"
                    + "|***|  |   |\n"
                    + "+---+  +---+\n"
                    + "  X      Y  \n";
        }
        else if (xLvl == 2 && yLvl == 0) {
               jugs = "       |   |\n"
                    + "|   |  |   |\n"
                    + "|***|  |   |\n"
                    + "|***|  |   |\n"
                    + "+---+  +---+\n"
                    + "  X      Y  \n";
        }
        else if (xLvl >= 3 && yLvl == 0) {
               jugs = "       |   |\n"
                    + "|***|  |   |\n"
                    + "|***|  |   |\n"
                    + "|***|  |   |\n"
                    + "+---+  +---+\n"
                    + "  X      Y  \n";
        }
        else if (xLvl == 0 && yLvl == 1) {
               jugs = "       |   |\n"
                    + "|   |  |   |\n"
                    + "|   |  |   |\n"
                    + "|   |  |***|\n"
                    + "+---+  +---+\n"
                    + "  X      Y  \n";
        }   
        else if (xLvl == 0 && yLvl == 2) {
               jugs = "       |   |\n"
                    + "|   |  |   |\n"
                    + "|   |  |***|\n"
                    + "|   |  |***|\n"
                    + "+---+  +---+\n"
                    + "  X      Y  \n";
        }
        else if (xLvl == 0 && yLvl == 3) {
               jugs = "       |   |\n"
                    + "|   |  |***|\n"
                    + "|   |  |***|\n"
                    + "|   |  |***|\n"
                    + "+---+  +---+\n"
                    + "  X      Y  \n";
        }
        else if (xLvl == 0 && yLvl >= 4) {
               jugs = "       |***|\n"
                    + "|   |  |***|\n"
                    + "|   |  |***|\n"
                    + "|   |  |***|\n"
                    + "+---+  +---+\n"
                    + "  X      Y  \n";
        }
        else if (xLvl == 1 && yLvl == 1) {
               jugs = "       |   |\n"
                    + "|   |  |   |\n"
                    + "|   |  |   |\n"
                    + "|***|  |***|\n"
                    + "+---+  +---+\n"
                    + "  X      Y  \n";
        }
        else if (xLvl == 1 && yLvl == 2) {
               jugs = "       |   |\n"
                    + "|   |  |   |\n"
                    + "|   |  |***|\n"
                    + "|***|  |***|\n"
                    + "+---+  +---+\n"
                    + "  X      Y  \n";
        }
        else if (xLvl == 1 && yLvl == 3) {
               jugs = "       |   |\n"
                    + "|   |  |***|\n"
                    + "|   |  |***|\n"
                    + "|***|  |***|\n"
                    + "+---+  +---+\n"
                    + "  X      Y  \n";
        }
        else if (xLvl == 1 && yLvl >= 4) {
               jugs = "       |***|\n"
                    + "|   |  |***|\n"
                    + "|   |  |***|\n"
                    + "|***|  |***|\n"
                    + "+---+  +---+\n"
                    + "  X      Y  \n";
        }
        else if (xLvl == 2 && yLvl == 1) {
               jugs = "       |   |\n"
                    + "|   |  |   |\n"
                    + "|***|  |   |\n"
                    + "|***|  |***|\n"
                    + "+---+  +---+\n"
                    + "  X      Y  \n";
        }
        else if (xLvl == 2 && yLvl == 2) {
               jugs = "       |   |\n"
                    + "|   |  |   |\n"
                    + "|***|  |***|\n"
                    + "|***|  |***|\n"
                    + "+---+  +---+\n"
                    + "  X      Y  \n";
        }
        else if (xLvl == 2 && yLvl == 3) {
               jugs = "       |   |\n"
                    + "|   |  |***|\n"
                    + "|***|  |***|\n"
                    + "|***|  |***|\n"
                    + "+---+  +---+\n"
                    + "  X      Y  \n";
        }
        else if (xLvl == 2 && yLvl >= 4) {
               jugs = "       |***|\n"
                    + "|   |  |***|\n"
                    + "|***|  |***|\n"
                    + "|***|  |***|\n"
                    + "+---+  +---+\n"
                    + "  X      Y  \n";
        }
        else if (xLvl >= 3 && yLvl == 1) {
               jugs = "       |   |\n"
                    + "|***|  |   |\n"
                    + "|***|  |   |\n"
                    + "|***|  |***|\n"
                    + "+---+  +---+\n"
                    + "  X      Y  \n";
        }
        else if (xLvl >= 3 && yLvl == 2) {
               jugs = "       |   |\n"
                    + "|***|  |   |\n"
                    + "|***|  |***|\n"
                    + "|***|  |***|\n"
                    + "+---+  +---+\n"
                    + "  X      Y  \n";
        }
        else if (xLvl >= 3 && yLvl == 3) {
               jugs = "       |   |\n"
                    + "|***|  |***|\n"
                    + "|***|  |***|\n"
                    + "|***|  |***|\n"
                    + "+---+  +---+\n"
                    + "  X      Y  \n";
        }
        else if (xLvl >= 3 && yLvl >= 4) {
               jugs = "       |***|\n"
                    + "|***|  |***|\n"
                    + "|***|  |***|\n"
                    + "|***|  |***|\n"
                    + "+---+  +---+\n"
                    + "  X      Y  \n";
        }
        //System.out.println("x value: "+xLvl+", y value: "+yLvl);
	return jugs;
    }
    
    // Private methods and instance fields should go here
    private int xLvl, yLvl, xPlusY;
    
    public int getXJugLevel() {
        return xLvl;
    }
    public int getYJugLevel() {
        return yLvl;
    }
    public int getXPlusY() {
        return xPlusY;
    }

    @Override
    public int getHeuristic(State goal) {
        return 0;
    }
}
