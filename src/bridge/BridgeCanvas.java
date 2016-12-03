
package bridge;

import framework.Canvas;
import framework.State;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

/**
 *
 * @author Phil Javinsky III
 */
public class BridgeCanvas extends Canvas
{   
    private BridgeState currState;
    
    public BridgeCanvas(BridgeState state) {
        super(state);
        super.setCurrentState(state);
        
        setPreferredSize(new Dimension(300,300));
    }
    
    public void paintComponent(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;
        
        currState = (BridgeState) getCurrentState();
        
        GeneralPath river = new GeneralPath();
        river.moveTo(110,0);
        river.quadTo(75,50, 110,150);
        river.quadTo(75,250, 110,299);
        river.lineTo(110,299);
        river.lineTo(190,299);
        river.quadTo(155,250, 190,150);
        river.quadTo(155,50, 190,0);
        river.lineTo(110,0);
        river.closePath();
        
        //Background
        g.setColor(new Color(34, 139, 34));
        g.fillRoundRect(0, 0, 300, 300, 40, 40);
        
        //River
        g.setColor(Color.blue);
        g.fill(river);
        g.draw(river);
        
        //Bridge
        g.setColor(new Color(139,69,16));
        g.fillRect(80, 120, 120, 60);
        
        //Time
        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.PLAIN, 25));
        g.drawString(" " + currState.getTimeSoFar() + " min", 100,160);
        
        g.setColor(Color.black);
        g.setFont(new Font("Arial", Font.BOLD, 35));
        if (currState.getP1Position() == Position.WEST)
            g.drawString("P1", 20,50);
        else
            g.drawString("P1", 220,50);
        
        if (currState.getP2Position() == Position.WEST)
            g.drawString("P2", 20,100);
        else
            g.drawString("P2", 220,100);
        
        if (currState.getFlashlightPosition() == Position.WEST)
            g.drawString("f", 30,160);
        else
            g.drawString("f", 230,160);
        
        if (currState.getP5Position() == Position.WEST)
            g.drawString("P5", 20,225);
        else
            g.drawString("P5", 220,225);
        
        if (currState.getP10Position() == Position.WEST)
            g.drawString("P10", 12,275);
        else
            g.drawString("P10", 212,275);
        
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("BridgeCanvas Test");
        frame.add(new BridgeCanvas(new BridgeState(Position.EAST,
                                                   Position.EAST,
                                                   Position.EAST,
                                                   Position.EAST,
                                                   Position.EAST,
                                                   0)));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        
    }
}
