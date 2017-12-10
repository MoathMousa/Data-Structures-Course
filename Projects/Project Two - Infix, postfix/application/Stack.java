package application;

public class Stack {//to set stack and its methods
	
	private LinkList stack;
	int l;
	
	public Stack(int size){
		stack = new LinkList(size);
		l = stack.alloc();
	}
	
	public void push(Object x){
		LinkList.insertFirst(l, x);
	}
	
	public void pop(){
		LinkList.removeFirst(l);
	}
	
	public Object top(){
		return LinkList.getFirst(l);
	}

	public boolean isEmpty(){
		return stack.isEmpty(l);
	}
}
