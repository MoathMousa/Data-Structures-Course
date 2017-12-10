
public class DoubleLL {
	
	private Node first;
	private Node last;
	int count=0;
	
	public DoubleLL(){
		
	}
	
	public void addFirst(Object x){
		if(count==0)
			first=last=new Node(x);
		else{
			Node temp = new Node(x);
			temp.next=first;
			first.previous=temp;
			first=temp;
		}
		count++;
	}
	
	public void addLast(Object x){
		if(count==0)
			first=last=new Node(x);
		else{
			Node temp=new Node(x);
			temp.previous=last;
			last.next=temp;
			last=last.next;
		}
		count++;
	}
	
	public boolean removeFirst(){
		if(count==0)
			return false;
		else{
			first=first.next;
			first.previous=null;
			count--;
			return true;
		}
	}
	
	public boolean removeLast(){
		if(count==0)
			return false;
		else{
			last=last.previous;
			last.next=null;
			count--;
			return true;
		}
	}
	
	public void add(Object x,int index){
		if(index==0)
			addFirst(x);
		else if(index>=count)
			addLast(x);
		else{
			Node temp= new Node(x);
			Node current=first;
			for(int i=0;i<index-1;i++)
				current=current.next;
			temp.next=current.next;
			current.next.previous=temp;
			current.next=temp;
			temp.previous=current;
			count++;
		}
	}
	
	public boolean remove(int index){
		if(index==0)
			removeFirst();
		else if(index>count)
			removeLast();
		else{
			Node current=first;
			for(int i=0;i<index;i++)
				current=current.next;
			current.previous.next=current.next;
			current.next.previous=current.previous;
			count--;
			return true;
		}
		return false;
	}
	
	public void display(){
		if(count==0)
			System.out.println("The list is empty");
		else{
		Node current=first;
		System.out.print("The list is:" );
		while(current != null){
			System.out.print(""+current.element+", ");
			current=current.next;
		}
		}
	}
	
/*	public static void main(String[] args) {
		DoubleLL l = new DoubleLL();
		l.addLast(5);
		l.addLast(8);
		l.addLast(10);
		l.addLast(11);
		l.addLast(12);
		l.add(9, 3);
		l.remove(2);
		l.removeFirst();
		l.removeLast();
		l.display();
	}*/

}
