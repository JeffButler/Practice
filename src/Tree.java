import java.util.LinkedList;
import java.util.Queue;


public class Tree {
	public TreeNode root;
	public int numOfChildren; 
	
	public Tree(TreeNode r){
		root = r;
	}
	
	private int[] returnShuffledArray(int[] array){
		int[] shuffledArray = new int[array.length];
		for (int i = 0; i < array.length; i++){
			int index = i + (int)(Math.random() * ((array.length) - i));
			shuffledArray[i] = array[index];
			int temp = array[i];
			array[i] = array[index];
			array[index] = temp;
		}
		return shuffledArray;
		
	}
	
	private int[] makeSortedArray(int amountOfChildren){
		int[] a = new int[amountOfChildren];
		for (int i = 0; i < a.length; i++)
			a[i] = i;
		return a;
	}
	
	private int generateRandomNumber(int min, int max){
		return min + (int)(Math.random() * (max - min));
	}
	
	public TreeNode makeIntTree(int amountOfChildren){
		if (amountOfChildren < 1)
			return null;
		int[] array = makeSortedArray(amountOfChildren);
		int[] shuffledArray = returnShuffledArray(array);
		
		
		int unassignedChildren = numOfChildren;
		int indexOfArray = 0;
		
		TreeNode root = new TreeNode(shuffledArray[indexOfArray]);
		unassignedChildren--;
		indexOfArray++;
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while (unassignedChildren > 0 && indexOfArray < numOfChildren && !queue.isEmpty()){
			TreeNode currentNode = queue.poll();
			int assignedChildren = generateRandomNumber(0, unassignedChildren);
			unassignedChildren -= assignedChildren;
			LinkedList<TreeNode> children = new LinkedList<TreeNode>();
			for (; indexOfArray < indexOfArray + assignedChildren; indexOfArray++){
				TreeNode tn = new TreeNode(shuffledArray[indexOfArray]);
				children.add(tn);
				queue.add(tn);
			}
			currentNode.children = children;
			System.out.println("In while loop");
		}
		
		return root;
	}
	
	public void printBFS(TreeNode n){
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(n);
		while(!queue.isEmpty()){
			Queue<TreeNode> parent = queue;
			Queue<TreeNode> children = new LinkedList<TreeNode>();
			String levelString = "";
			for (TreeNode tn: parent){
				levelString += tn.data + " ";
				if (tn.getChildren() != null)
					for (TreeNode child : tn.getChildren())
						children.add(child);
			}
			queue = children;
			System.out.println(levelString);
			
		}
		
	}
}
