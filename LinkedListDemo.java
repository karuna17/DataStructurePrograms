public class LinkedListDemo {
	int size;

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
		size++;
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

	public void addInMid(int data){  
		Node newNode = new Node(data);  

		Node temp, current;  
		//Store the mid position of the list  
		int count = (size % 2 == 0) ? (size/2) : ((size+1)/2);  
		//Node temp will point to head  
		temp = head;  
		current = null;  

		//Traverse through the list till the middle of the list is reached  
		for(int i = 0; i < count; i++) {  
			//Node current will point to temp  
			current = temp;  
			//Node temp will point to node next to it.  
			temp = temp.next;  
		}  

		//current will point to new node  
		current.next = newNode;  
		//new node will point to temp  
		newNode.next = temp;  
		size++;  
	}  

	public void addNodeAtTheEnd(int data) {
		System.out.println("Add a node with data " + data + " at the end.");
		Node newNode = new Node(data);

		if (this.head == null) {
			this.head = newNode;
		} else {
			Node current = this.head;
			while (current.nextNode != null) {
				current = current.nextNode;
			}
			current.nextNode = newNode;
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
		/*	list.addNodeAtTheBeginning(70);
		list.addNodeAtTheBeginning(30);
		list.addNodeAtTheBeginning(56);
		list.displayData();

		list.addNodeAtTheEnd(70);
		list.addNodeAtTheEnd(56);
		list.addNodeAtTheEnd(30);
		list.displayData(); */

	}
}
