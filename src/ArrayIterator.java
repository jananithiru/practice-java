import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIterator<T> implements Iterator<T> {

	T[] array;
	int counter = 0;

	public ArrayIterator(T[] a) {
		this.array = a;
//		counter = a.length;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		if (counter >= array.length)
			return false;
		return true;
	}

	@Override
	public T next() {
		if (!hasNext())
			throw new NoSuchElementException("jthiru: No elements left");
		return array[counter++]; // can't do this
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		

	}

	public static void main(String[] args) {

		Integer[] array = new Integer[] { 1, 2, 3, 4, null, 5, 6 };

		ArrayList<Integer> arrayList = new ArrayList<Integer>();

		arrayList.add(1);
		arrayList.add(2);
		arrayList.add(3);
		arrayList.add(4);
		arrayList.add(null);
		arrayList.add(5);
		arrayList.add(6);

		Iterator<Integer> javaIter = arrayList.iterator();

		while (javaIter.hasNext())
			System.out.println("JavaIter" + javaIter.next());

		ArrayIterator<Integer> arrayIter = new ArrayIterator<Integer>(array);

		while (arrayIter.hasNext()) {
			System.out.println("my iter:" + arrayIter.next());
		}

	}

}
