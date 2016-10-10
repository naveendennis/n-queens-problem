package dennis.core.nqueens;

import dennis.core.beans.Node;

public class NQueensRandomRestart extends NQueens {
	public NQueensRandomRestart(int size) {
		super(size);
	}

	public Object[] randomRestartHC() {

		int numberOfRestarts = 0;
		Node result = null;
		do {
			result = super.hillClimbing();
			numberOfRestarts++;
		} while (result.getHeuristicValue() != 0);
		return new Object[]{numberOfRestarts, result};
	}

}
