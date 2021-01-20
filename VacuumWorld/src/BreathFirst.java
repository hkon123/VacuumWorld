
public class BreathFirst {

	public static void main(String[] args) {
		
		//Setup initial state and the initial problem
		State intitalState = new State(true, true, 0);
		Problem problem = new Problem(intitalState);
		
		//run breath first algorithm and get the goal state in return
		Node goal = Search(problem);

		
		//print out sequences taken to reach goal state
		int[] actions = new int[20];
		for(int i =0; i<20; i++) {
			actions[i]=10;
		}
		int count = 0;
		do {
			if (goal == null) {
				break;
			}
			actions[count] = goal.actionTaken;
			goal = goal.parrent;
			count++;
		}while (true);
		
		for(int i =19; i>=0; i--) {
			switch(actions[i]) {
			case(-1):
				System.out.println("Initial State!");
				break;
			case(0):
				System.out.println("Move to the left!");
				break;
			case(1):
				System.out.println("Move to the right!");
				break;
			case(2):
				System.out.println("Vacuum position!");
				break;
			default:
				break;
			}
		}
	}
	
	public static Node Search(Problem problem) {
		Node node = new Node(problem.initialState, null, -1);
		if( node.state.checkGoal() == true) {
			System.out.println("initial was solution");
			return node;
		}
		Queue frontier = new Queue();
		frontier.ENQUEUE(node);
		Queue explored = new Queue();
		do {
			if (frontier.isEmpty() == true ) {
				System.out.println("failure");
				return null;
			}
			node = frontier.DEQUEUE();
			explored.ENQUEUE(node);
			for(int i=0 ; i<=2; i++) {
				Node child = childNode(node, i);
				if( frontier.isQueued(child) == false && explored.isQueued(child) == false) {
					if( child.state.checkGoal() == true) {
						return child;
					}
					frontier.ENQUEUE(child);
				}
			}		
		}while (true);
	}
	
	public static Node childNode(Node node, int action) {
		switch (action) {
		case 0:
			if (node.state.position==0) {
				return node;
			}
			else {
				return new Node(new State(node.state.dirtLeft, node.state.dirtRight, 0), node, 0);
			}
		case 1:
			if (node.state.position==1) {
				return node;
			}
			else {
				return new Node(new State(node.state.dirtLeft, node.state.dirtRight, 1), node, 1);
			}
		case 2:
			if (node.state.position==0) {
				return new Node(new State(false, node.state.dirtRight, node.state.position), node, 2);
			}
			else {
				return new Node(new State(node.state.dirtLeft, false, node.state.position), node, 2);
			}
		default:
			return null;
		}
	}

}
