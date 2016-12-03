
package blocks;

import framework.Canvas;
import java.awt.*;
import java.util.Stack;
import javax.swing.*;

/**
 *
 * @author PhilJav3
 */
public class BlockCanvasIcon  extends Canvas{
    
    BlockState currState;
    Stack<Character> p,q,r;
    
    public BlockCanvasIcon(BlockState state) {
        super(state);
        super.setCurrentState(state);
        
        setPreferredSize(new Dimension(120,120));
    }
    
    public void paintComponent(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;
        
        currState = (BlockState) getCurrentState();
        
        g.setColor(new Color(0,100,255));
        g.fillRect(0,0, 120,120);
        g.setColor(Color.white);
        g.setStroke(new BasicStroke(3));
        g.drawRect(0,0, 120,120);
        
        g.drawLine(10,95, 110,95);
        
        g.setColor(Color.black);
        g.setFont(new Font("Arial", Font.BOLD, 17));
        g.drawString("p", 20,110);
        g.drawString("q", 53,110);
        g.drawString("r", 90,110);
        
        p = currState.getP();
        q = currState.getQ();
        r = currState.getR();
        
        for (int i = 0; i < p.size(); i++) {
            g.setColor(new Color(255,100,100));
            g.fillRect(14,72-(i*20), 20,20);
            g.setColor(Color.black);
            g.drawRect(14,72-(i*20), 20,20);
            g.drawString(p.elementAt(i).toString(), 19,88-(i*20));
        }
        
        for (int i = 0; i < q.size(); i++) {
            g.setColor(new Color(255,100,100));
            g.fillRect(49,72-(i*20), 20,20);
            g.setColor(Color.black);
            g.drawRect(49,72-(i*20), 20,20);
            g.drawString(q.elementAt(i).toString(), 54,88-(i*20));
        }
        
        for (int i = 0; i < r.size(); i++) {
            g.setColor(new Color(255,100,100));
            g.fillRect(85,72-(i*20), 20,20);
            g.setColor(Color.black);
            g.drawRect(85,72-(i*20), 20,20);
            g.drawString(r.elementAt(i).toString(), 90,88-(i*20));
        }
        
        
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("PuzzleCanvas Test");
        frame.add(new BlockCanvasIcon(new BlockState("AB","CD","EF")));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
    
}
