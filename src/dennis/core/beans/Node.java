package dennis.core.beans;

/**
 * It represents each Node in the hill climbing algorithm.
 * @author dennis
 *
 */
public interface Node {
	
	void setHeuristicValue(int heuristicValue);
	
	Integer getHeuristicValue();

	State getState();
}
