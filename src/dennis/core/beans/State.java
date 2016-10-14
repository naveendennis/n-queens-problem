package dennis.core.beans;

/**
 * It represents the state used in problem formulation
 * 
 * @author dennis
 *
 */
public interface State {
	public int[] getValue();

	public State setState(int row, int column);

	public State generateRandomState();

}
