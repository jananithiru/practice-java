import java.util.Arrays;

public class Sort {

	public static void doMergeSort( Comparable[] A) {
		@SuppressWarnings("rawtypes")
		Comparable[] tmp = new Comparable[A.length];
		mergeSort(A,tmp, 0, A.length-1);
	}

	public static void mergeSort( Comparable[] A, Comparable[] tmp, int left, int right ) {
		if (left < right) {
			int center = (left+right)/2;
			mergeSort( A,tmp, left, center);
			mergeSort(  A,tmp, center+1, right);
			merge (A, tmp, left, center+1, right);
		}
	}
	public static void merge( Comparable[] A, Comparable[] tmp, int left, int right, int rightEnd) {

		int leftEnd = right-1;
		int k = left; 
		int num = rightEnd-left+1; 

		while ( left <= leftEnd && right <=rightEnd ) {
			if ( A[left].compareTo(A[right]) <= 0) {
				tmp[k++] = A[left++];
			} else { 
				tmp[k++] = A[right++];
			}
		}
		while ( left <= leftEnd ) {
			tmp[k++] = A[left++];
		}

		while ( right <= rightEnd ) {
			tmp[k++] = A[right++];
		}

		//System.out.println("Sorted Array: "+Arrays.toString(tmp));
		
		for ( int i =0; i < num; i++, rightEnd--) {
			A[rightEnd] = tmp[rightEnd]; 
		}
	}
	
	
	
	
	
	
	
	public static void main (String[] args) {
		//Integer[] A = { 2, 6, 3, 5, 1 };
		String[] A = { "t", "s", "th", "f", "o" };	
		doMergeSort(A); 
		System.out.println("Sorted Array: "+Arrays.toString(A));
	}
}