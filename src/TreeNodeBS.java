
public class TreeNodeBS<T> extends TreeNode{
	public TreeNodeBS<T> leftChild;
	public TreeNodeBS<T> rightChild;
	public TreeNodeBS<T> parent;
	public T data;
	
	public TreeNodeBS(T d) {
		super(d);
	}
	
	public TreeNodeBS(T d, TreeNodeBS<T> p){
		super(d);
		parent = p;
	}
	
	public TreeNodeBS(T d, TreeNodeBS<T> p, TreeNodeBS<T> l, TreeNodeBS<T> r){
		super(d);
		parent = p;
		leftChild = l;
		rightChild = r;
	}
	
	public TreeNodeBS(T d, TreeNodeBS<T> l, TreeNodeBS<T> r){
		super(d);
		leftChild = l;
		rightChild = r;
	}
	
	public TreeNodeBS<T> getRightChild(){
		return rightChild;
	}
	
	public TreeNodeBS<T> getLeftChild(){
		return leftChild;
	}

}
