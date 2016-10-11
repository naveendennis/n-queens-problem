package dennis.core.beans;

public interface Node {
	
	void setHeuristicValue(int heuristicValue);
	
	Integer getHeuristicValue();

	State getState();
}
