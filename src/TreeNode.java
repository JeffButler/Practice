import java.util.LinkedList;


public class TreeNode {
	public LinkedList<TreeNode> children;
	public TreeNode parent;
	public Object data;
	
	public TreeNode(Object d){
		data = d;
	}
	
	public TreeNode(TreeNode p, Object d){
		parent = p;
		data = d;
	}
	
	public TreeNode(TreeNode p, Object d, LinkedList<TreeNode> c){
		parent =  p;
		data = d;
		children = c;
	}
	
	public LinkedList<TreeNode> getChildren(){
		return children;
	}
	
	public TreeNode getParent(){
		return parent;
	}
	
	public Object getData(){
		return data;
	}
	
	
}
