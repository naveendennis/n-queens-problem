package dennis.core;

import dennis.core.beans.Node;
import dennis.core.beans.State;

public interface HillClimbing extends ClimbHeuristic {
	Node makeNode(State currentState);

	Object[] hillClimbing();

}
