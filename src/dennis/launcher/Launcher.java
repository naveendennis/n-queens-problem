package dennis.launcher;

import dennis.core.nqueens.NQueensRandomRestart;
import dennis.core.beans.State;
import dennis.core.beans.Node;

public class Launcher {
	public static void main(String[] args) {
		int noOfQueens = 10;
		try {
			while (true) {
				NQueensRandomRestart randomRestart = new NQueensRandomRestart(noOfQueens);
				Object[] result = randomRestart.randomRestartHC();
				System.out.println("Number of Queens: " + noOfQueens);
				System.out.println("Number of Restarts: " + result[0]);
				System.out.println("No of Steps: " + result[2]);
				System.out.println("Solution: ");
				printResult(((Node) result[1]).getState());
				noOfQueens++;
				System.out.println();
				System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
				System.out.println();
			}
		} catch (Exception e) {

		} finally {
			System.out.println("Max Number of Queens: " + noOfQueens);
		}

	}

	public static void printResult(State result) {
		for (int eachRow = 0; eachRow < result.getValue().length; eachRow++) {
			for (int eachCol = 0; eachCol < result.getValue().length; eachCol++) {
				char buf = (result.getValue()[eachCol] == eachRow) ? 'Q' : '_';
				System.out.print(" " + buf + " ");
			}
			System.out.println();
		}
	}
}
