
public class Queue {
	Node[] queue;
	int tail = 0;
	int head = 0;
	
	public Queue() {
		queue = new Node[10000];
	}
	
	public void ENQUEUE(Node state){
		if ((tail + 1)%10000 == head) {
			System.out.println("Overflow");
		}
		else {
			queue[tail] = state;
			tail = (tail + 1)%10000;
		}
	}
	
	public Node DEQUEUE() {
		if (head == tail) {
			System.out.println("Underflow");
			return null;
		}
		else 
			head = (head + 1)%10000;
			return queue[head-1];
	}
	
	public boolean isEmpty() {
		if (head == tail) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isQueued(Node compare) {
		if( isEmpty() == true) {
			return false;
		}
		for(int i = head; i < tail; i++) {
			if ( queue[i].state.isEqual(compare.state)) {
				return true;
			}
		}
		return false;
	}
}


