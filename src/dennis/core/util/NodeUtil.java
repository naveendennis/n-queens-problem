package dennis.core.util;

import java.util.PriorityQueue;

import dennis.core.beans.Node;
import dennis.core.beans.State;

public interface NodeUtil {
	PriorityQueue<Node> calculateHeuristicValuesForAllSuccessors(Node node);

	int calculateHeuristicValue(State state);
}
