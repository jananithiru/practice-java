import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ArraySolver {

	public static void main(String[] args) {
		int[] a = { 2, -1, 2, 3, 4, -5 };
		int[] b = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int[] c = { -2, -1, -3, -4, -1, -2, -1, -5, -4 };
		int[] d = { 2, 1, 3, 4, 1, 2, 1, 5, 4 };

		ArraySolver as = new ArraySolver();
		// as.maxSubArray(a);
		// as.maxSubsequence(a);
		// as.maxSubArray(b);
		// as.maxSubsequence(b);
		// as.maxSubArray(c);
		// as.maxSubsequence(c);
		// as.maxSubArray(d);
		// as.maxSubsequence(d);
		// System.out.println(as.getMaximumNumber(12345));
		// System.out.println(as.getMaximumNumber(1234555));

		// int[] e = {2, 4, 3, 5, 6, -2, 4, 7, 8, 9}; as.arrayPairSum(e, 7);

		int[] e = { 2, -1, 2, -7, 3, 4, -5, 1 };
		int[] f = { 2, -1, 2, 3, 4, -5, -7 };

		// System.out.println("MissingElement:" + as.findMissingElement1(e, f));
		// System.out.println("MissingElement:" + as.findMissingElement2(e, f));

		as.mergeTwoSortedArrays(e, f);
		int[] g1 = {-7,-7,-5,-5,-1,-1,1,2,2,2,2,3,3,4,4};
		int[] g2 = {-7,-7,-5,-5,-1,-1,1,2,2,2,2,3,3,4,4,9};
		
		int[] g3 = new int[g2.length+g1.length];
		
		for ( int i=0; i < g2.length ; i ++)
			g3[i] = g2[i];
			

		as.mergeTwoSortedArrays2(g3, g2.length, g1, g1.length);
	}

	public void maxSubArray(int[] a) {

		int curr_max_ending_here = a[0];
		int global_max = a[0];

		int curr_i = 0;
		int start_i = 0;
		int end_i = 0;

		for (int i = 1; i < a.length; i++) {

			curr_max_ending_here = curr_max_ending_here + a[i];

			if (a[i] > curr_max_ending_here) {
				curr_i = i;
				curr_max_ending_here = a[i];
			}

			if (curr_max_ending_here > global_max) {
				start_i = curr_i;
				end_i = i;

				global_max = curr_max_ending_here;
			}
		}
		System.out.println("MaxSubArray=" + global_max + " startIndex="
				+ start_i + " endIndex=" + end_i);

	}

	public void maxSubsequence(int[] a) {

		int max_seen_ending_here = a[0];
		int global_max = a[0];

		for (int i = 1; i < a.length; i++) {

			if (max_seen_ending_here < 0 && a[i] > max_seen_ending_here)
				max_seen_ending_here = a[i]; // handle only negative numbers
			else
				max_seen_ending_here = Math.max(max_seen_ending_here + a[i],
						max_seen_ending_here);
			global_max = Math.max(max_seen_ending_here, global_max);

		}
		System.out.println("MaxSubSequence=" + global_max);
	}

	public int getMaximumNumber(int a) {

		int numOfDigits = 0;
		int[] array = new int[10];
		int num = a;
		int rem = 0;

		while (num != 0) {
			rem = num % 10;
			num = num / 10;
			numOfDigits++;
			array[rem]++;
		}

		int maxNum = 0;

		for (int i = numOfDigits; i > 0; i--) {
			while (array[i] > 0) {
				maxNum = maxNum * 10 + i;
				array[i]--;
			}
		}

		return maxNum;
	}

	public void arrayPairSum(int[] a, int givenSum) {

		Set<Integer> seen = new HashSet<Integer>();

		HashMap<Integer, Integer> pairs = new HashMap<Integer, Integer>();

		int currSum = 0;

		for (int num : a) {

			currSum = givenSum - num;

			if (seen.contains(Integer.valueOf(currSum))) {

				pairs.put(num, currSum);

			} else
				seen.add(Integer.valueOf(num));
		}

		Set printSet = pairs.entrySet();
		Iterator iter = printSet.iterator();

		while (iter.hasNext()) {
			@SuppressWarnings({ "unchecked", "rawtypes" })
			Map.Entry entry = (Map.Entry) iter.next();
			System.out.println("Num1:" + entry.getValue() + " Num2:"
					+ entry.getKey());

		}

	}

	public void maxSubArrayDP(int[] a) {

		int max_seen_until_now = a[0];
		int global_max = a[0];

		int[] sums = new int[a.length];
		sums[0] = max_seen_until_now;

		for (int i = 1; i < a.length; i++) {
			max_seen_until_now = Math.max(a[i], sums[i - 1] + a[i]);
			global_max = Math.max(max_seen_until_now, global_max);
		}
		System.out.println(global_max);
	}

	/*
	 * public void getSubArraysEqualToGivenSum( int[] a ){
	 * 
	 * 
	 * }
	 */

	// b.length < a.length
	public int findMissingElement1(int[] a, int[] b) {

		Integer missingElement = 0;

		ArrayList<Integer> A = new ArrayList<Integer>(a.length);
		ArrayList<Integer> B = new ArrayList<Integer>(b.length);

		int i;
		boolean found = false;

		for (i = 0; i < a.length; i++)
			A.add(Integer.valueOf(a[i]));

		for (i = 0; i < b.length; i++)
			B.add(Integer.valueOf(b[i]));

		Collections.sort(A);
		Collections.sort(B);

		Iterator iter_A = A.iterator();
		Iterator iter_B = B.iterator();

		while (iter_A.hasNext() && iter_B.hasNext()) {
			Integer e = (Integer) iter_A.next();
			Integer f = (Integer) iter_B.next();
			System.out.println(e + " " + f);
			if (!e.equals(f)) {
				missingElement = e;
				found = true;
				break;
			}
		}
		if (!found) {
			missingElement = (Integer) iter_A.next();
			System.out.println(missingElement);
		}

		return missingElement;

	}

	// b.length < a.length
	public int findMissingElement2(int[] a, int[] b) {
		int missingElement = 0;
		HashMap<Integer, Integer> countsMap = new HashMap<Integer, Integer>(
				b.length);
		int count;
		for (int num : b) {
			count = countsMap.containsKey(num) ? countsMap.get(num) : 0;
			countsMap.put(Integer.valueOf(num), Integer.valueOf(++count));
		}
		System.out.println(countsMap.entrySet());
		for (int num : a) {

			if (!countsMap.containsKey(num) || countsMap.get(num).equals(0)) {
				missingElement = num;
				break;
			} else {
				count = countsMap.get(num);
				countsMap.put(Integer.valueOf(num), Integer.valueOf(--count));
			}

		}
		return missingElement;
	}

	public void mergeTwoSortedArrays(int[] arr1, int[] arr2) {

		ArrayList<Integer> a = new ArrayList<Integer>(arr1.length);
		ArrayList<Integer> b = new ArrayList<Integer>(arr2.length);

		for (int a1 : arr1)
			a.add(Integer.valueOf(a1));

		for (int b1 : arr2)
			b.add(Integer.valueOf(b1));

		Collections.sort(a);
		Collections.sort(b);

		int size1 = a.size() + b.size();

		int[] c = new int[size1];

		int left = 0;
		int leftEnd = a.size() - 1;

		int right = 0;
		int rightEnd = b.size() - 1;

		int k = 0;

		while (left <= leftEnd && right <= rightEnd && k < size1)
			c[k++] = (a.get(left).compareTo(b.get(right)) < 1) ? a.get(left++)
					: b.get(right++);

		while (left <= leftEnd)
			c[k++] = a.get(left++);

		while (right <= rightEnd)
			c[k++] = b.get(right++);

		System.out.println("MergedArray");

		for (int n : c)
			System.out.print("" + n+ "," );
	}

	public void mergeTwoSortedArrays2(int[] arr1, int m,  int[] arr2, int n) {

		
		int leftEnd = m -1 ; 
		int rightEnd = n -1 ;
		
		int k = leftEnd + rightEnd + 1;
		System.out.println(" m:"+m+" n:"+n+" k:"+k);
		
		while ( k >=0 ) {
			if ( rightEnd < 0 || (leftEnd >=0 && arr1[leftEnd] > arr2[rightEnd])){
				System.out.println("before: "+arr1[leftEnd]);
						
				arr1[k--] = arr1[leftEnd--] ;
			}else {
				System.out.println("before: "+arr1[rightEnd]);
				arr1[k--] = arr2[rightEnd--];
			}
		}
		
			
		for ( int a : arr1)
			System.out.print(" "+a+",");
		
	}
}
