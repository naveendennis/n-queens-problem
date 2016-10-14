package dennis.core;

import java.util.List;

import dennis.core.beans.Node;

public interface ClimbHeuristic {
	/**
	 * Gets the next best successor Node
	 * 
	 * @param current
	 * @return the best successor Node
	 */
	Node getHighestValuedSuccessor(Node current);

	/**
	 * Returns a list of nodes as candidates for the highestValuedSuccessor
	 * 
	 * @param current
	 * @return list of best successor Node(s)
	 */
	List<Node> getBestSuccessors(Node current);
}
