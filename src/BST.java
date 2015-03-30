import java.util.Comparator;
import java.util.Iterator;

// Common Ancestor of two nodes in a tree 
// Trie data structure implementation 
// Design a virtual meeting room

// by extending Comparable it does the default sort.

// However, we cannot try to use the default iterator anymore because we are
// not sure of the type of collection ?? or is this because of inorder, preorder, post order as well
public class BST<T extends Comparable<T>> implements Iterable<T> {

	private Node<T> root;
	private Comparator<T> treeComparator; // this can be used to do inorder,

	// preorder, postorder etc.

	/******************************************
	 * MAIN
	 ******************************************/

	public static void main(String[] args) {

		Integer[] a = { 1, 5, 2, 7, 4 };

		BST<Integer> bst = new BST<Integer>();

		for (Integer i : a)
			bst.insert(i);

		bst.preOrderTraversal();
		System.out.println();
		bst.inOrderTraversal();
		System.out.println();
		bst.postOrderTraversal();
		System.out.println();
		
		System.out.println(bst.search(5));
		System.out.println(bst.search(0));
		

	}

	/******************************************
	 * NODE definition
	 ******************************************/
	private class Node<T> {

		private T data;
		private Node left;
		private Node right;

		public Node(T data, Node l, Node r) {
			this.data = data;
			this.left = l;
			this.right = r;
		}

		public Node(T data) {
			this(data, null, null);
		}
	}

	public BST(Node<T> root, Comparator<T> comparator) {
		this.root = root;
		this.treeComparator = comparator;
	}

	public BST() {
		this(null, null);
	}

	/******************************************
	 * INSERT
	 ******************************************/

	public void insert(T data) {
		root = insert(root, data);
	}

	private Node<T> insert(Node<T> p, T toInsert) {

		if (p == null)
			return new Node<T>(toInsert);

		if (toInsert.compareTo(p.data) == 0)
			return p;

		if (toInsert.compareTo(p.data) < 0)
			p.left = insert(p.left, toInsert);
		else
			p.right = insert(p.right, toInsert);

		return p;
	}

	/******************************************
	 * SEARCH
	 ******************************************/

	public boolean search(T data) {
		 return search(root, data);
	}

	private boolean search(Node<T> p, T toSearch) {
		boolean retValue = false;

		if (p == null)
			retValue = false;

		else if (toSearch.compareTo(p.data) == 0)
			retValue = true;

		else if (toSearch.compareTo(p.data) < 0)
			retValue = search(p.left, toSearch);
		else
			retValue = search(p.right, toSearch);

		return retValue;
	}



	/******************************************
	 * PRE ORDER
	 ******************************************/

	public void preOrderTraversal() {

		preOrder(root);

	}

	public void preOrder(Node<T> node) {
		if (node != null) {
			System.out.print(node.data.toString() + " ");
			preOrder(node.left);
			preOrder(node.right);
		}
	}

	/******************************************
	 * IN ORDER
	 ******************************************/

	public void inOrderTraversal() {

		inOrder(root);

	}

	public void inOrder(Node<T> node) {
		if (node != null) {
			inOrder(node.left);
			System.out.print(node.data.toString() + " ");
			inOrder(node.right);
		}
	}

	/******************************************
	 * POST ORDER
	 ******************************************/

	public void postOrderTraversal() {

		postOrder(root);

	}

	public void postOrder(Node<T> node) {
		if (node != null) {
			postOrder(node.left);
			postOrder(node.right);
			System.out.print(node.data.toString() + " ");
		}
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
