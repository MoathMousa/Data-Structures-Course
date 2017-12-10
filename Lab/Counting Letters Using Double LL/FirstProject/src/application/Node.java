package application;

public class Node {

	private Object element;
	Node next;
	
	
	public Object getElement() {
		return element;
	}

	public void setElement(Object element) {
		this.element = element;
	}


	public Node(Object x){
		setElement(x);
	}
	
	public String toString(){
		return ((Book)element).toString();
	}

}
