

public class LinkedListSL<T>{
		Node head;
		public LinkedListSL(){
			head = null;
		}
	
		public LinkedListSL(T data){
			head = new Node(data);
		}
	
		public LinkedListSL(Node n){
			head = n;
		}
		
		public void add(T data){
			Node n = null;
			if (!(data instanceof Node))
				n = new Node(data);
			else 
				n = (Node)data;
			Node temp = head;
			head = n;
			n.next = temp;
			
		}
		
		public void addTail(T data){
			Node n;
			if (!(data instanceof Node))
			    n = new Node(data);
			else 
				n = (Node) data;
			Node currentNode = head;
			if (currentNode == null){
				head = n;
				return;
			}
			while (currentNode.next != null){
				currentNode = currentNode.next;
			}
			currentNode.next = n;

		}
		
		public Node removeHead(){
			Node n = null;
			if (head != null){
				head = head.next;
				n = head;
			}
			return n;
		}
		public boolean remove(T n){
			boolean returnV = false;
			Node previousNode = null;
			Node currentNode = head;
			if (currentNode != null){
				while (currentNode != null && currentNode.data != n){
					previousNode = currentNode;
					currentNode = currentNode.next;
				}
				
				if (currentNode != null){
					//edge case for if the first node is the one we want to eliminate
					if (previousNode == null)
						head = currentNode.next;
					else 
						previousNode.next = currentNode.next;
					returnV = true;
				}
			}  
			return returnV;
		}
		//insert node in a singly linked at index i
		public void insert(int index, T data){
			Node n = new Node(data);
			Node currentNode = head;
			Node previousNode = null;
			int currentIndex = 0;
			if (index < 0)
				return;
			while (currentIndex < index && currentNode != null){
				previousNode = currentNode;
				currentNode = currentNode.next;
				currentIndex++;
			}
			
			if (currentNode == null)
				return;
			
			previousNode.next = n;
			n.next = currentNode;
		}
		
		public void printAll(){
			Node currentNode = head;
			String returnString = "";
			while (currentNode != null){
				returnString += currentNode.data + ",";
				currentNode = currentNode.next;
			}
			if (returnString.length() > 0)
				System.out.println("LinkedList Inventory = " + returnString.substring(0, returnString.length() - 1));
			else 
				System.out.println("LinkedList Inventory is Empty");
		}
		
	}


