package dennis.core.beans.nqueens;

import java.util.Random;

import dennis.core.beans.State;

public class StateImpl implements State {

	private int state[];
	private int size;
	private static Random generator;

	static {
		generator = new Random();
	}

	public StateImpl(int size) {
		this.size = size;
		this.state = new int[size];
		this.generateRandomState();
	}

	public StateImpl(State state) {
		this.state = new int[state.getValue().length];
		for (int index = 0; index < this.state.length; index++) {
			this.state[index] = (Integer) state.getValue()[index];
		}
	}

	public int[] getValue() {
		return state;
	}

	@Override
	public State generateRandomState() {
		for (int index = 0; index < state.length; index++) {
			state[index] = generator.nextInt(size);
		}
		return this;
	}

	@Override
	public State setState(int value, int index) {
		state[index] = value;
		return this;
	}
	
}
