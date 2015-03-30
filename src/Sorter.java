import java.util.Arrays;

public class Sorter {

	public static void main(String[] args) {

		Integer[] array1 = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };

		Integer[] array2 = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };

		Sorter s = new Sorter();

		// @SuppressWarnings("rawtypes")

		// Comparable[] temp = new Comparable[array1.length];
		// s.mergeSort(array, temp, 0, array.length-1);
		// System.out.println("Sorted Array: " + Arrays.toString(temp)+
		// array.length);

		s.mergeTwoArrays(array1, array2);
	}

	public void mergeSort(Comparable[] array, Comparable[] temp, int start,
			int end) {

		if (start < end) {
			// int mid = (start+end)/2;
			int mid = start + ((end - start) / 2); // left+right <<< 2 ;
			mergeSort(array, temp, start, mid);
			mergeSort(array, temp, mid + 1, end);
			merge(array, temp, start, mid, end);
		}

	}

	public void merge(Comparable[] array, Comparable[] temp, int start,
			int mid, int end) {

		int left = start;
		int leftEnd = mid;
		int right = mid + 1;
		int rightEnd = end;
		int numElements = rightEnd - left + 1;

		int i = left;

		while (left <= leftEnd && right <= rightEnd) { // unequal sizes
			if (array[left].compareTo(array[right]) < 1) {
				temp[i++] = array[left++];
			} else {
				temp[i++] = array[right++];
			}
		}

		while (left <= leftEnd) { // copy remaining
			temp[i++] = array[left++];
		}

		while (right <= rightEnd) {
			temp[i++] = array[right++];
		}

		for (int k = 0; k < numElements; k++, rightEnd--) {
			array[rightEnd] = temp[rightEnd];
		}

	}

	public void mergeTwoArrays(Comparable[] array1, Comparable[] array2) {

		int tempSize = array1.length + array2.length;

		Comparable[] temp = new Comparable[tempSize];

		mergeArrays(array1, array2, temp, 0, array1.length - 1, 0,
				array2.length - 1);

		System.out.println("Merged Array" + Arrays.toString(temp));

	}

	public void mergeArrays(Comparable[] a, Comparable[] b, Comparable[] t,
			int left, int leftEnd, int right, int rightEnd) {

		int k = 0;
		while (left <= leftEnd && right <= rightEnd) {
			if (a[left].compareTo(b[right]) > 0) {
				t[k++] = a[left++];
			} else
				t[k++] = b[right++];
		}

		while (left <= leftEnd)
			t[k++] = a[left++];

		while (right <= rightEnd)
			t[k++] = b[right++];

	}

}
