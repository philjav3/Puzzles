
package framework.test;

import blocks.*;
import bridge.*;
import framework.*;
import javax.swing.JFrame;
import puzzle.*;
import waterjug.*;

/**
 * A class to display the bridge crossing and water jug problems in a tabbed pane
 * within an application frame.
 * @author tcolburn
 */
public class TestFrame extends JFrame {
    
    public TestFrame() {
        super("Bridge Problem | Water Jug Problem | 8-Puzzle Problem | Blocks Problem");
        ProblemPane problemPane = new ProblemPane();
        
        problemPane.add("Bridge", new GUI(new BridgeProblem(),
                new BridgeCanvas(new BridgeState(Position.WEST,
                                                 Position.WEST,
                                                 Position.WEST,
                                                 Position.WEST,
                                                 Position.WEST, 0)), 
                        new BridgeCanvas(new BridgeState(Position.EAST,
                                                         Position.EAST,
                                                         Position.EAST,
                                                         Position.EAST,
                                                         Position.EAST, 17))));
        
        problemPane.add("Water Jug", new GUI(new WaterJugProblem(), new WaterJugCanvas(new WaterJugState(0,0)),
                new WaterJugCanvas(new WaterJugState(2,4))));
        
        problemPane.add("8-Puzzle", new GUI(new PuzzleProblem(), new PuzzleCanvas(new PuzzleState(4,1,3,6,9,5,7,2)),
                new PuzzleCanvas(new PuzzleState(4,1,3,6,9,5,7,2))));
        
        problemPane.add("Blocks", new GUI(new BlockProblem(), new BlockCanvas(new BlockState("AB","","")),
                new BlockCanvas(new BlockState("","AB",""))));
        
        add(problemPane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new TestFrame();
    }
    
}
