package dennis.core.nqueens;

import dennis.core.beans.Node;

public class NQueensRandomRestart extends NQueens {
	public NQueensRandomRestart(int size) {
		super(size);
	}

	@Override
	public Object[] hillClimbing() {

		int numberOfRestarts = -1;
		Object[] obj = new Object[2];
		Node result = null;
		int noOfSteps = 0;
		do {
			obj = super.hillClimbing();
			result = (Node) obj[0];
			noOfSteps += (Integer) obj[1];
			numberOfRestarts++;
		} while (result.getHeuristicValue() != 0);
		return new Object[] { numberOfRestarts, result, noOfSteps };
	}

}
