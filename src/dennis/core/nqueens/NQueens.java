package dennis.core.nqueens;

import java.util.List;

import dennis.core.HillClimbing;
import dennis.core.beans.Node;
import dennis.core.beans.State;
import dennis.core.beans.nqueens.StateImpl;

public class NQueens implements HillClimbing {

	private static NQueens NQUEENS;
	private int value;
	
	private NQueens(int value){
		this.value = value;
	}
	
	public static NQueens getInstance(int value){
		if(NQUEENS == null){
			NQUEENS = new NQueens(value);
		}
		return NQUEENS;
	}
	
	@Override
	public Node makeNode(State currentState) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public State hillClimbing() {
		Node current = makeNode(new StateImpl(this.value));
		while(true){
			Node neighbour = getHighestValuedSuccessor(current);
			if (neighbour.getHeuristicValue().compareTo(current.getHeuristicValue()) <= 0){
				return current.getState();
			}
			current = neighbour;
		}
	}

	@Override
	public Node getHighestValuedSuccessor(Node current) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Node> generateSuccessors() {
		// TODO Auto-generated method stub
		return null;
	}

}
