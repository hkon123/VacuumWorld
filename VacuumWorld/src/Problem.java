
public class Problem {
	State initialState;
	int[] actions = new int[3];
	
	public Problem(State state) {
		initialState = state;
		actions[0] = 0;
		actions[1] = 1;
		actions[2] = 2;
	}
}
