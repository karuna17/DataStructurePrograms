public class LinkedListDemo {

	class Node {
		int data;
		Node nextNode;

		public Node(int data) {
			this.data = data;
			this.nextNode = null;
		}
	}

	public Node head = null;    
	public Node tail = null;    

	public void addNode(int data) {
		Node newNode = new Node(data);

		if(head == null) {
			head = newNode;
			tail = newNode;
		}else {
			tail.nextNode = newNode;
			tail = newNode;
		}
	}

	public void addNodeAtTheBeginning(int data) {
        System.out.println("Add a node with data " + data + " in the beginning.");
		Node newNode = new Node(data);

		if (this.head == null) {
			this.head = newNode;
		}else {
			newNode.nextNode = this.head;
			this.head = newNode;
		}
	}
	
	public void displayData() {
		Node current = head;
		
		if(head == null) {
			System.out.println("List is empty");
		}
		System.out.println("Nodes of singly linked list");
		
        while(current != null) {
        	System.out.print(current.data+" ");
        	current = current.nextNode;
        }
        System.out.println();
	}
	
	public static void main(String[] args) {
		LinkedListDemo list = new LinkedListDemo();
		list.addNode(56);
		list.addNode(30);
		list.addNode(70);
		
		list.displayData();
	}
}
