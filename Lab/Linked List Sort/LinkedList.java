
public class LinkedList {
	
	private Node first;
	private Node last;
	private int count=0;
	
	public LinkedList(){
		
	}
	
	public Object GetFirst(){
		if(count==0)
			return null;
		else
			return first.element;
	}
	
	public Object getLast(){
		if(count==0)
			return null;
		else
			return last.element;
	}
	
	public void addFirst(Object x){
		if(count==0)
			first=last=new Node(x);
		else{
			Node newNode = new Node(x);
			newNode.next=first;
			first=newNode;
		}
		count++;
	}
	
	public void addLast(Object x){
		if(count==0)
			first=last=new Node(x);
		else{
			last.next=new Node(x);
			last=last.next;
			last.next=null;
		}
		count++;
	}
	public void add(Object x, int index) {  
		if (index >= count)
			addLast(x); 
		else if (index == 0)
			addFirst(x); 
		else { 
			Node current = first; 
			for (int i = 1; i < index; i++)
				current = current.next; 
			Node temp = current.next;
			current.next = new Node(x);
			current.next.next = temp;
			count++; 
			} 
		}	 
		 
		public boolean removeFirst() {
			if (count == 0)
				return false;
			first = first.next;
			count--;
			return true;
		}
		
		public boolean removeLast() { 
			if (count == 0)
				return false; 
			Node current = first;
			for (int i = 1; i < count - 1; i++)
				current = current.next;
			current.next = null;
			last = current; 
			count--;
			return true; 
		}
		 
		public boolean remove(int index) { 
			if (count == 0)
				return false;
			if (index == 0)
				return removeFirst();
			if (index == count - 1)
				return removeLast();
			Node current = first; 
			for (int i = 1; i < index; i++)
				current = current.next; 
			current.next = current.next.next; 
			count--;
			return true; 
		}
		 
	 public boolean remove(Object x) { 
		if (count == 0)
			return false; 
		Node current = first;
		Node prevCurrent = null;
		while (current.next != null && !x.equals(current.element)) {
			prevCurrent = current;
			current = current.next;
		 }
		if (current.next == null)
			return false;
			prevCurrent.next = prevCurrent.next.next; 
			count--;
			return true; 
		}
		  
		public void displayData() { 
			if (count == 0)
				System.out.print("List is Empty");
			else {
				System.out.print("Count = " + count + ", List (First to Last): ");
				Node current = first;
				System.out.print(current);
				current = current.next;
				while (current != null) {
					System.out.print(", " + current);
					current = current.next; 
				} 
			} 
		}
}
