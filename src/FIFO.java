import LRU.Node;

public class FIFO {

	// add
	// remove
	// contains

	Node head;
	Node tail;

	// add in front 
	public void add(Integer data) {

		Node n = new Node(data);

		// 0 nodes
		if (head == null) {
			head = n;
			tail = n;
			return;
		}
		// 1 node
		if (head == tail) {
			n.next = tail;
			head = n;
		}

		// all other nodes
		head.next.prev = n;
		n.next = head.next;

		n.prev = head;
		head.next = n;

	}
	
	// remove from back 
	public boolean remove(Integer data) {
		
		// 0 node 
		if (tail == null) {
			return false ;
		}
		
		// 1 node  
		if (tail == head){
			tail = head = null;
		}
		
		tail = tail.prev;
		
	}

	public class Node {

		Integer data;
		Node next;
		Node prev;

		public Node(int data) {
			this.data = data;
			this.next = null;
			this.prev = null;
		}
	}

}
