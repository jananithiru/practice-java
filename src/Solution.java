import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */

		// utopianTree();
		// angryProfessor();

		// System.out.println(pangram());

		// alternatingCharacters();

		//System.out.println(gameOfThrones());
		
		//loveLetter();
		
		lonelyInteger();
		
	}

	public static void lonelyInteger() {
		
		Scanner in = new Scanner(System.in);
		
		int numOfInts = in.nextInt();
		int[] a = new int[numOfInts];
		int[] counts = new int[100];
		
		/*String s = in.nextLine(); 
		String[] strings = s.split("\\s");
		int num = Integer.parseInt(strings[i]);*/
		
		int num ;
		for( int i=0; i < numOfInts ; i++){
			
			num = in.nextInt();
			counts[num] = counts[num] + 1;			
		}
		
		for ( int i=0; i < 100 ; i++)
			if ( counts[i] == 1)
				System.out.println(i);
		
	}
	
	
	public static void loveLetter(){
		
		Scanner in = new Scanner(System.in);
		
		int numOfTestCases = in.nextInt(); 
		int count ; 
		for ( int i =0; i<numOfTestCases; i++) {
			count = 0; 
			
			String s = in.next();
			int midPoint =  s.length()/2;
			int last = s.length() - 1 ; 
			
			for ( int j =0; j< midPoint ; j++, last--){
				if ( s.charAt(j) != s.charAt(last))
					count += Math.abs(s.charAt(j) - s.charAt(last));
			}
			System.out.println(count);
		}
		
		
		
	}
	
	public static String gameOfThrones() {

		Scanner in = new Scanner(System.in);

		String s = in.nextLine().toLowerCase().replaceAll("\\s", "");

		
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int count = map.containsKey(c) ? map.get(c) : 0;
			map.put(c, count + 1);
		}

		boolean one_odd_only = false;

		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			if (isOdd(entry.getValue())){
				if ( !one_odd_only )
					one_odd_only = true;
				else 
					return "NO";
			} 
		}
		
		return "YES";
	}
	
	public static boolean isOdd(int num){
		return (num % 2 != 0) ? true : false;
	}

	public static void alternatingCharacters() {

		Scanner in = new Scanner(System.in);

		int numOfTestCases = in.nextInt();

		String s;

		char[] chars;

		int count = 0;

		for (int t = 1; t <= numOfTestCases; t++) {

			s = in.next();

			chars = s.toCharArray();

			count = 0;

			for (int i = 1; i < chars.length; i++) {
				if (chars[i] == chars[i - 1]) {
					count++;
				}
			}
			System.out.println(count);
		}

	}

	public static String pangram() {

		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		String v = s.toLowerCase().replaceAll("\\s", "");

		char[] chars = v.toCharArray();

		boolean[] ascii_set = new boolean[256];

		for (int i = 0; i < chars.length; i++) {
			ascii_set[chars[i]] = true;
		}

		for (int i = 97; i < 123; i++) {
			if (ascii_set[i] != true)
				return "not pangram";
		}

		return "pangram";
	}

	public static void angryProfessor() {

		Scanner s = new Scanner(System.in);

		int T = s.nextInt(); // 10
		int N; // 1000
		int K; // 1000
		int count;
		int num;

		for (int i = 1; i <= T; i++) {
			count = 0;
			N = s.nextInt();
			K = s.nextInt();

			for (int j = 1; j <= N; j++) {
				num = s.nextInt();
				if (num <= 0)
					count++;
			}

			if (count >= K)
				System.out.println("NO" + count);
			else
				System.out.println("YES" + count);

		}

	}

	public static void utopianTree() {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */

		Scanner s = new Scanner(System.in);

		int numOfCases = s.nextInt();

		int height;
		int num;

		if (numOfCases == 0)
			return;

		for (int i = 1; i <= numOfCases; i++) {

			height = 1;

			num = s.nextInt();

			if (num == 0) {
				System.out.println(1);
				continue;
			}

			for (int j = 1; j <= num; j++) {
				if (j % 2 == 1) {

					height = height * 2;

				} else {

					height = height + 1;
				}
			}

			System.out.println(height);
		}
	}
}