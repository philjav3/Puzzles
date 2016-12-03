
package puzzle;

import framework.Canvas;
import java.awt.*;
import javax.swing.*;

/**
 * This class is responsible for the graphics of the 8-Puzzle problem.
 * @author Phil Javinsky III
 */
public class PuzzleCanvasIcon extends Canvas
{
    PuzzleState currState;
    private int x1,y1, x2,y2, x3,y3, x4,y4, x5,y5, x6,y6, x7,y7, x8,y8,
            sx1,sy1, sx2,sy2, sx3,sy3, sx4,sy4, sx5,sy5, sx6,sy6, sx7,sy7, sx8,sy8;
    
    public PuzzleCanvasIcon(PuzzleState state) {
        super(state);
        super.setCurrentState(state);
        
        setPreferredSize(new Dimension(120,120));
    }
    
    public void paintComponent(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;
        
        currState = (PuzzleState) getCurrentState();
        
        //Board outline and grid
        //g.setStroke(new BasicStroke(3));
        g.setColor(Color.black);
        g.drawRect(0,0, 120,120);
        g.drawLine(40,0, 40,120);
        g.drawLine(80,0, 80,120);
        g.drawLine(0,40, 120,40);
        g.drawLine(0,80, 120,80);
        
        if      (currState.getTile1Pos() == 1) { x1 =   3; y1 =   3; sx1 = 14; sy1 =  27; }
        else if (currState.getTile1Pos() == 2) { x1 =  43; y1 =   3; sx1 = 54; sy1 =  27; }
        else if (currState.getTile1Pos() == 3) { x1 =  83; y1 =   3; sx1 = 94; sy1 =  27; }
        else if (currState.getTile1Pos() == 4) { x1 =   3; y1 =  43; sx1 = 14; sy1 =  67; }    
        else if (currState.getTile1Pos() == 5) { x1 =  43; y1 =  43; sx1 = 54; sy1 =  67; }
        else if (currState.getTile1Pos() == 6) { x1 =  83; y1 =  43; sx1 = 94; sy1 =  67; }
        else if (currState.getTile1Pos() == 7) { x1 =   3; y1 =  83; sx1 = 14; sy1 = 107; }
        else if (currState.getTile1Pos() == 8) { x1 =  43; y1 =  83; sx1 = 54; sy1 = 107; }
        else if (currState.getTile1Pos() == 9) { x1 =  83; y1 =  83; sx1 = 94; sy1 = 107; }
        
        if      (currState.getTile2Pos() == 1) { x2 =   3; y2 =   3; sx2 = 14; sy2 =  27; }
        else if (currState.getTile2Pos() == 2) { x2 =  43; y2 =   3; sx2 = 54; sy2 =  27; }
        else if (currState.getTile2Pos() == 3) { x2 =  83; y2 =   3; sx2 = 94; sy2 =  27; }
        else if (currState.getTile2Pos() == 4) { x2 =   3; y2 =  43; sx2 = 14; sy2 =  67; }    
        else if (currState.getTile2Pos() == 5) { x2 =  43; y2 =  43; sx2 = 54; sy2 =  67; }
        else if (currState.getTile2Pos() == 6) { x2 =  83; y2 =  43; sx2 = 94; sy2 =  67; }
        else if (currState.getTile2Pos() == 7) { x2 =   3; y2 =  83; sx2 = 14; sy2 = 107; }
        else if (currState.getTile2Pos() == 8) { x2 =  43; y2 =  83; sx2 = 54; sy2 = 107; }
        else if (currState.getTile2Pos() == 9) { x2 =  83; y2 =  83; sx2 = 94; sy2 = 107; }
        
        if      (currState.getTile3Pos() == 1) { x3 =   3; y3 =   3; sx3 = 14; sy3 =  27; }
        else if (currState.getTile3Pos() == 2) { x3 =  43; y3 =   3; sx3 = 54; sy3 =  27; }
        else if (currState.getTile3Pos() == 3) { x3 =  83; y3 =   3; sx3 = 94; sy3 =  27; }
        else if (currState.getTile3Pos() == 4) { x3 =   3; y3 =  43; sx3 = 14; sy3 =  67; }    
        else if (currState.getTile3Pos() == 5) { x3 =  43; y3 =  43; sx3 = 54; sy3 =  67; }
        else if (currState.getTile3Pos() == 6) { x3 =  83; y3 =  43; sx3 = 94; sy3 =  67; }
        else if (currState.getTile3Pos() == 7) { x3 =   3; y3 =  83; sx3 = 14; sy3 = 107; }
        else if (currState.getTile3Pos() == 8) { x3 =  43; y3 =  83; sx3 = 54; sy3 = 107; }
        else if (currState.getTile3Pos() == 9) { x3 =  83; y3 =  83; sx3 = 94; sy3 = 107; }
        
        if      (currState.getTile4Pos() == 1) { x4 =   3; y4 =   3; sx4 = 14; sy4 =  27; }
        else if (currState.getTile4Pos() == 2) { x4 =  43; y4 =   3; sx4 = 54; sy4 =  27; }
        else if (currState.getTile4Pos() == 3) { x4 =  83; y4 =   3; sx4 = 94; sy4 =  27; }
        else if (currState.getTile4Pos() == 4) { x4 =   3; y4 =  43; sx4 = 14; sy4 =  67; }    
        else if (currState.getTile4Pos() == 5) { x4 =  43; y4 =  43; sx4 = 54; sy4 =  67; }
        else if (currState.getTile4Pos() == 6) { x4 =  83; y4 =  43; sx4 = 94; sy4 =  67; }
        else if (currState.getTile4Pos() == 7) { x4 =   3; y4 =  83; sx4 = 14; sy4 = 107; }
        else if (currState.getTile4Pos() == 8) { x4 =  43; y4 =  83; sx4 = 54; sy4 = 107; }
        else if (currState.getTile4Pos() == 9) { x4 =  83; y4 =  83; sx4 = 94; sy4 = 107; }
        
        if      (currState.getTile5Pos() == 1) { x5 =   3; y5 =   3; sx5 = 14; sy5 =  27; }
        else if (currState.getTile5Pos() == 2) { x5 =  43; y5 =   3; sx5 = 54; sy5 =  27; }
        else if (currState.getTile5Pos() == 3) { x5 =  83; y5 =   3; sx5 = 94; sy5 =  27; }
        else if (currState.getTile5Pos() == 4) { x5 =   3; y5 =  43; sx5 = 14; sy5 =  67; }    
        else if (currState.getTile5Pos() == 5) { x5 =  43; y5 =  43; sx5 = 54; sy5 =  67; }
        else if (currState.getTile5Pos() == 6) { x5 =  83; y5 =  43; sx5 = 94; sy5 =  67; }
        else if (currState.getTile5Pos() == 7) { x5 =   3; y5 =  83; sx5 = 14; sy5 = 107; }
        else if (currState.getTile5Pos() == 8) { x5 =  43; y5 =  83; sx5 = 54; sy5 = 107; }
        else if (currState.getTile5Pos() == 9) { x5 =  83; y5 =  83; sx5 = 94; sy5 = 107; }
        
        if      (currState.getTile6Pos() == 1) { x6 =   3; y6 =   3; sx6 = 14; sy6 =  27; }
        else if (currState.getTile6Pos() == 2) { x6 =  43; y6 =   3; sx6 = 54; sy6 =  27; }
        else if (currState.getTile6Pos() == 3) { x6 =  83; y6 =   3; sx6 = 94; sy6 =  27; }
        else if (currState.getTile6Pos() == 4) { x6 =   3; y6 =  43; sx6 = 14; sy6 =  67; }    
        else if (currState.getTile6Pos() == 5) { x6 =  43; y6 =  43; sx6 = 54; sy6 =  67; }
        else if (currState.getTile6Pos() == 6) { x6 =  83; y6 =  43; sx6 = 94; sy6 =  67; }
        else if (currState.getTile6Pos() == 7) { x6 =   3; y6 =  83; sx6 = 14; sy6 = 107; }
        else if (currState.getTile6Pos() == 8) { x6 =  43; y6 =  83; sx6 = 54; sy6 = 107; }
        else if (currState.getTile6Pos() == 9) { x6 =  83; y6 =  83; sx6 = 94; sy6 = 107; }
        
        if      (currState.getTile7Pos() == 1) { x7 =   3; y7 =   3; sx7 = 14; sy7 =  27; }
        else if (currState.getTile7Pos() == 2) { x7 =  43; y7 =   3; sx7 = 54; sy7 =  27; }
        else if (currState.getTile7Pos() == 3) { x7 =  83; y7 =   3; sx7 = 94; sy7 =  27; }
        else if (currState.getTile7Pos() == 4) { x7 =   3; y7 =  43; sx7 = 14; sy7 =  67; }    
        else if (currState.getTile7Pos() == 5) { x7 =  43; y7 =  43; sx7 = 54; sy7 =  67; }
        else if (currState.getTile7Pos() == 6) { x7 =  83; y7 =  43; sx7 = 94; sy7 =  67; }
        else if (currState.getTile7Pos() == 7) { x7 =   3; y7 =  83; sx7 = 14; sy7 = 107; }
        else if (currState.getTile7Pos() == 8) { x7 =  43; y7 =  83; sx7 = 54; sy7 = 107; }
        else if (currState.getTile7Pos() == 9) { x7 =  83; y7 =  83; sx7 = 94; sy7 = 107; }
        
        if      (currState.getTile8Pos() == 1) { x8 =   3; y8 =   3; sx8 = 14; sy8 =  27; }
        else if (currState.getTile8Pos() == 2) { x8 =  43; y8 =   3; sx8 = 54; sy8 =  27; }
        else if (currState.getTile8Pos() == 3) { x8 =  83; y8 =   3; sx8 = 94; sy8 =  27; }
        else if (currState.getTile8Pos() == 4) { x8 =   3; y8 =  43; sx8 = 14; sy8 =  67; }    
        else if (currState.getTile8Pos() == 5) { x8 =  43; y8 =  43; sx8 = 54; sy8 =  67; }
        else if (currState.getTile8Pos() == 6) { x8 =  83; y8 =  43; sx8 = 94; sy8 =  67; }
        else if (currState.getTile8Pos() == 7) { x8 =   3; y8 =  83; sx8 = 14; sy8 = 107; }
        else if (currState.getTile8Pos() == 8) { x8 =  43; y8 =  83; sx8 = 54; sy8 = 107; }
        else if (currState.getTile8Pos() == 9) { x8 =  83; y8 =  83; sx8 = 94; sy8 = 107; }
        
        //Filled part of tiles
        g.setColor(new Color(180,180,180));
        g.fillRect(x1,y1, 34,34); //1
        g.fillRect(x2,y2, 34,34); //2
        g.fillRect(x3,y3, 34,34); //3
        g.fillRect(x4,y4, 34,34); //4
        g.fillRect(x5,y5, 34,34); //5
        g.fillRect(x6,y6, 34,34); //6
        g.fillRect(x7,y7, 34,34); //7
        g.fillRect(x8,y8, 34,34); //8
        
        //Outline of tiles
        g.setColor(Color.black);
        g.setStroke(new BasicStroke(2));
        g.drawRect(x1,y1, 34,34); //1
        g.drawRect(x2,y2, 34,34); //2
        g.drawRect(x3,y3, 34,34); //3
        g.drawRect(x4,y4, 34,34); //4
        g.drawRect(x5,y5, 34,34); //5
        g.drawRect(x6,y6, 34,34); //6
        g.drawRect(x7,y7, 34,34); //7
        g.drawRect(x8,y8, 34,34); //8
        
        
        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.BOLD, 22));
        g.drawString("1", sx1,sy1);
        g.drawString("2", sx2,sy2);
        g.drawString("3", sx3,sy3);
        g.drawString("4", sx4,sy4);
        g.drawString("5", sx5,sy5);
        g.drawString("6", sx6,sy6);
        g.drawString("7", sx7,sy7);
        g.drawString("8", sx8,sy8);
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("PuzzleCanvasIcon Test");
        frame.add(new PuzzleCanvasIcon(new PuzzleState(1,2,3,4,5,6,7,8)));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

}