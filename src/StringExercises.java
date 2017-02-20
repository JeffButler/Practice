import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;


public class StringExercises {
	
	public static void main (String[] args) throws IOException {
	
//	   File file = new File(args[0]);
//	    BufferedReader in = new BufferedReader(new FileReader(file));
//	    String line;
//	    while ((line = in.readLine()) != null) {
//	        String[] lineArray = line.split(" ");
//	        if (lineArray.length > 0) {
//	            //Process line of input Here
//	        }
//	    }
	    //lines.add("This is a line added in code.");
	    //text.writeSmallTextFile(lines, FILE_NAME);
		
		//Exercise 1.3
		
	    String[] testCases = {"reverse", "", "abc", "ab", "abcd", "rrraaa", "AAAAAJKVJ @#K J#@KJ @K#J!312"};
		StringExercises se = new StringExercises();
		//se.testReverse(testCases);
		
		//Exercise 1.4
		Pair[] testCasesPerm = {
				se.new Pair("abc", "cab"),
				se.new Pair("abc", "abb"), 
				se.new Pair("abc", "asdf"), 
				se.new Pair("asdf", "fdsa"), 
				se.new Pair("a", "a"), 
				se.new Pair("", ""), 
				se.new Pair("racecar", "racecac"), 
				se.new Pair("television", "televizion"), 
				se.new Pair("lust", "tuls")};
		se.testPerm(testCasesPerm);
		
		//Exercise 1.5
		String[] testString = {
				"my dad  ",
				"this is my    ", 
				"this is going to      "
				
		};
		se.testInsert20(testString);
		
	 }
	
	public StringExercises() {
		
	}
	
	/*
	 * 1.5 Problem with inserting %20 into String with spacing
	 */
	public String insert(String s1, int t) {
		int point1 = t - 1;
		String[] stringArray = s1.split("");
		while (stringArray[point1].equals(" ") && point1 > 0) {
			point1--;
		}
		while(point1 > 0) {
			while (!stringArray[point1].equals(" ") && point1 > 0) {
				stringArray[t] = stringArray[point1];
				t--;
				point1--;
			}
			if (point1 > 0 && !stringArray[point1].isEmpty()) {
				stringArray[t] = "0";
				stringArray[t - 1] = "2";
				stringArray[t - 2] = "%";
				point1--;
				t -= 3;
			}
		}
		return stringArrayToString(stringArray);
	}
	
	
	/*
	 * 1.4 problem with slow hash solution
	 */
	public boolean perm(String s1, String s2) {
		if (s1.length() != s2.length()) 
			return false;
		Hashtable<Character, Integer> hash1 = new Hashtable<Character, Integer>();
		Hashtable<Character, Integer> hash2 = new Hashtable<Character, Integer>();
		for (Character c : s1.toCharArray()) {
			if (hash1.containsKey(c))
				hash1.put(c, hash1.get(c) + 1);
			else 
				hash1.put(c, 1);
		}
		for (Character c : s2.toCharArray()) {
			if (hash2.containsKey(c))
				hash2.put(c, hash2.get(c) + 1);
			else 
				hash2.put(c, 1);
		}
		for (Map.Entry<Character, Integer> e1 : hash1.entrySet()) {
			if (!hash2.containsKey(e1.getKey()) || hash2.get(e1.getKey()).intValue() < e1.getValue()) {
				return false;
			}
		}
		return true;
		
	}
	
	public String stringArrayToString(String[] strArr) {
		StringBuilder strBuilder = new StringBuilder();
		for (int i = 0; i < strArr.length; i++) {
		   strBuilder.append(strArr[i]);
		}
		return strBuilder.toString();
	}
	
	public boolean permQuick(String s1, String s2) {
		int[] fastArray = new int[256];
		for (char s : s1.toCharArray()) {
			fastArray[s]++;
		}
		for (char s : s2.toCharArray()) {
			fastArray[s]--;
			if (fastArray[s] < 0) {
				return false;
			}
		}
		return true;
	}
	
	
	/**
	 * Exercise 1.3 in 
	 * @param str
	 * @return a 
	 */
	public String reverse(String str) {
		int start = 0;
		int end = str.length() - 1;
		char[] charArray = str.toCharArray();
		while (start < end) {
			char temp = charArray[start];
			charArray[start] = charArray[end];
			charArray[end] = temp;
			start++;
			end--;
		}
		return charToString(charArray);
	}
	
	public static String charToString(char[] charArray) {
		String str = "";
		for(char c : charArray) {
			str += c;
		}
		return str;
	}
	
	/*
	 * Test cases
	 */
	public void testReverse(String[] str) {
		boolean returnValue = true;
		for (int i = 0; i < str.length; i++) {
			String currentString = str[i];
			System.out.println("Testing String: " + currentString);
			String reversedString = this.reverse(currentString);
			System.out.println(reversedString);
			boolean result = currentString.equals(reverse(reverse(currentString)));
			System.out.println("Result: " + result);
			returnValue &= result;
		}
		System.out.println("All Test for Reverse Strings " + returnValue);
	}
	
	public void testPerm(Pair[] pairs) {
		for (int i = 0; i < pairs.length; i++) {
			Pair pair = pairs[i];
			System.out.println("Test " + i + " = " + permQuick(pair.getP1(), pair.getP2()));
		}
	}
	
	public void testInsert20(String[] str) {
		for (int i = 0; i < str.length; i++) {
			String s = str[i];
			System.out.println("Test " + i + " = " + insert(s, s.length()));
		}
	}
	
	private class Pair {
		String p1;
		String p2;
		
		public Pair(String s1, String s2) {
			this.p1 = s1;
			this.p2 = s2;
		}
		
		public String getP2() {
			return this.p2;
		}
		
		public String getP1() {
			return this.p1;
		}
	}
}
