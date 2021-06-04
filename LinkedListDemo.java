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

	public void deleteFirstElement(int data) {
		System.out.println("Deleting First element " + data + " from the list");
		if (this.head == null) {
			System.out.println("The List is empty.\n");
		}

		Node current = this.head, previous = this.head;

		if (this.head.data == data) {
			this.head = this.head.nextNode;
		}

		while (current != null && current.data != data) {
			previous = current;
			current = current.nextNode;
		}

		if (current != null) {
			previous.nextNode = current.nextNode;
		} else 
		{
			System.out.println("The data " + data + " could not be found in the List");
		}
	}	

	public void deleteFromEnd() {  
		if(head == null) {  
			System.out.println("List is empty");  
		}  
		else {  
			if(head != tail ) {  
				Node current = head;  
				while(current.nextNode != tail) {  
					current = current.nextNode;  
				}  
				tail = current;  
				tail.nextNode = null;  
			}  
			else {  
				head = tail = null;  
			}  
		}  
	}

	public void sortList() {  
		//Node current will point to head  
		Node current = head, index = null;  
		int temp;  

		if(head == null) {  
			return;  
		}  
		else {  
			while(current != null) {  
				index = current.nextNode;  

				while(index != null) {  
					if(current.data > index.data) {  
						temp = current.data;  
						current.data = index.data;  
						index.data = temp;  
					}  
					index = index.nextNode;  
				}  
				current = current.nextNode;  
			}      
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
		list.addNode(40);
		list.addNode(70);
		list.addNode(20);
		list.displayData();

		/*	list.addNodeAtTheBeginning(70);
		list.addNodeAtTheBeginning(30);
		list.addNodeAtTheBeginning(56);
		list.displayData();

		list.addNodeAtTheEnd(70);
		list.addNodeAtTheEnd(56);
		list.addNodeAtTheEnd(30);
		list.displayData(); */

		/*	list.deleteFirstElement(56);
		list.displayData(); */

		/*	list.deleteFromEnd();
		list.displayData();  */
		
		list.sortList();
		list.displayData();


	}
}
