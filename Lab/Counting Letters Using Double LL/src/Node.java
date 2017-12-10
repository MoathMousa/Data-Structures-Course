
public class Node {
	
	Object data;
	Node previous;
	Node next;
	
	public Node(Object x){
		data = x;
	}
	
	public String toString() {		
		return "" + data;	
	}
	
}