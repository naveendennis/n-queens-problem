package dennis.core.util;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import dennis.core.beans.Node;
import dennis.core.beans.State;
import dennis.core.beans.nqueens.NodeImpl;
import dennis.core.beans.nqueens.StateImpl;

public class NodeUtilImpl implements NodeUtil {

	private static NodeUtil instance;

	public static NodeUtil getInstance() {
		if (instance == null) {
			instance = new NodeUtilImpl();
		}
		return instance;
	}

	@Override
	public int calculateHeuristicValue(State state) {
		int heuristicValue = 0;
		int[] currentState = state.getValue();
		for (int eachQueen = 0; eachQueen < currentState.length - 1; eachQueen++) {
			int colVal = eachQueen;
			int rowVal = currentState[colVal];
			for (int tempRow = rowVal + 1, tempCol = colVal + 1; tempRow < currentState.length
					&& tempCol < currentState.length; tempRow++, tempCol++) {
				if (currentState[tempCol] == tempRow) {
					heuristicValue++;
				}
			}
			for (int tempRow = rowVal - 1, tempCol = colVal + 1; tempRow >= 0
					&& tempCol < currentState.length; tempRow--, tempCol++) {
				if (currentState[tempCol] == tempRow) {
					heuristicValue++;
				}
			}
			for (int otherQueen = eachQueen + 1; otherQueen < currentState.length; otherQueen++) {
				if (currentState[otherQueen] == currentState[eachQueen]) {
					heuristicValue++;
				}
			}
		}

		return heuristicValue;

	}

	@Override
	public PriorityQueue<Node> calculateHeuristicValuesForAllSuccessors(Node node) {
		PriorityQueue<Node> adjacentNodes = new PriorityQueue<Node>();
		int[] state = node.getState().getValue();
		for (int outer = 0; outer < state.length; outer++) {
			Integer[] value = this.populate(state.length, state[outer]);
			for (int index = 0; index < value.length; index++) {
				State newState = new StateImpl(node.getState());
				newState.setState(value[index], outer);
				adjacentNodes.add(new NodeImpl(newState));
			}
		}
		return adjacentNodes;
	}

	private Integer[] populate(int size, int currentValue) {
		List<Integer> list = new ArrayList<Integer>();
		for (int iterator = 0; iterator < size; iterator++) {
			list.add(iterator);
		}
		list.remove(currentValue);
		return list.toArray(new Integer[list.size()]);
	}

}
