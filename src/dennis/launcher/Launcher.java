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

	public static void randomRestart8Queens(int noOfQueens) {
		NQueensRandomRestart randomRestart = new NQueensRandomRestart(noOfQueens);
		Object[] result = randomRestart.randomRestartHC();

		System.out.println("Number of Restarts: " + result[0]);
		System.out.println("No of Steps(state changes): " + result[2]);
		System.out.println("Solution: ");
		printResult(((Node) result[1]).getState());
	}

	public static void steepestClimb8Queens(int noOfQueens) {
		NQueens nQueens = new NQueens(noOfQueens);
		Object[] result = nQueens.hillClimbing();
		System.out.println("No of Steps(state changes): " + result[1]);
		System.out.println("Solution: ");
		Node goalNode = ((Node) result[0]);
		printResult(goalNode.getState());
		if (goalNode.getHeuristicValue() != 0) {
			System.out.println("\t (Steepest Ascent Hill Climbing is STUCK!!)");
		}

	}

	public static void runComparison() {
		int noOfQueens = 10;
		try {
			while (true) {
				System.out.println("$ Number of Queens: " + noOfQueens);
				System.out.println("$ RandomRestart VS Steepest Climb comparison");
				System.out.println();
				System.out.println("$ Random Restart: ");
				randomRestart8Queens(noOfQueens);
				System.out.println();
				System.out.println("*******************************************************************");
				System.out.println();
				System.out.println("$ Steepest Climb: ");
				steepestClimb8Queens(noOfQueens);
				noOfQueens++;
				System.out.println();
				System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
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

	public static void main(String[] args) {
		System.out.println("Do you want to run comparison of Steepest Ascent VS Random Restart ?(Y/N)");
		String choice = in.next();
		if (choice.toLowerCase().equals("Y")) {
			runComparison();
		} else {
			System.out.println("\nEnter the size of the chessboard (NxN) where N(no of Queens)= ");
			int noOfQueens = in.nextInt();
			randomRestart8Queens(noOfQueens);
		}

		in.close();
	}
}
