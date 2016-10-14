package dennis.core.nqueens;

import dennis.core.beans.Node;

/**
 * Here the NQueensRandom Restart is computed by doing randomRestarts on NQueens
 * 
 * @author dennis
 *
 */
public class NQueensRandomRestart extends NQueens {
	public NQueensRandomRestart(int size) {
		super(size);
	}

	/**
	 * Here hillClimbing is performed n number of times. And the n value is
	 * tracked as the numberOfRestarts
	 */
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
		return new Object[] { result, noOfSteps, numberOfRestarts };
	}

}
