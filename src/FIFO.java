public class FIFO implements Iterable<Node>{

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
			return;
		}

		// all other nodes
		head.next.prev = n;
		n.next = head.next;

		n.prev = head;
		head.next = n;

		return;

	}

	// remove from back
	public boolean remove(Node n) {

		Node cur = n; 
		Node next = n.next; 
		Node prev = n.prev;
		
		// 0 node
		if (tail == null) {
			return false;
		}

		// 1 node
		if (tail == head) {
			tail = head = null;
			return true;
		}

		 = tail.prev;
		
		return true;

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
	
	public static void main ( String[] args ){
		
		FIFO queue = new FIFO();
		
		queue.add(5);
		queue.add(6);
		queue.add(7);
		
		for (Node q: queue) {
			System.out.println(q);
		}
		
	}

}
