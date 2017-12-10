package application;

public class Node {//node class
	
	Object element;
	int next;
	
	public Node(String x,int i){
		setElement(x);
		next=i;
	}

	public Object getElement(){
		return element;
	}
	
	public void setElement(Object x){
		element=x;
	}
}
