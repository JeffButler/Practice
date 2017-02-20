import java.util.Collections;
import java.util.PriorityQueue;


public class main {

	public main() {

	}

	public boolean uniqueString(String s) {
		for (int i = 0; i < s.length() - 1; i++) {
			char c = s.charAt(i);
			for (int g = i + 1; g < s.length(); g++) {
				if ((c + "").equals("" + s.charAt(g))){
					return false;
				}
				
			}
		}
		return true;
	}
	
	public boolean isSubstring(String s1, String s2){
		int p1 = 0, p2 = 0;
		int s1_length = s1.length();
		int s2_length = s2.length();
		int cache_spot = -1;
		if (s1_length != s2_length)
			return false;
		while(p2 < s2_length){
			if (!(s1.charAt(p1) + "").equals("" +s2.charAt(p2)))
				p1++;
			else if (!(s1.charAt(p1) + "").equals("" + s2.charAt(p2)) && cache_spot != -1){
				return false;
			}
			p2++;
		}
		p2 = 0;
		while (s1_length - p1 > p2){
			if (!(s1.charAt(p1) + "").equals(s2.charAt(p2) + ""))
				return false;
			p2++;
			p1++;
		}
		return true;
	}
	
	public boolean palindrome(String s ){
		int p1 = 0;
		int p2 = s.length() - 1;
		while (p1 < p2){
			if (!(s.charAt(p1) + "").equals(s.charAt(p2) + ""))
				return false;
			p1++;
			p2--;
		}
		return true;
	}
	
	public void kTop(int[] array, int k){
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(20, Collections.reverseOrder());
		for (int i : array)
			pq.add(i);
		for (int i = 0; i < k; i++)
			System.out.print(pq.poll() + " ");
	}
	
	
	
	public String insert20(String s){
		char[] array = s.toCharArray();
		int correctStringIndex = array.length - 1;
		boolean intro = true;
		for (int i = array.length - 1; i > -1 ; i--){
			if (!(array[i]+"").equals(" ")){
				array[correctStringIndex] = array[i];
				correctStringIndex--;
				intro = false;
			}
			else if (!intro){
				array[correctStringIndex] = '0';
				array[correctStringIndex - 1] = '2';
				array[correctStringIndex - 2] = '%';
				correctStringIndex -= 3;
			}
		}
		return new String(array);
	}
	
	public boolean palindromeNumber(int[] array){
		if (array == null || array.length == 0)
			return false;
		int p1 = 0;
		int p2 = array.length - 1;
		while (p1 < p2){
			if ((array[p1] ^ array[p2]) != 0){
				return false;
			}
			p1++;
			p2--;
		}
		return true;
		
	}
	public int longestIncreasingSubsequence(int[] array){
		if (array == null || array.length == 0)
			return 0;
		int[] B = new int[array.length];
		int rv = 0;
		for (int i = array.length -1; i >= 0; i--){
			int max = -99999;
			for (int j = i+1; j < array.length - 1; j++){
				if (array[i] < array[j]){
					max = Math.max(max,  1 + B[j]);
					B[i] = max;
				}
			}
			rv = Math.max(rv,max);
		}
				
		return rv + 1;
	}
	
	public static void testInsert20(main m) {
		System.out.println("SHould be Mr%20John%20Smith" + m.insert20("Mr John Smith    ") + "poop");
		System.out.println("SHould be =" + m.insert20(""));
		
	}
	
	public static void testPalindromeNumber(main m) {
		int[] array = {1, 0, 1, 0, 0, 1, 0, 1};
		int[] array2 = {1, 0, 0, 1, 1, 0, 1};
		System.out.println("SHould be True= " + m.palindromeNumber(array));
		System.out.println("SHould be False=" + m.palindromeNumber(array2));
		
	}
	
	public static void testLongestIncreasingSubsequence(main m) {
		int[] array = {10, 22, 9, 33, 21, 40, 41, 60, 80};
		int[] array2 = {8, 6, 7, 4, 1, 0, 6};
		System.out.println("SHould be 6= " + m.longestIncreasingSubsequence(array));
		System.out.println("SHould be 2=" + m.longestIncreasingSubsequence(array2));
		
	}
	
	public static void testIsSubstring(main m) {
		System.out.println("IsSubstring SHould be True =" + m.isSubstring("waterbottle", "erbottlewat"));
		System.out.println("IsSubstring SHould be False =" + m.isSubstring("waterbottle", "waterbotlle"));
		
	}
	
	public static void testIsPalindrome(main m) {
		System.out.println("Palindrome SHould be True =" + m.palindrome("racecar"));
		System.out.println("Palindrome SHould be True =" + m.palindrome("raceecar"));
		System.out.println("Palindrome SHould be False =" + m.palindrome("raceacar"));
		System.out.println("Palindrome SHould be False =" + m.palindrome("waterbottle"));
		
	}

	public static void testUniqueString(main m) {
		System.out.println("SHould be true=" + m.uniqueString("abc"));
		System.out.println("SHould be true=" + m.uniqueString(""));
		System.out.println("SHould be false=" + m.uniqueString("aa"));
		System.out.println("SHould be false=" + m.uniqueString("racecar"));
		System.out.println("SHould be true=" + m.uniqueString("abcdefghtij"));
	}
	
	public void testLL(){
		LinkedListSL<Integer> ll = new LinkedListSL<Integer>();
		ll.add(1);
		ll.add(14);
		ll.add(3);
		ll.removeHead();
		ll.removeHead();
		ll.add(7);
		ll.printAll();
		ll.remove(7);
		ll.printAll();
		ll.remove(5);
		ll.printAll();
	}
	
	public LinkedListSL<Node> reverseSLL2(LinkedListSL<Node> ll){
		if (ll == null || ll.head == null){
			return null;
		}
		else {
			Node returnNode = helper2(null, ll.head);
			ll.head = returnNode;
			return ll;
		}
	}
	
	public Node helper2(Node current, Node future){
		if (future.next == null){
			future.next = current;
			return future;
		}
		else {
			Node r = helper2(future, future.next);
			future.next = current;
			return r;
			
		}
		
	}
	
	Node reverse(Node n,Node p){   
	    if(n==null) return null;
	    if(n.next==null){ //if this is the end of the list, then this is the new head
	    n.next=p;
	    return n;
	    }
	    Node r=reverse(n.next,n);  //call reverse for the next node, 
	                                  //using yourself as the previous node
	    n.next=p;                     //Set your next node to be the previous node 
	    return r;                     //Return the head of the new list
	}
	
	public LinkedListSL<Node> reverseSLL(LinkedListSL<Node> ll){
		if (ll != null && ll.head != null){
			return helper(ll.head);
		}
		else 
			return null;
	}
	
	public LinkedListSL<Node> helper(Node root){
		if (root == null)
			return new LinkedListSL<Node>();
		else{ 
			LinkedListSL<Node> temp = helper(root.next);
			temp.addTail(root);
			temp.printAll();
			return temp;
		}
			
		
	}
	
	public static void testTopK(main m){
		int[] temp = {1,4,2,6,2,3,6,34,7,2,4,7,2,67};
		m.kTop(temp , 3);
	}
	
	public void testReverseSL1(){
		LinkedListSL<Node> ll = new LinkedListSL<Node>();
		ll.add(new Node(1));
		ll.add(new Node(2));
		ll.add(new Node(3));
		ll.add(new Node(4));
		ll.add(new Node(5));
		ll.add(new Node(6));
		ll.printAll();
		LinkedListSL<Node> l = reverseSLL2(ll);
		l.printAll(); 
	}
	
	public LinkedListSL<Node> SLLAlt(Node l1, Node l2){
		if (l1 == null && l2 == null)
			return new LinkedListSL<Node>();
		else if (l1 == null)
			return SLLAlt(l2, l1);
		else {
			LinkedListSL<Node> lister = SLLAlt(l2, l1.next);
			lister.add(l1);
			return lister;
		}
	}
	
	public LinkedListSL<Node> SLLAlt2(Node l1, Node l2){
		LinkedListSL<Node> lister = new LinkedListSL<Node>();
		while (l1 != null && l2 != null){
			Node pt1 = l1.next;
			Node pt2 = l2.next;  //keeping as a temp really helps the process
			// since 
			l1.next = null;
			l2.next = null; //Key COMPONENT. You want to deference the pointer in order 
			// to properly alternate the Node every other. 
			lister.addTail(l1);
			lister.addTail(l2);
			l1 = pt1;
			l2 = pt2;
		}
		if(l1 == null && l2 != null)
			lister.addTail(l2);
		else if (l1 != null && l2 == null)
			lister.addTail(l1);
		return lister;
	}
	public void testAlternateSLL(){
		LinkedListSL<Node> ll = new LinkedListSL<Node>();
		ll.add(new Node(1));
		ll.add(new Node(2));
		ll.add(new Node(3));
		ll.add(new Node(4));
		ll.add(new Node(5));
		ll.add(new Node(6));
		LinkedListSL<Node> l = new LinkedListSL<Node>();
		l.add(new Node(10));
		l.add(new Node(20));
		l.add(new Node(30));
		l.add(new Node(40));	
		ll.printAll();
		l.printAll();
		LinkedListSL<Node> lister = SLLAlt2(ll.head, l.head);
		lister.printAll();
	}
	
	Node returnNode = null;
	public int kToLastSLL2(Node root, int k){
		if (root == null)
			return 0;
		else {
			int index = 1 + kToLastSLL2(root.next, k);
			if (k == index)
				returnNode = root;
			return index;
		}
	}
	
	public Node ktoLastSLLI(Node root, int k){
		if (root == null)
			return null;
		else {
			Node temp = root;
			int length = 0;
			while (temp != null){
				length++;
				temp = temp.next;
			}
			int last = 0;
			while (last < length - k){
				last++;
				root = root.next;
			}
			return root;
		}
	}
	
	public LinkedListSL<Node> reverseSL1(Node root){
		if (root == null)
			return new LinkedListSL<Node>();
		else {
			LinkedListSL<Node> lister = reverseSL1(root.next);
			root.next = null;
			lister.addTail(root);
			return lister;
		}
	}
	
	public Node reverseSL2(Node p, Node c){
		if (c.next == null){
			c.next = p;
			return c;
		}
		else {
			Node temp = c.next;
			c.next = p;
			return reverseSL2(c, temp);
		}
	}
	
	public Node middleNodeSL(LinkedListSL<Node> lister){
		Node ptr1 = lister.head;
		Node ptr2 = lister.head;
		while (ptr2 != null){
			ptr2 = ptr2.next;
			if (ptr2 == null)
				break;
			ptr1 = ptr1.next;
			ptr2 = ptr2.next;
		}
		return ptr1;
	}
	
	public boolean palindrome(Node root1, Node root2){
		while (root1 != null && root2 != null){
			if (root1.data != root2.data)
				return false;
			root1 = root1.next;
			root2 = root2.next;
		}
		if (root1 != null || root2 != null)
			return false;
		return true;
	}
	
	public void testPalindromeLL(){
		LinkedListSL<Node> ll = new LinkedListSL<Node>();
		ll.add(new Node(1));
		ll.add(new Node(2));
		ll.add(new Node(3));
		ll.add(new Node(4));
		ll.add(new Node(5));
		ll.printAll();
		LinkedListSL<Node> reverse1 = reverseSL1(ll.head);
		reverse1.printAll();
		Node r2 = reverseSL2(null, reverse1.head);
		LinkedListSL<Node> reverse2 = new LinkedListSL<Node>();
		reverse2.head = r2;
		reverse2.printAll();
		System.out.println("PALINDROME TEST FALSE=" +  palindrome(reverse1.head, reverse2.head));
		System.out.println("MIDDLE NODE TEST 3=" + middleNodeSL(reverse2).data);
		reverse2.printAll();
	}
	
	public void testKtoLast(){
		LinkedListSL<Node> ll = new LinkedListSL<Node>();
		ll.add(new Node(1));
		ll.add(new Node(2));
		ll.add(new Node(3));
		ll.add(new Node(4));
		ll.add(new Node(5));
		ll.add(new Node(6));
		ll.printAll();
		kToLastSLL2(ll.head, 3);
		System.out.println("Recursive Answer should be 3=" + returnNode.data); 
		Node returnN = ktoLastSLLI(ll.head, 3);
		System.out.println("Iterative Answer should be 3=" + returnN.data); 
	}
	
	public void sortSLL(LinkedListSL<Node> lister){
		Node ptr = lister.head;
		Node ptrPrevious = null;
		while (ptr != null){
			int currentValue = (int) ptr.data;
			Node smallestNodeCurrent = ptr.next;
			Node smallestNodePrevious = ptr;
			Node smallestOverallNode = ptr.next;
			Node smallestOverallNodePrevious = ptr;
			while (smallestNodeCurrent != null){
				if ((int)smallestNodeCurrent.data < currentValue){
					currentValue = (int)smallestNodeCurrent.data;
					smallestOverallNode = smallestNodeCurrent;
					smallestOverallNodePrevious = smallestNodePrevious;
				}
				smallestNodePrevious = smallestNodeCurrent;
				smallestNodeCurrent = smallestNodeCurrent.next;
			}
			
			//Swap ptr with smallest element
			Node nextTemp = ptr.next;
			Node ptrTemp = ptr;
			if (smallestOverallNode != null && (int)ptr.data > (int)smallestOverallNode.data){
				int data = (int)ptr.data;
				ptr.data = (int)smallestOverallNode.data;
				smallestOverallNode.data = data;
			}
			ptrPrevious = ptrTemp;
			ptr = nextTemp;
			
		}
	}
	
	public void testSortSLL(){
		LinkedListSL<Node> ll = new LinkedListSL<Node>();
		ll.add(new Node(7));
		ll.add(new Node(9));
		ll.add(new Node(3));
		ll.add(new Node(2));
		ll.add(new Node(5));
		ll.add(new Node(6));
		ll.printAll();
		sortSLL(ll);
		ll.printAll();
	}
	
	public int[] shuffle(int[] a){
		for (int i = 0; i < a.length; i++){
			int index = i + (int)(Math.random() * ((a.length - i)));
			System.out.println("Random = " + index);
			int temp = a[i];
			a[i] = a[index];
			a[index] = temp;
		}
		return a;
	}
	
	public int[] gen(int m, int[] n){
		if (m > n.length)
			return null;
		int[] arr = new int[m];
		for (int i = 0; i < m; i++){
			int index = (int)(i + (Math.random() * ( n.length - i)));
			arr[i] = n[index];
			n[index] = n[i];
		}
		return arr;
	}
	
	public int smallestDifference(int[] a2, int i, int start, int end, int diff){
		if (start > end)
			return diff;
		else{
			int mid = (start + end) /2;
			diff = Math.min(Math.min(smallestDifference(a2, i, start, mid - 1, diff), 
					smallestDifference(a2, i, mid + 1, end, diff)), 
					Math.abs(a2[mid] - i));
			return diff;
		}
	}

	public int[] closestPair(int[] a1, int[] a2){
		int diff = 999999;
		int pa1 = -1;
		int pa2 = -1;
		for (int i: a1){
			int newDiff = smallestDifference(a2, i, 0, a2.length - 1, 999999); 
			if (diff > newDiff ){
				diff = newDiff;
				pa1 = i;
			}
		}
		
		diff = 999999;
		for (int i : a2){
			int newDiff = Math.abs(pa1 - i);
			if (diff > newDiff){
				diff = newDiff;
				pa2 = i;
			}
		}
		int[] returnArray = {pa1, pa2};
		return returnArray;
	}
	
	public void testSmallestPair(){
		int[] arr = {1,2,3,4,5,6,7,8};
		int[] arr2 = {10, 11, 17, 30, 40, 50};
		int[] returnArray = closestPair(arr, arr2);
		System.out.println("TEST SMALLEST PAIR BE 8,10=" + returnArray[0] + "," + returnArray[1]);
	}
	
	public void testSmallestDifference(){
		int[] arr = {1,2,3,4,5,6,7,8};
		int i = 9;
		System.out.println("TEST SMALLEST SHOULD BE 1=" + smallestDifference(arr, i, 0, arr.length - 1, 99999));
	}
	public void testShuffle(){
		int[] arr = {1,2,3,4,5,6,7,8};
		//int[] shuffled = shuffle(arr);
		System.out.println("");
		//for(int i : shuffled){
		//	System.out.print(i + ",");
		//}
		int[] poop = gen(2, arr);
		for(int i : poop){
			System.out.print(i + ",");
		}
	}
	
	public void testTree(){
		TreeNode tn = new TreeNode(4);
		Tree t = new Tree(tn);
		t.makeIntTree(5);
		t.printBFS(t.root);
	}

	public static void main(String[] args){
	main m = new main();
	m.testTree();
	//m.testSmallestPair();
	//m.testSmallestDifference();
	//m.testShuffle();
	//m.testSortSLL();
	//m.testPalindromeLL();
	//m.testAlternateSLL();
	//m.testKtoLast();
	//m.testReverseSL1();
	//m.testLL();
	/*testLongestIncreasingSubsequence(m);
	testIsSubstring(m);
	testUniqueString(m);
	testInsert20(m);
	testIsPalindrome(m);
	testTopK(m);
	testPalindromeNumber(m);*/
}
	
	
}
