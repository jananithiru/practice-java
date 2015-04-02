import java.util.*;

public class LRU implements Iterable <Integer> {

	private LinkedList<Integer> queue;
	private Map<Integer, String> map;
	private int capacity;

	public LRU(int capacity) {
		
		queue = new LinkedList<Integer>();
		map = new HashMap<Integer, String>();
		this.capacity = capacity;
	}

	public void set(Integer key, String value) {

		if (!queue.contains(key)) {
			if (queue.size() >= capacity) {
				queue.removeFirst();
			}
			queue.addLast(key);
		}
		map.put(key, value);
	}

	public String get(Integer key) {
		if (queue.contains(key))
			return map.get(key);
		return null;
	}

	public static void main(String[] args) {

		LRU lru = new LRU(5);

		lru.set(11, "a");
		lru.set(21, "a");
		lru.set(31, "a");
		lru.set(31, "a");
		lru.set(12, "a");

		lru.set(55, "a");

		System.out.println(lru.get(55));
		
		Iterator<Integer> myIter = lru.iterator();
		
		while (myIter.hasNext()) {
			System.out.println("Element: "+myIter.next());
		}
	}

	@Override
	public Iterator<Integer> iterator() {
		// TODO Auto-generated method stub
		return queue.iterator();
		
	}

}
