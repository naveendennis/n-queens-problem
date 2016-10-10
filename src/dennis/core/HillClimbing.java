package dennis.core;

import dennis.core.beans.Node;
import dennis.core.beans.State;

public interface HillClimbing {
	Node makeNode(State currentState);
	Node hillClimbing();
	Node getHighestValuedSuccessor(Node current);

}
