package dennis.core.util;

import java.util.PriorityQueue;

import dennis.core.beans.Node;
import dennis.core.beans.State;

public interface NodeUtil {
	/**
	 * Calculates the heuristicValue for the entireNode
	 * @param node
	 * @return heuristicValue
	 */
	PriorityQueue<Node> calculateHeuristicValuesForAllSuccessors(Node node);

	/**
	 * Calculates heuristics for that particular State
	 * @param state
	 * @return heuristicValue
	 */
	int calculateHVGameState(State state);
	
}
