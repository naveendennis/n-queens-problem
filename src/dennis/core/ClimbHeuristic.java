package dennis.core;

import java.util.List;

import dennis.core.beans.Node;

public interface ClimbHeuristic {
	Node getHighestValuedSuccessor(Node current);

	List<Node> getBestSuccessors(Node current);
}
