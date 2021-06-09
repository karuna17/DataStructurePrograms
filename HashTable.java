
public class HashTable {

	class Node {
		public String data;
		public Node next;
		public Node previous;

		public Node(String data) {
			this.data = data;
			this.next = null;
			this.previous = null;
		}
	}

	Node[] hashTable;

	public HashTable(int position) {
		hashTable = new Node[position];
	}

	public int hashValue(String data) {
		int hashPosition = data.hashCode();
		hashPosition = hashPosition % hashTable.length;

		if (hashPosition < 0) {
			hashPosition += hashTable.length;
		}

		System.out.println("Hash value for: " + data + " : " + hashPosition);
		return hashPosition;
	}

	public void insert(String data) {
		int position = hashValue(data);

		Node node = new Node(data);
		Node start = hashTable[position];

		if (hashTable[position] == null) {
			hashTable[position] = node;
		}
		else {
			node.next = start;
			start.previous = node;
			hashTable[position] = node;
		}
	}

	public void print() {
		for(int i = 0; i < hashTable.length; i++) {
			System.out.print("At :" + i);
			Node current = hashTable[i];

			while(current != null) {
				System.out.print(current.data + " ");
				current = current.next;
			}
			System.out.println();
		}
	}

	public void remove(String value) {
		int size = 0;
		int position = hashValue(value);

		Node start = hashTable[position];

		Node end = start;

		if (start.data.equals(value)) {
			size--;
			if (start.next == null) {
				hashTable[position] = null;
			}
			start = start.next;
			start.previous = null;
			hashTable[position] = start;
		}

		while (end.next != null && !end.next.data.equals(value)) {
			end = end.next;
		}

		if (end.next == null) {
			System.out.println("\nElement not found\n");
		}

		size--;

		if (end.next.next == null) {
			end.next = null;
		}

		end.next.next.previous = end;
		end.next = end.next.next;

		hashTable[position] = start;

	}

	public static void main(String[] args) {
		HashTable ht = new HashTable(10);
		ht.insert("PARANOIDS");
		ht.insert("ARE");
		ht.insert("NOT");	
		ht.insert("PARANOIDS");
		ht.insert("BECAUSE");
		ht.insert("THEY");
		ht.insert("ARE");
		ht.insert("PARANOIDS");
		ht.insert("BUT");
		ht.insert("BECAUSE");
		ht.insert("THEY");
		ht.insert("KEEP");
		ht.insert("PUTTING");
		ht.insert("THEMSELVES");
		ht.insert("DELIBREATELY");
		ht.insert("INTO");
		ht.insert("PARANOIDS");
		ht.insert("AVOIDABLE");
		ht.insert("SITUATION");
		
		ht.print();
		System.out.println("=============================");
		ht.remove("PARANOIDS");
		ht.print();



	}

}
