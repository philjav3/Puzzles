
package blocks;

import framework.Canvas;
import java.awt.*;
import java.util.Stack;
import javax.swing.*;

/**
 *
 * @author PhilJav3
 */
public class BlockCanvas  extends Canvas{
    
    BlockState currState;
    Stack<Character> p,q,r;
    
    public BlockCanvas(BlockState state) {
        super(state);
        super.setCurrentState(state);
        
        setPreferredSize(new Dimension(300,300));
    }
    
    public void paintComponent(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;
        
        currState = (BlockState) getCurrentState();
        
        g.setColor(new Color(0,100,255));
        g.fillRect(0,0, 300,300);
        g.setColor(Color.white);
        g.setStroke(new BasicStroke(5));
        g.drawRect(0,0 , 300,300);
        
        g.drawLine(25,250, 275,250);
        
        g.setColor(Color.black);
        g.setFont(new Font("Arial", Font.BOLD, 35));
        g.drawString("p", 45,280);
        g.drawString("q", 135,280);
        g.drawString("r", 230,280);
        
        p = currState.getP();
        q = currState.getQ();
        r = currState.getR();
        
        g.setStroke(new BasicStroke(5));
        
        for (int i = 0; i < p.size(); i++) {
            g.setColor(new Color(255,100,100));
            g.fillRect(40,195-(i*50), 50,50);
            g.setColor(Color.black);
            g.drawRect(40,195-(i*50), 50,50);
            g.drawString(p.elementAt(i).toString(), 52,234-(i*50));
        }
        
        for (int i = 0; i < q.size(); i++) {
            g.setColor(new Color(255,100,100));
            g.fillRect(125,195-(i*50), 50,50);
            g.setColor(Color.black);
            g.drawRect(125,195-(i*50), 50,50);
            g.drawString(q.elementAt(i).toString(), 137,234-(i*50));
        }
        
        for (int i = 0; i < r.size(); i++) {
            g.setColor(new Color(255,100,100));
            g.fillRect(210,195-(i*50), 50,50);
            g.setColor(Color.black);
            g.drawRect(210,195-(i*50), 50,50);
            g.drawString(r.elementAt(i).toString(), 225,234-(i*50));
        }
        
        
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("PuzzleCanvas Test");
        frame.add(new BlockCanvas(new BlockState("AB","CD","EF")));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
    
}
