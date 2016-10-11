package dennis.core.nqueens;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

import dennis.core.HillClimbing;
import dennis.core.beans.Node;
import dennis.core.beans.State;
import dennis.core.beans.nqueens.NodeImpl;
import dennis.core.beans.nqueens.StateImpl;
import dennis.core.util.NodeUtilImpl;

public class NQueens implements HillClimbing {

	protected static Random RANDOM;
	protected int noOfQueens;
	protected Node current;

	static {
		RANDOM = new Random();
	}

	public NQueens(int value) {
		this.noOfQueens = value;
	}

	@Override
	public Node makeNode(State currentState) {
		Node newNode = new NodeImpl(currentState);
		newNode.setHeuristicValue(NodeUtilImpl.getInstance().calculateHVGameState(currentState));
		return newNode;
	}

	@Override
	public Object[] hillClimbing() {
		current = makeNode(new StateImpl(this.noOfQueens));
		int noOfSteps = 0;
		while (true) {
			Node neighbour = getHighestValuedSuccessor(current);
			noOfSteps++;
			if (current.getHeuristicValue().compareTo(neighbour.getHeuristicValue()) <= 0) {
				return new Object[] { current, noOfSteps };
			}
			current = neighbour;
		}
	}

	@Override
	public Node getHighestValuedSuccessor(Node current) {
		List<Node> topSuccessors = getBestSuccessors(current);
		return topSuccessors.get(RANDOM.nextInt(topSuccessors.size()));
	}

	@Override
	public List<Node> getBestSuccessors(Node current) {
		PriorityQueue<Node> allSuccessors = NodeUtilImpl.getInstance()
				.calculateHeuristicValuesForAllSuccessors(current);
		Iterator<Node> iterator = allSuccessors.iterator();
		List<Node> topSuccessors = new ArrayList<Node>();
		int heuristicValue = -1;
		while (iterator.hasNext()) {
			Node currentNode = (Node) iterator.next();
			if (heuristicValue == -1) {
				heuristicValue = currentNode.getHeuristicValue();
				topSuccessors.add(currentNode);
			} else if (heuristicValue == currentNode.getHeuristicValue()) {
				topSuccessors.add(currentNode);
			} else {
				break;
			}
		}
		return topSuccessors;

	}
}
