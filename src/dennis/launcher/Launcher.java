package dennis.launcher;

import dennis.core.nqueens.NQueens;
import dennis.core.nqueens.NQueensRandomRestart;
import dennis.core.beans.State;

import java.util.Scanner;

import dennis.core.beans.Node;

public class Launcher {

	private static Scanner in;

	static {
		in = new Scanner(System.in);
	}

	public static void randomRestartNQueens(int noOfQueens) {
		NQueens randomRestart = new NQueensRandomRestart(noOfQueens);
		Object[] result = randomRestart.hillClimbing();

		System.out.println("Number of Restarts: " + result[2]);
		System.out.println("No of Steps(state changes): " + result[1]);
		System.out.println("Solution: ");
		printResult(((Node) result[0]).getState());
	}

	/**
	 * Runs a comparison between steepest ascent and randomrestart
	 */
	public static void runLoadCheck() {
		int noOfQueens = 10;
		try {
			while (true) {
				System.out.println("$ Number of Queens: " + noOfQueens);
				System.out.println("$ Random Restart: ");
				randomRestartNQueens(noOfQueens);
				noOfQueens++;
				System.out.println();
				System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Max Number of Queens computable during test: " + (noOfQueens - 1));
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

	public static void main(String[] args) {

		System.out.println("Runs at acceptable speeds for noOfQueens = 25 but it can go upto 43-50 queens if patient");
		System.out.println("\nEnter the size of the chessboard (NxN) where N(no of Queens)= ");
		int noOfQueens = in.nextInt();
		try {
			randomRestartNQueens(noOfQueens);
		} catch (Exception e) {
			System.out.println("System not able to compute the game state for specified number of queens "
					+ "because of the lack of heap space -->> Try N=25");
		}

		in.close();
	}
}
