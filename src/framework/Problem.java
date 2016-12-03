package framework;

import graph.*;
import static java.lang.Math.max;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * This abstract class represents a problem in a problem solving domain.
 * Note that this class does not provide a constructor.
 * It provides getters and setters for the current state
 * of the problem, the list of moves for the problem, and the problem's
 * introduction string.
 * Extending classes need not have instance fields for these attributes, 
 * as they are inherited from this class.
 * Extending classes must set these values in their constructors using 
 * the setters (mutators) provided in this class.
 * Extending classes must also override the abstract <b>success</b> method.
 */
public abstract class Problem {

    /**
     * Determines whether the current state of this problem is a success.
     * Extending classes need to override this method.
     * @return whether the current state is a success
     */
    public abstract boolean success();

    /**
     * Gets the current state of the problem.
     * @return the current state
     */
    public State getCurrentState() {
        return currentState;
    }

    /**
     * Sets the current state of the problem.
     * @param currentState the current state
     */
    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }
    
    /**
     * Gets the current state of the problem.
     * @return the current state
     */
    public State getFinalState() {
        return finalState;
    }

    /**
     * Sets the current state of the problem.
     * @param finalState
     */
    public void setFinalState(State finalState) {
        this.finalState = finalState;
    }

    /**
     * Gets an explanatory introduction string for the problem.
     * @return the introduction string
     */
    public String getIntroduction() {
        return introduction;
    }

    /**
     * Sets the introduction string for this problem.
     * @param introduction the introduction string
     */
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    /**
     * Gets the list of moves for this problem.
     * @return the list of moves
     */
    public List<Move> getMoves() {
        return moves;
    }

    /**
     * Sets the list of moves for this problem.
     * @param moves the list of moves
     */
    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }
    
    public void setInitialCanvases(List<Canvas> initialCanvases) {
        this.initialCanvases = initialCanvases;
    }
    public List<Canvas> getInitialCanvases() {
        return initialCanvases;
    }
    
    public void setFinalCanvases(List<Canvas> finalCanvases) {
        this.finalCanvases = finalCanvases;
    }
    public List<Canvas> getFinalCanvases() {
        return finalCanvases;
    }
    
    
    /**
     * Checks to see if a vertex appears on the predecessor path
     * of an ancestor vertex.
     * @param v the vertex to check
     * @param ancestor the ancestor of v
     * @return true if v equals ancestor or any ancestor of ancestor
     */
    public boolean occursOnPath(Vertex v, Vertex ancestor) {
        boolean onPath = false;
        
        while (ancestor != null) {
            if (ancestor.equals(v)) {
                onPath = true;
                break;
            }
            ancestor = ancestor.getPredecessor();
        }
        
        return onPath;
    }
    
    /**
     * Expands a vertex v in a state space search tree by creating a list
     * (its children) of all vertices adjacent to it in the state space.
     * The list may not include any vertex on the predecessor path 
     * leading to v.
     * Each child on the list has its predecessor set to v and its distance
     * from the root (its depth in the search tree) set to one more than v's 
     * distance.
     * @param v the vertex being expanded
     * @return a list of the children
     */
    public List<Vertex> expand(Vertex v) {
        List<Vertex> children = new ArrayList<Vertex>();
        
        for (Move move : moves) {
            Vertex child = (Vertex) move.doMove((State)v);
            if (child != null && (!occursOnPath(child, v))) {
                child.setDistance(v.getDistance()+1);
                child.setPredecessor(v);
                children.add(child);
            }
        }
        return children;
    }
    
    /**
     * 
     * @param s
     * @param adder
     * @return 
     */
    public Vertex search(Vertex s) {
        int queueOps = 0, queueSize = 0, maxQueueSize = 0;
        s.setDistance(0);
        s.setPredecessor(null);
        Vertex u = null;
        
        PriorityQueue<Vertex> queue = new PriorityQueue<Vertex>();
        queue.add(s);
        
        
        while (!queue.isEmpty()) {
            u = queue.remove();
            currentState = (State) u;
            
            queueOps++;
            queueSize--;
            maxQueueSize = max(queueSize, maxQueueSize);
        setMaxQueueSize(maxQueueSize);
        setQueueOps(queueOps);
            
            if (success()) {
                return u;
            }
            else {
                for (Vertex v : expand(u)) {
                    queue.add(v);
                    //adder.add(v, deq);
                    queueOps++;
                    queueSize++;
                    maxQueueSize = max(queueSize, maxQueueSize);
        setMaxQueueSize(maxQueueSize);
        setQueueOps(queueOps);
                }
            }
        }
        maxQueueSize = max(queueSize, maxQueueSize);
        setMaxQueueSize(maxQueueSize);
        setQueueOps(queueOps);
        
        return null;
    }
    
    public void setQueueOps(int ops) {
        queueOperations = ops;
    }
    public int getQueueOps() {
        return queueOperations;
    }
    
    public void setMaxQueueSize(int max) {
        maximumQueueSize = max;
    }
    public int getMaxQueueSize() {
        return maximumQueueSize;
    }
    
    public void setInitialStates(List<State> initialStates) {
        this.initialStates = initialStates;
    }
    public List<State> getInitialStates() {
        return initialStates;
    }
    
    public void setFinalStates(List<State> finalStates) {
        this.finalStates = finalStates;
    }
    public List<State> getFinalStates() {
        return finalStates;
    }
    
    public void setMoveCounts(List<Integer> moveCounts) {
        this.moveCounts = moveCounts;
    }
    public List<Integer> getMoveCounts() {
        return moveCounts;
    }
    
    public void setUseChooser(boolean useChooser) {
        this.useChooser = useChooser;
    }
    public boolean useChooser() {
        return useChooser;
    }
    
    private int queueOperations, maximumQueueSize;
    
    private State currentState, finalState;
    
    private List<State> initialStates, finalStates;
    
    private List<Integer> moveCounts;
    
    private List<Canvas> initialCanvases, finalCanvases;
    
    private String introduction;
    
    private List<Move> moves;
    
    private boolean useChooser;
}
