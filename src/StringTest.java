import java.util.ArrayList;
import java.util.HashMap; 

//Implement an algorithm to determine if a string has all unique characters. What if you
//can not use additional data structures?

public class StringTest {

	ArrayList<String> dict = new ArrayList<String>(); 

	public void buildDictionary() {
		dict.add("hello");
		dict.add("peanut");
		dict.add("butter");
		dict.add("world");
	}

	public String splitWords (String s) {
		buildDictionary();
		String word1 = new String(); 
		String word2 = new String(); 
		int length = s.length();

		if ( length == 0 || s == null ) {
			return new String ("Null or Empty String");
		}
		for ( int i=0; i < dict.size(); i++) {
			String w = dict.get(i);
			int index = s.indexOf(w);
			if (index == 0) { // handle duplicates
				index = s.indexOf(w, index+1);
			}
			if ( index > 0  ) {  
				word1 =  s.substring(0,index); // Substring  
				word2 =  s.substring(index,length); //Substring
				break;
			}	
		}
		return new StringBuilder().append(word1).append(" ").append(word2).toString(); 
	}

	public void testSplitWords(){
		//String s = "";
		String s0 = "peanut";
		System.out.println("splitWords:\t" +splitWords(s0));
		String s1 = "peanutbutter";
		System.out.println("splitWords:\t" +splitWords(s1));
		String s2 = "peanutpeanut";
		System.out.println("splitWords:\t" +splitWords(s2));
	}
	public Integer googlePalindrome(String s) {
		// null string check 
		// empty string check
		// check if already a palindrome then return length of string

		int length = s.length(), last = length-1, minLength = 0;
		char[] chars = s.toCharArray(); 
		StringBuilder sb = new StringBuilder(s); 

		for ( int i = 0 ; i < length  ; i++) {
			sb.insert(i,chars[last-i]);
			for (int j=0; j<length/2;i++) {
				if(chars[j] != chars[last-j]) {
					minLength = length+i;
					break;
				}
			}}
		return minLength;
	}

	public Boolean isPalindrome(String s) {
		int length = s.length(), last = length - 1; 
		char[] chars = s.toCharArray(); 
		for (int i=0; i<length/2;i++) {
			if(chars[i] != chars[last-i])
				return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}


	public void testGooglePalindrome() {
		//String s = "racexyzart";
		String s = "abbbb";
		System.out.println("minLength="+googlePalindrome(s));
	}

	public String reverse (String s) {
		int length = s.length(), last = length - 1; 
		char[] chars = s.toCharArray();

		for (int i = 0 ; i< length/2 ; i++) {
			char temp = chars[last-i];
			chars[last-i] = chars[i];
			chars[i] = temp; 
			//last--; 
		}
		return new String(chars); 
	}


	public void testReverseString() {
		System.out.println("\ntestReverseString:\t");
		String s = "Janani, My name is";
		System.out.println("String: "+s+" Result: "+reverse(s));

	}

	public Boolean hasUniqueChars (String s) {

		HashMap<String,Boolean> charMap = new HashMap<String,Boolean>(); 
		int length = s.length();
		Boolean result = Boolean.TRUE; 

		char[] chars = s.toCharArray(); 

		for (int i = 0 ; i < length ; i++) {
			if (charMap.containsKey(String.valueOf(chars[i]))) {
				System.out.println("String: "+String.valueOf(chars[i])+" Result: "+chars[i]);
				result = Boolean.FALSE;
				break;
			}else {
				charMap.put(String.valueOf(chars[i]),Boolean.TRUE);
			}
		}  
		return result;
	}

	public void testStringHasUniqueChars () {
		System.out.println("\nhasUniqueChars:\t");
		String s = "Datjk"; 
		System.out.println("String: "+s+" Result: "+hasUniqueChars(s));

		String s2 = "Datum1+Operand2"; 
		System.out.println("String: "+s2+" Result: "+hasUniqueChars(s2));
	}

	public void testStringBuffer() {
		String[] words = { "I", "am", "trying", "to", "work", "really", "hard" };

		StringBuilder sb = new StringBuilder(); 

		for (String w : words) { 
			sb.append(w);
		}
		System.out.println(sb.toString());

	}

	public boolean isUnique(String s) {

		int length = s.length(); 
		char[] charArray = s.toCharArray(); 

		for ( int i = 0; i<length-1 ; i++) {
			for ( int j = i+1 ; j < length ; j++) {
				if(charArray[i]==charArray[j])	{
					return false;
				}
			}
		}
		return true;
	}

	public Boolean isUnique2(String s) {
		// if hash collision return false 
		boolean[] char_set = new boolean[256]; // ASCII
		int length = s.length();
		char[] chars = s.toCharArray();
		for ( int i=0; i < length ; i++) {
			if (char_set[chars[i]]) {
				return Boolean.FALSE;
			}
			char_set[chars[i]] = true;
		}
		return Boolean.TRUE;
	}

	public Boolean isUnique3(String s) {
		int checker = 0 ; 

		for ( int i =0 ; i < s.length() ; i ++) {
			int val = s.charAt(i) - 'a'; 
			
			System.out.println("Before :char: "+s.charAt(i)+" value: "+val+" checker: "+checker);
			if (( checker & ( 1 << val )) > 0 ) {
				System.out.println("Exit char: "+s.charAt(i)+" value: "+val+" checker: "+checker);
				return Boolean.FALSE; 
			}
			
			checker |= ( 1 << val ); 
			System.out.println("char: "+s.charAt(i)+" value: "+val+" checker: "+checker);
		}
		return Boolean.TRUE;
	}

	public void test1() {
		String s1 = "xyzAa";
		System.out.println(isUnique3(s1));
		//assert isUnique3(s1);
		/*Assert.AssertTrue();
		String s2 = “ABCDEFGHIJKLMNOPQRSTUVWXYZABC”;
		Assert.AssertTrue(!isUnique(s));*/
	}
	 
		
	public void findRegexPattern ( String txt, String patt ) { 

		int m = patt.length(); 
		int n = txt.length(); 
		int GAP = '*' ; 

		char[] pattern = patt.toCharArray();
		char[] text = txt.toCharArray();
	
		int gap = 0;
		int skipper = 0;
		int k = 0 ;
		int pos = 0; 
	
		for ( int i = 0 ; i < n ; i ++ ) {
			for ( int j = 0 ; j < m ; j++) {
				
				if ( pattern[j] == GAP ) {
					k = skipper;
					j++;
					while (k < n && pattern[j] != text[i+j+k]) k++;
					skipper = k-(i+j);
					continue;
				} else if ( pattern[j] != text[i+j+skipper])
						break ; 
				else System.out.println(i); 
				}
								
			}
		}			

	
	public void testRegex() {
		String s = "cabbbbacdcabbbbacd";
		String p = "a*ac*b";
		
		findRegexPattern(s, p);
	}


	public static void main(String args[]) {
		StringTest st = new StringTest(); 
		//st.testReverseString();
		//st.testStringHasUniqueChars();
		//st.testSplitWords();
		//st.testGooglePalindrome();

		//st.testStringBuffer();

		//st.test1();
		st.testRegex();



	}
}
