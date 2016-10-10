package dennis.core.beans;

public interface State {
	public int[] getValue();

	public State setState(int row, int column);

	public State generateRandomState();

}
