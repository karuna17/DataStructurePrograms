
public class BinarySearchTree {

	class Node { 
		int data; 
		Node left, right; 

		public Node(int data){ 
			this.data = data; 
			left = null;
			right = null; 
		} 
	}

	Node root;

	public BinarySearchTree() {
		root = null;
	}

	public Node insert(Node node, int data) {
		if (node == null) {
			return new Node(data);
		}

		if (node.data > data) {
			node.left = insert(node.left, data);
		}

		if (node.data < data) {
			node.right = insert(node.right, data);
		} else {
			return node;
		}
		return node;		
	}

	public boolean insert(int data) {
		root = insert(root, data);
		return true;
	}
	
    public boolean search(int data) {
        return search(root, data) != null ? true : false;
    }

	public Node search(Node root, int data) {
        if (root == null || root.data == data) {
            return root;
        } else if (data < root.data) {
            return search(root.left, data);
        }
	
        return search(root.right, data);
		
	}

	public void printTree(Node root) {
        if (root == null) return;
        System.out.print(root.data +" ");
        printTree(root.left);
        printTree(root.right);
    }   

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(50);
		bst.insert(70);	
		bst.insert(30);
		bst.insert(63);

		bst.printTree(bst.root);
		
		boolean search = bst.search(63);
		System.out.println("\nIs Given Element is found? "+ search);
	}

}
