public class Stack {
	Node head;
	Node headPosition = null, tailPosition = null;

	private class Node {	 
		int data; 
		Node nextNode; 
		public Node(int data) {
			this.data = data;
		}
	}

	public Stack() {
		this.head = null;
	}

	public void enque(int data) {
		Node node = new Node(data);
		System.out.println("\ninserting items: "+data);

		if(headPosition == null) {
			headPosition = node;
			tailPosition = node;
		}else {
			tailPosition.nextNode = node;
			tailPosition = node;
		}
	}

	public int deque() {
		if(headPosition == null) {
			System.out.println("stack is underflow");
		}
		Node temp = headPosition;
		System.out.println("Removing: "+temp.data);
		headPosition = headPosition.nextNode;

		if(headPosition == null) {
			tailPosition = null;
		}
		int value = temp.data;
		return value;
	}

	public void push(int data) {
		Node newNode = new Node(data);

		if(newNode == null) {
			System.out.println("Stack Overflow");
		}
		newNode.data = data;
		newNode.nextNode = head;
		head = newNode;
	}

	public boolean isEmpty() {
		return head == null;		
	}

	public int pop() {
		if(head == null) {
			System.out.println("Stack is underflow");
		}
		int data = head.data;
		head = head.nextNode;
		return data;
	}

	public int peek() {
		if(!isEmpty()) {
			return head.data;
		}else {
			System.out.println("stack is empty");
			return -1;
		}
	}

	public void display() {
		Node temp = head;
		while (temp != null) {
			System.out.print("\nElements: "+ temp.data);
			temp = temp.nextNode;
		}
	}

	public static void main(String[] args) {
		Stack s = new Stack();
		s.push(20);
		s.push(30);
		s.push(40);
		s.push(50);
		s.display();

		System.out.println("\npeek element: "+ s.peek());

		System.out.println("After pop");
		s.pop();
		s.display();
		
		s.enque(60);
		s.deque();
	}

}
