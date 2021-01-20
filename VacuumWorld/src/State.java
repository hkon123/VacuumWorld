
public class State {
	boolean dirtLeft, dirtRight;
	int position;
	
	public State(boolean left, boolean right, int pos) {
		dirtLeft = left;
		dirtRight = right;
		position = pos;
	}
	
	public boolean checkGoal() {
		if( dirtLeft == false && dirtRight == false) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isEqual(State compare) {
		if (dirtLeft == compare.dirtLeft &&
				dirtRight == compare.dirtRight &&
				position == compare.position) {
			return true;
		}
		else {
			return false;
		}
	}
}
