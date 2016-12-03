
package framework;

import graph.DequeAdder;
import graph.Vertex;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
import java.util.Stack;
import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 * A class that creates GUI components for solving search problems.
 * @author Phil Javinsky III
 */
public class GUI extends JComponent implements ActionListener {
    private JFrame frame;
    private JPanel introPanel, centerPanel, currStatePanel, finalStatePanel,
            movesPanel, moveButtonsPanel, solverPanel, statsPanel, southPanel;
    private Problem problem;
    private Canvas canvas, fCanvas;
    private List<Move> moves;
    private int moveCount;
    private JTextArea introLabel;
    private JLabel lengthLabel, dequeOpsLabel, dequeSizeLabel;
    private JButton resetButton, solveButton, nextMoveButton, allMovesButton;
    private Move option;
    private State startingState;
    private Stack stack;
    private Vertex finalState;
    
    public GUI(Problem problem, Canvas canvas, Canvas fCanvas) {
        setLayout(new BorderLayout());
        
        this.problem = problem;
        this.canvas = canvas;
        this.fCanvas = fCanvas;
        
        fCanvas.setCurrentState(problem.getFinalState());
        
        moves = problem.getMoves();
        moveCount = 0;
        startingState = problem.getCurrentState();
        int listSize = moves.size();
        stack = new Stack<Vertex>();
        
        
        introPanel = new JPanel();
            introLabel = new JTextArea(problem.getIntroduction());
                introLabel.setEditable(false);
                introLabel.setFont(new Font("Monospaced", Font.BOLD, 15));
            introPanel.add(introLabel);
            
        centerPanel = new JPanel();
            centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER,30,0));
                currStatePanel = new JPanel();
                    currStatePanel.setBorder(new TitledBorder("Current State"));
                    currStatePanel.add(canvas);
                movesPanel = new JPanel();
                    movesPanel.setLayout(new GridLayout(listSize+1,0,0,0));
                    movesPanel.setBorder(new TitledBorder("Possible Moves"));
                finalStatePanel = new JPanel();
                    finalStatePanel.setBorder(new TitledBorder("FinalState"));
                    finalStatePanel.add(fCanvas);
            centerPanel.add(currStatePanel);
            centerPanel.add(movesPanel);
            centerPanel.add(finalStatePanel);
        
        southPanel = new JPanel();
            southPanel.setBorder(new TitledBorder("SOLVER"));
                solverPanel = new JPanel();
                    //solverPanel.setLayout(new GridLayout(2,5,50,10));
                        solveButton = new JButton("SOLVE");
                            solveButton.setFont(new Font("", Font.BOLD, 20));
                            solveButton.addActionListener(this);
                        statsPanel = new JPanel();
                            statsPanel.setLayout(new GridLayout(3,0,0,5));
                            statsPanel.setBorder(new TitledBorder("Solution Statistics"));
                                lengthLabel = new JLabel("Solution Length:    ");
                                dequeOpsLabel = new JLabel("Number of DEQUE Operations:    ");
                                dequeSizeLabel = new JLabel("Maximum DEQUE Size:    ");
                            statsPanel.add(lengthLabel);
                            statsPanel.add(dequeOpsLabel);
                            statsPanel.add(dequeSizeLabel);
                        moveButtonsPanel = new JPanel();
                            moveButtonsPanel.setLayout(new GridLayout(2,0,5,5));
                                nextMoveButton = new JButton("SHOW NEXT MOVE");
                                    nextMoveButton.setEnabled(false);
                                    nextMoveButton.setFont(new Font("",Font.BOLD,15));
                                    nextMoveButton.addActionListener(this);
                                allMovesButton = new JButton("SHOW ALL MOVES");
                                    allMovesButton.setEnabled(false);
                                    allMovesButton.setFont(new Font("",Font.BOLD,15));
                                    allMovesButton.addActionListener(this);
                            moveButtonsPanel.add(nextMoveButton);
                            moveButtonsPanel.add(allMovesButton);
                    solverPanel.add(solveButton);
                    solverPanel.add(statsPanel);
                    solverPanel.add(moveButtonsPanel);
            //southPanel.add(solverPanel);
            
        
        resetButton = new JButton("Reset");
            resetButton.setForeground(Color.red);
            resetButton.addActionListener(this);
            
        
        add(introPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        //add(southPanel, BorderLayout.SOUTH);
        
        makeButtons();
    }
    
    /**
     * Getter for the number of moves the user has tried so far.
     * @return the move count
     */
    private int getMoveCount() { return moveCount; }
    
    /**
     * Setter for the number of moves the user has tried so far
     * @param moveCount the new move count
     */
    private void setMoveCount(int moveCount) { this.moveCount = moveCount; }
    
    /**
     * Getter for the problem object associated with this console.
     * @return this console's problem object
     */
    private Problem getProblem() { return problem; }
    
    /**
     * Makes a list of move option JButtons from the list of legal moves.
     */
    private void makeButtons() {
        for (Move move : moves) {
            final JButton button = new JButton(move.getMoveName());
            button.setMaximumSize(new Dimension(150,25));
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    String buttonName = button.getText();
                    
                    for (Move move : moves) {
                        if (buttonName == move.getMoveName()) {
                            Move choice = move;
                            setOption(choice);
                            break;
                        }
                    }
                    processMoves();
                }
            });
            movesPanel.add(button);
        }
        movesPanel.add(resetButton);
    }
    
    /**
     * Gets and processes moves from the user.  First displays the current
     * state and checks for success.  If success, congratulations are given
     * along with the number of moves used and the program exits.
     * Otherwise the available options are displayed and prompted for.
     * Bad input causes a message and re-prompt.  Input of zero causes a
     * message of number of moves attempted and the program exits.
     * Valid input causes the move to be attempted.  If the result is
     * <b>null</b>, the move could not be performed so a message is given
     * and the user is re-prompted.  Otherwise the result is installed as
     * the new problem current state and <b>getMove</b> is repeated.
     */
    private void processMoves() {
        if (option == null) {
            JOptionPane.showMessageDialog(frame, "option is null");
            System.exit(0);
        }
        
        State newState = option.doMove(problem.getCurrentState());
        if (newState == null) {
            JOptionPane.showMessageDialog(frame, "That move is not possible.  Try again.");
        }
        else {
            //canvas.setPreviousState(problem.getCurrentState());
            problem.setCurrentState(newState);
            canvas.setCurrentState(newState);
            moveCount++;
            repaint();
        }
        
        if (problem.success()) {
            JOptionPane.showMessageDialog(frame, "Congratulations. You solved the problem using " +
                    moveCount + " moves.");
        }
    }
    
    /**
     * Sets the button's name to the move's moveName.
     * @param move a new Move that has the option selected.
     */
    private void setOption(Move choice) { option = choice; }

    /**
     * Displays the solution to the console by recursing to the start state
     * and then individually displaying states as the recursion is unwound.
     * @param state the terminating state in the solution path
     */
    private void displaySolution(Vertex state) {
        if (state != null) {
            displaySolution(state.getPredecessor());
            canvas.setCurrentState((State)state);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent event)
    {
        if (event.getSource() == resetButton) {
            State newStartState = startingState;
            //canvas.setPreviousState(problem.getCurrentState());
            
            lengthLabel.setText("Solution Length:    ");
            dequeOpsLabel.setText("Number of DEQUE Operations:    ");
            dequeSizeLabel.setText("Maximum DEQUE Size:    ");
            
            solveButton.setEnabled(true);
            nextMoveButton.setEnabled(false);
            allMovesButton.setEnabled(false);
            stack.clear();
            
            if (problem.useChooser()) {
                ProblemChooser chooser = new ProblemChooser(problem.getInitialStates(),
                    problem.getFinalStates(), problem.getMoveCounts(),
                    problem.getInitialCanvases(), problem.getFinalCanvases());
                newStartState = chooser.getStart();
                fCanvas.setCurrentState(chooser.getFinal());
            }
            
            problem.setCurrentState(newStartState);
            setMoveCount(0);
            canvas.setCurrentState(problem.getCurrentState());
            
            repaint();
        }
        
        if (event.getSource() == solveButton) {
            solveButton.setEnabled(false);
            nextMoveButton.setEnabled(true);
            allMovesButton.setEnabled(true);
            
            
            
            finalState = problem.search((Vertex)problem.getCurrentState());
            lengthLabel.setText("Solution Length: " + getMoveCount() + "   ");
            dequeOpsLabel.setText("Number of DEQUE Operations: " + problem.getQueueOps() + "   ");
            dequeSizeLabel.setText("Maximum DEQUE Size: " + problem.getMaxQueueSize() + "   ");

            stack.push(finalState);
            Vertex predecessor = finalState.getPredecessor();

            while (predecessor != null) {
                stack.push(predecessor);
                predecessor = predecessor.getPredecessor();
            }
            
        }
        
        if (event.getSource() == nextMoveButton) {
            canvas.setCurrentState((State)stack.pop());
            repaint();
        }
        
        if (event.getSource() == allMovesButton) {
            while (!stack.empty()) {
                canvas.setCurrentState((State)stack.pop());
                repaint();
            }
        }
        
    }
}
