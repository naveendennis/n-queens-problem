package dennis.core.beans.nqueens;

import dennis.core.beans.Node;
import dennis.core.beans.State;

public class NodeImpl implements Node, Comparable<NodeImpl> {

	private Integer heuristicValue;
	private State state;

	public NodeImpl(State state) {
		this.state = state;
	}

	@Override
	public Integer getHeuristicValue() {
		return heuristicValue;
	}

	@Override
	public void setHeuristicValue(int heuristicValue) {
		this.heuristicValue = heuristicValue;
	}

	@Override
	public State getState() {
		return state;
	}

	@Override
	public int compareTo(NodeImpl o) {
		return this.getHeuristicValue() - o.getHeuristicValue();
	}

	@Override
	public String toString() {
		return heuristicValue + "->" + this.state.toString();
	}

}
