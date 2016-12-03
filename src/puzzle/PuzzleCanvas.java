
package puzzle;

import framework.Canvas;
import java.awt.*;
import javax.swing.*;

/**
 * This class is responsible for the graphics of the 8-Puzzle problem.
 * @author Phil Javinsky III
 */
public class PuzzleCanvas extends Canvas
{
    PuzzleState currState;
    private int x1,y1, x2,y2, x3,y3, x4,y4, x5,y5, x6,y6, x7,y7, x8,y8,
            sx1,sy1, sx2,sy2, sx3,sy3, sx4,sy4, sx5,sy5, sx6,sy6, sx7,sy7, sx8,sy8;
    
    public PuzzleCanvas(PuzzleState state) {
        super(state);
        super.setCurrentState(state);
        
        setPreferredSize(new Dimension(300,300));
    }
    
    public void paintComponent(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;
        
        currState = (PuzzleState) getCurrentState();
        
        //Board outline and grid
        //g.setStroke(new BasicStroke(3));
        g.setColor(Color.black);
        g.drawRect(0,0, 300,300);
        g.drawLine(100,0, 100,300);
        g.drawLine(200,0, 200,300);
        g.drawLine(0,100, 300,100);
        g.drawLine(0,200, 300,200);
        
        if (currState.getTile1Pos() == 1)      { x1 = 005; y1 = 005; sx1 = 30; sy1 = 75; }
        else if (currState.getTile1Pos() == 2) { x1 = 105; y1 = 005; sx1 = 130; sy1 = 75; }
        else if (currState.getTile1Pos() == 3) { x1 = 205; y1 = 005; sx1 = 230; sy1 = 75; }
        else if (currState.getTile1Pos() == 4) { x1 = 005; y1 = 105; sx1 = 30; sy1 = 175; }    
        else if (currState.getTile1Pos() == 5) { x1 = 105; y1 = 105; sx1 = 130; sy1 = 175; }
        else if (currState.getTile1Pos() == 6) { x1 = 205; y1 = 105; sx1 = 230; sy1 = 175; }
        else if (currState.getTile1Pos() == 7) { x1 = 005; y1 = 205; sx1 = 30; sy1 = 275; }
        else if (currState.getTile1Pos() == 8) { x1 = 105; y1 = 205; sx1 = 130; sy1 = 275; }
        else if (currState.getTile1Pos() == 9) { x1 = 205; y1 = 205; sx1 = 230; sy1 = 275; }
        
        if (currState.getTile2Pos() == 1)      { x2 = 005; y2 = 005; sx2 = 30; sy2 = 75; }
        else if (currState.getTile2Pos() == 2) { x2 = 105; y2 = 005; sx2 = 130; sy2 = 75; }
        else if (currState.getTile2Pos() == 3) { x2 = 205; y2 = 005; sx2 = 230; sy2 = 75; }
        else if (currState.getTile2Pos() == 4) { x2 = 005; y2 = 105; sx2 = 30; sy2 = 175; }    
        else if (currState.getTile2Pos() == 5) { x2 = 105; y2 = 105; sx2 = 130; sy2 = 175; }
        else if (currState.getTile2Pos() == 6) { x2 = 205; y2 = 105; sx2 = 230; sy2 = 175; }
        else if (currState.getTile2Pos() == 7) { x2 = 005; y2 = 205; sx2 = 30; sy2 = 275; }
        else if (currState.getTile2Pos() == 8) { x2 = 105; y2 = 205; sx2 = 130; sy2 = 275; }
        else if (currState.getTile2Pos() == 9) { x2 = 205; y2 = 205; sx2 = 230; sy2 = 275; }
        
        if (currState.getTile3Pos() == 1)      { x3 = 005; y3 = 005; sx3 = 30; sy3 = 75; }
        else if (currState.getTile3Pos() == 2) { x3 = 105; y3 = 005; sx3 = 130; sy3 = 75; }
        else if (currState.getTile3Pos() == 3) { x3 = 205; y3 = 005; sx3 = 230; sy3 = 75; }
        else if (currState.getTile3Pos() == 4) { x3 = 005; y3 = 105; sx3 = 30; sy3 = 175; }    
        else if (currState.getTile3Pos() == 5) { x3 = 105; y3 = 105; sx3 = 130; sy3 = 175; }
        else if (currState.getTile3Pos() == 6) { x3 = 205; y3 = 105; sx3 = 230; sy3 = 175; }
        else if (currState.getTile3Pos() == 7) { x3 = 005; y3 = 205; sx3 = 30; sy3 = 275; }
        else if (currState.getTile3Pos() == 8) { x3 = 105; y3 = 205; sx3 = 130; sy3 = 275; }
        else if (currState.getTile3Pos() == 9) { x3 = 205; y3 = 205; sx3 = 230; sy3 = 275; }
        
        if (currState.getTile4Pos() == 1)      { x4 = 005; y4 = 005; sx4 = 30; sy4 = 75; }
        else if (currState.getTile4Pos() == 2) { x4 = 105; y4 = 005; sx4 = 130; sy4 = 75; }
        else if (currState.getTile4Pos() == 3) { x4 = 205; y4 = 005; sx4 = 230; sy4 = 75; }
        else if (currState.getTile4Pos() == 4) { x4 = 005; y4 = 105; sx4 = 30; sy4 = 175; }    
        else if (currState.getTile4Pos() == 5) { x4 = 105; y4 = 105; sx4 = 130; sy4 = 175; }
        else if (currState.getTile4Pos() == 6) { x4 = 205; y4 = 105; sx4 = 230; sy4 = 175; }
        else if (currState.getTile4Pos() == 7) { x4 = 005; y4 = 205; sx4 = 30; sy4 = 275; }
        else if (currState.getTile4Pos() == 8) { x4 = 105; y4 = 205; sx4 = 130; sy4 = 275; }
        else if (currState.getTile4Pos() == 9) { x4 = 205; y4 = 205; sx4 = 230; sy4 = 275; }
        
        if (currState.getTile5Pos() == 1)      { x5 = 005; y5 = 005; sx5 = 30; sy5 = 75; }
        else if (currState.getTile5Pos() == 2) { x5 = 105; y5 = 005; sx5 = 130; sy5 = 75; }
        else if (currState.getTile5Pos() == 3) { x5 = 205; y5 = 005; sx5 = 230; sy5 = 75; }
        else if (currState.getTile5Pos() == 4) { x5 = 005; y5 = 105; sx5 = 30; sy5 = 175; }    
        else if (currState.getTile5Pos() == 5) { x5 = 105; y5 = 105; sx5 = 130; sy5 = 175; }
        else if (currState.getTile5Pos() == 6) { x5 = 205; y5 = 105; sx5 = 230; sy5 = 175; }
        else if (currState.getTile5Pos() == 7) { x5 = 005; y5 = 205; sx5 = 30; sy5 = 275; }
        else if (currState.getTile5Pos() == 8) { x5 = 105; y5 = 205; sx5 = 130; sy5 = 275; }
        else if (currState.getTile5Pos() == 9) { x5 = 205; y5 = 205; sx5 = 230; sy5 = 275; }
        
        if (currState.getTile6Pos() == 1)      { x6 = 005; y6 = 005; sx6 = 30; sy6 = 75; }
        else if (currState.getTile6Pos() == 2) { x6 = 105; y6 = 005; sx6 = 130; sy6 = 75; }
        else if (currState.getTile6Pos() == 3) { x6 = 205; y6 = 005; sx6 = 230; sy6 = 75; }
        else if (currState.getTile6Pos() == 4) { x6 = 005; y6 = 105; sx6 = 30; sy6 = 175; }    
        else if (currState.getTile6Pos() == 5) { x6 = 105; y6 = 105; sx6 = 130; sy6 = 175; }
        else if (currState.getTile6Pos() == 6) { x6 = 205; y6 = 105; sx6 = 230; sy6 = 175; }
        else if (currState.getTile6Pos() == 7) { x6 = 005; y6 = 205; sx6 = 30; sy6 = 275; }
        else if (currState.getTile6Pos() == 8) { x6 = 105; y6 = 205; sx6 = 130; sy6 = 275; }
        else if (currState.getTile6Pos() == 9) { x6 = 205; y6 = 205; sx6 = 230; sy6 = 275; }
        
        if (currState.getTile7Pos() == 1)      { x7 = 005; y7 = 005; sx7 = 30; sy7 = 75; }
        else if (currState.getTile7Pos() == 2) { x7 = 105; y7 = 005; sx7 = 130; sy7 = 75; }
        else if (currState.getTile7Pos() == 3) { x7 = 205; y7 = 005; sx7 = 230; sy7 = 75; }
        else if (currState.getTile7Pos() == 4) { x7 = 005; y7 = 105; sx7 = 30; sy7 = 175; }    
        else if (currState.getTile7Pos() == 5) { x7 = 105; y7 = 105; sx7 = 130; sy7 = 175; }
        else if (currState.getTile7Pos() == 6) { x7 = 205; y7 = 105; sx7 = 230; sy7 = 175; }
        else if (currState.getTile7Pos() == 7) { x7 = 005; y7 = 205; sx7 = 30; sy7 = 275; }
        else if (currState.getTile7Pos() == 8) { x7 = 105; y7 = 205; sx7 = 130; sy7 = 275; }
        else if (currState.getTile7Pos() == 9) { x7 = 205; y7 = 205; sx7 = 230; sy7 = 275; }
        
        if (currState.getTile8Pos() == 1)      { x8 = 005; y8 = 005; sx8 = 30; sy8 = 75; }
        else if (currState.getTile8Pos() == 2) { x8 = 105; y8 = 005; sx8 = 130; sy8 = 75; }
        else if (currState.getTile8Pos() == 3) { x8 = 205; y8 = 005; sx8 = 230; sy8 = 75; }
        else if (currState.getTile8Pos() == 4) { x8 = 005; y8 = 105; sx8 = 30; sy8 = 175; }    
        else if (currState.getTile8Pos() == 5) { x8 = 105; y8 = 105; sx8 = 130; sy8 = 175; }
        else if (currState.getTile8Pos() == 6) { x8 = 205; y8 = 105; sx8 = 230; sy8 = 175; }
        else if (currState.getTile8Pos() == 7) { x8 = 005; y8 = 205; sx8 = 30; sy8 = 275; }
        else if (currState.getTile8Pos() == 8) { x8 = 105; y8 = 205; sx8 = 130; sy8 = 275; }
        else if (currState.getTile8Pos() == 9) { x8 = 205; y8 = 205; sx8 = 230; sy8 = 275; }
        
        
        //Filled part of tiles
        g.setColor(new Color(180,180,180));
        g.fillRect(x1,y1, 90,90); //1
        g.fillRect(x2,y2, 90,90); //2
        g.fillRect(x3,y3, 90,90); //3
        g.fillRect(x4,y4, 90,90); //4
        g.fillRect(x5,y5, 90,90); //5
        g.fillRect(x6,y6, 90,90); //6
        g.fillRect(x7,y7, 90,90); //7
        g.fillRect(x8,y8, 90,90); //8
        
        //Outline of tiles
        g.setColor(Color.black);
        g.setStroke(new BasicStroke(3));
        g.drawRect(x1,y1, 90,90); //1
        g.drawRect(x2,y2, 90,90); //2
        g.drawRect(x3,y3, 90,90); //3
        g.drawRect(x4,y4, 90,90); //4
        g.drawRect(x5,y5, 90,90); //5
        g.drawRect(x6,y6, 90,90); //6
        g.drawRect(x7,y7, 90,90); //7
        g.drawRect(x8,y8, 90,90); //8
        
        
        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.BOLD, 75));
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
        JFrame frame = new JFrame("PuzzleCanvas Test");
        frame.add(new PuzzleCanvas(new PuzzleState(1,2,3,4,5,6,7,8)));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

}