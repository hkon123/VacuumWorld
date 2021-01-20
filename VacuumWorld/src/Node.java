
public class Node {
	State state;
	Node parrent;
	int actionTaken;
	
	public Node(State S, Node p, int action) {
		state = S;
		parrent = p;
		actionTaken = action;
	}
}
