import java.util.HashMap;
import java.util.Map.Entry;

public class Test {
	public class RetValue {
		int pos1;
		int pos2;

		RetValue(int a, int b) {
			this.pos1 = a;
			this.pos2 = b;
		}

	}

	public RetValue checkSum(int[] array, int givenSum) {

		if (givenSum == 0)
			return null;

		HashMap<Integer, Integer> posMap = new HashMap<Integer, Integer>();

		int[] positions = new int[10];
		for (int i = 0; i < positions.length; i++)
			positions[i] = -1;

		int currSum = 0;
		int pos1 = 0;
		int pos2 = 0;

		for (int i = 0; i < array.length; i++) {
			
			currSum = givenSum - array[i];
			
			pos1 = posMap.containsKey(currSum) ? posMap.get(currSum) : -1;
			
			if (pos1 == -1)
				posMap.put(array[i], i);
			else if ( pos1 > i )
				posMap.put(array[i], i);
			else { 
				pos2 = i;
				break;
			}
		}
		
		System.out.println(posMap.entrySet());
		return new RetValue(pos1, pos2);

	}

	public static void main(String[] args) {

		Test t = new Test();
		int[] a = { 1, 6, 3, 5, 7, 5, 2, 3, 3, 7 };
		RetValue r;
		r = t.checkSum(a, 10);
		if (r != null)
			System.out.println("Pos1:" + r.pos1 + " Pos2:" + r.pos2);

	}
}