
package framework;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Phil Javinsky III
 */
public abstract class Canvas extends JComponent
{
    private State currState, prevState;
    
    public Canvas(State state) {
        this.currState = state;
        this.prevState = state;
    }
    
    public void setCurrentState(State newState) {
        currState = newState;
    }
    public State getCurrentState() {
        return currState;
    }
    
    public void setPreviousState(State state) {
        prevState = state;
    }
    public State getPreviousState() {
        return prevState;
    }
}
