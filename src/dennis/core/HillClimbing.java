package dennis.core;

import dennis.core.beans.Node;
import dennis.core.beans.State;

public interface HillClimbing extends ClimbHeuristic {
	/**
	 * Creates a node from the State value passed to it
	 * @param currentState
	 * @return Node
	 */
	Node makeNode(State currentState);

	/**
	 * This method contains the hillClimbing procedure
	 * @return array of currentNode, numberOfSteps and more ..
	 */
	Object[] hillClimbing();

}
