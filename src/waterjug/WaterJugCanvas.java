
package waterjug;

import framework.Canvas;
import framework.State;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Phil Javinsky III
 */
public class WaterJugCanvas extends Canvas
{
    private WaterJugState currState, prevState;
    private int xlvl, ylvl, currLvl, prevLvl;
    
    public WaterJugCanvas(WaterJugState state) {
        super(state);
        super.setCurrentState(state);
        
        xlvl = 0;
        ylvl = 0;
        prevLvl = 0;
        currLvl = 0;
        
        setPreferredSize(new Dimension(300,300));
    }
    
    public void paintComponent(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;
        
        currState = (WaterJugState) getCurrentState();
        prevState = (WaterJugState) getPreviousState();
        
        g.setColor(new Color(210,180,140));
        g.fillRoundRect(0, 0, 300, 300, 40, 40);
        
        g.setFont(new Font("Arial", Font.BOLD, 25));
        
        if (currState.getXJugLevel() == 0)
            xlvl = 0;
        if (currState.getYJugLevel() == 0)
            ylvl = 0;
        if (currState.getXJugLevel() == 1)
            xlvl = 1;
        if (currState.getYJugLevel() == 1)
            ylvl = 1;
        if (currState.getXJugLevel() == 2)
            xlvl = 2;
        if (currState.getYJugLevel() == 2)
            ylvl = 2;
        if (currState.getXJugLevel() == 3)
            xlvl = 3;
        if (currState.getYJugLevel() == 3)
            ylvl = 3;
        if (currState.getYJugLevel() == 4)
            ylvl = 4;
        
        //X and Y level labels
        g.setColor(Color.white);
        g.drawString("X: "+xlvl, 45, 280);
        g.drawString("Y: "+ylvl, 195, 280);
        
        
        //Water
        g.setColor(new Color(30,145,255));
        
        g.fillRect(20,250-(xlvl*50), 100,xlvl*50);
        g.fillRect(170,250-(ylvl*50), 100, ylvl*50);
        
        //Jug X water
        /*currLvl = currState.getXJugLevel();
        prevLvl = prevState.getXJugLevel();
        
        if (currLvl > prevLvl) { //Jug X water level is incresing
            while (prevLvl != currLvl) {
                int y = 250-(prevLvl*50);
                int height = prevLvl*50;
                g.fillRect(20,y-5, 100,height+5);
                repaint();
            }
        }
        else if (currLvl < prevLvl) { //Jug X water level is decreasing
            while (prevLvl != currLvl) {
                int y = 250-(prevLvl*50);
                int height = prevLvl*50;
                g.fillRect(20,y+5, 100,height-5);
                repaint();
            }
        }
        else
            g.fillRect(20,250-(currLvl*50), 100,currLvl*50);
        
        //Jug Y water
        currLvl = currState.getYJugLevel();
        prevLvl = prevState.getYJugLevel();
        
        if (currLvl > prevLvl) { //Jug Y water level is incresing
            while (prevLvl != currLvl) {
                int y = 250-(prevLvl*50);
                int height = prevLvl*50;
                g.fillRect(20,y-5, 100,height+5);
                repaint();
            }
        }
        else if (currLvl < prevLvl) { //Jug Y water level is decreasing
            while (prevLvl != currLvl) {
                int y = 250-(prevLvl*50);
                int height = prevLvl*50;
                g.fillRect(20,y+5, 100,height-5);
                repaint();
            }
        }
        else
            g.fillRect(170,250-(currLvl*50), 100, currLvl*50);
        */
        
        //Water jugs
        g.setColor(Color.black);
        g.setStroke(new BasicStroke(5));
        
        //Left water jug
        g.drawLine(20,98, 20,250);
        g.drawLine(20,250, 120,250);
        g.drawLine(120,98, 120,250);
        
        //Right water jug
        g.drawLine(170,48, 170,250);
        g.drawLine(170,250, 270,250);
        g.drawLine(270,48, 270,250);
       
    }
    
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("WaterJugCanvas Test");
        frame.setPreferredSize(new Dimension(300,300));
        frame.add(new WaterJugCanvas(new WaterJugState(3,4)));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
