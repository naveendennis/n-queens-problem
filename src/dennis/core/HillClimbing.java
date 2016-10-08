package dennis.core;

import java.util.List;

import dennis.core.beans.Node;
import dennis.core.beans.State;

public interface HillClimbing {
	Node makeNode(State currentState);
	State hillClimbing();
	Node getHighestValuedSuccessor(Node current);
	List<Node> generateSuccessors();	

}
