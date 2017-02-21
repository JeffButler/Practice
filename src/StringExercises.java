import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


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
		//se.testInsert20(testString);
		
		//Exercise 1.5
		String[] testString2 = {
				"aaabbbccc", 
				"aabb",
				"aba", 
				"aaaaabbbbbaaaabbbbbaaa"
		};
		//se.testCompressed(testString2);
		
		//Exercise 1.6 
		//Rotating a MXN matrix 90 degress
		int[][] m = {
				{1,2,3},
				{4,5,6},
				{7,8,9}
				};
		se.testRotate(m);
		
		//Exercise 1.7
		//Writing algorithm that sets all columns and rows to 0 if the element is 0
		int[][] m1 = {
				{1,2,3,4},
				{5,0,6,7},
				{8,9,10,11}
				};
		se.testSetZero(m1);
		
		//Exercise 1.8 
		//Finding whether string is a substring of another by calling isSubstring once
		Pair[] pairsSubstring = {
				se.new Pair("watterbottle", "lewatterbott"),
				se.new Pair("wattebottle", "lewaterbott"),
				se.new Pair("", ""),
				se.new Pair("a", "b"),
				se.new Pair("terbottle", "ltterbott"),
				se.new Pair("terbottlt", "ltterbott")
		};
		se.testRotation(pairsSubstring);
		
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
	
	/**
	 * 1.5 
	 * @param a string of repeated characters
	 * @return a compressed String
	 */
	public String compressedExerciseSlow(String s1) {
		HashMap<String, Integer> hash = new HashMap<String, Integer>();
		for (String s : s1.split("")) {
			if (hash.containsKey(s)) {
				int newHash = hash.get(s) + 1;
				hash.put(s, newHash);
			} else if (!s.isEmpty()){
				hash.put(s,  1);
			}
		}
		String newString = "";
		for(Entry<String, Integer> item : hash.entrySet()) {
			newString += item.getKey() + item.getValue();
		}
		return (newString.length() > s1.length()) ?  s1 :  newString;
	}
	
	/**
	 * Avoiding using a hash for this one, Assumes that the 
	 * @param s1
	 * @return
	 */
	public String compressedExerciseNoHash(String s1) {
		String mystr = "";
		char last = s1.charAt(0);
		int count = 1;
		for (int i = 1; i < s1.length(); i++) {
			if (s1.charAt(i) == last) {
				count++;
			} else {
				mystr += last + "" + count;
				last = s1.charAt(i);
				count = 1;
			}
		}
		return mystr + last + count;
	}
	
	public int[][] rotate90(int[][] m) {
		for (int i = 0; i < m.length /2; i++){
			for (int j = i; j < m[i].length - 1 - i; j++) {
				int temp = m[i][j];
				m[i][j] = m[m.length - 1 - i][j];
				m[m.length - 1 - i][j] = m[m.length - 1 - i][m[j].length - 1 - j];
				m[m.length - 1 - i][m[j].length - 1 - j] = m[i][m[j].length - 1 - j];
				m[i][m[j].length - 1 - j] = temp;
			}
		}
		return m;
	}
	
	/**
	 * Exercise 1.7 slow implementation
	 * @param m
	 * @return
	 */
	public int[][] matrix0(int[][] m) {
		ArrayList<Pair> pairs = new ArrayList<Pair>();
		for (int i = 0; i < m.length; i++) {
			for (int g = 0; g < m[i].length; g++) {
				if (m[i][g] == 0) {
					pairs.add(new Pair(i + "",g + ""));
					
				}
			}
		}
		
		for (Pair pair : pairs) {
			int i = Integer.parseInt(pair.getP1());
			int g = Integer.parseInt(pair.getP2());
			for (int j = 0; j < m[i].length; j++) {
				m[i][j] = 0;
			}
			for (int j = 0; j < m.length; j++) {
				m[j][g] = 0;
			}
		}
		return m;
	}

	/**
	 * Exercise 1.8 rotation exercise easy
	 * @param s1
	 * @return whether or not the string is a substring 
	 */
	public boolean isRotation(String s1, String s2) {
		return isSubstring(s1, s2 + s2);
	}
	
	/**
	 * Non-hash route
	 * @param s1
	 * @param s2
	 * @return
	 */
	public boolean isSubstring(String s1, String s2) {
		int p1 = 0, p2 = 0;
		String[] s1array = s1.split("");
		String[] s2array = s2.split("");
		
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();

	    for(String s : s1array) {
	       if(s != null && s.length() > 0) {
	          list1.add(s);
	       }
	    }
	    for(String s : s2array) {
		       if(s != null && s.length() > 0) {
		          list2.add(s);
		       }
		    }

	    s1array = list1.toArray(new String[list1.size()]);
	    s2array = list2.toArray(new String[list2.size()]);
	 
		boolean running = false;
		while (p2 < s2.length() && p2 < s1.length()) {
			if (p1 == s1array.length && running)
				break;
			else if (s1array[p1].equals(s2array[p2])) {
				running = true;
				p1++;
				p2++;
			} else {
				running = false;
				p2++;
				p1 = 0;
			}
		}
		return running;
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
	 * Exercise 1.3
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
	
	public void testCompressed(String[] str) {
		for (int i = 0; i < str.length; i++) {
			String s= str[i];
			System.out.println("Test " + i + " = " + compressedExerciseSlow(s));
		}
	}
	
	public void testRotate(int[][] m) {
		System.out.println("OLD MATRIX:");
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				//Prints Old Matrix
				System.out.print(m[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println("NEW MATRIX:");
		int[][] newmatrix = rotate90(m);
		for (int i = 0; i < newmatrix.length; i++) {
			for (int j = 0; j < newmatrix.length; j++) {
				//Prints Old Matrix
				System.out.print(newmatrix[i][j] + " ");
			}
			System.out.println("");
		}
	}
	
	public void testRotation(Pair[] pairs) {
		for (Pair pair : pairs) {
			System.out.println("TEST ROTATION: " + isRotation(pair.getP1(), pair.getP2()));
		}
	}
	
	public void testSetZero(int[][] m) {
		System.out.println("OLD MATRIX:");
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				//Prints Old Matrix
				System.out.print(m[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println("NEW MATRIX:");
		int[][] newmatrix = matrix0(m);
		for (int i = 0; i < newmatrix.length; i++) {
			for (int j = 0; j < newmatrix[0].length; j++) {
				//Prints Old Matrix
				System.out.print(newmatrix[i][j] + " ");
			}
			System.out.println("");
		}
	}
	
	public class Pair {
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
