
public class LinkedList {

	static int size =10;
	static Node[] cursor=new Node[size];

	static{
		for(int i=0;i<size;i++)
			cursor[i]=new Node(null,i+1);
		cursor[cursor.length-1].next=0;
	}

	public static int newNode(){
		int p=cursor[0].next;
		if(cursor[0].next==0)
			return 0;
		cursor[0].next=cursor[p].next;
		cursor[p].next=0;
		return p;
	}

	public static void freeNode(int p){
		cursor[p].next=cursor[0].next;
		cursor[0].next=p;
	}

	public static boolean isLast(int l,int p){
		return (cursor[p].next==0);
	}

	public static boolean isEmpty(int l){
		return (cursor[l].next==0);
	}

	public static void insertFirst(int l,Object x){
		int temp=newNode();
		if(temp!=0){
		cursor[temp].element=x;
		cursor[temp].next=cursor[l].next;
		cursor[l].next=temp;
		}
	}

	public static boolean removeFirst(int l){
		if(isEmpty(l)==true)
			return false;
		else{
			int p=cursor[l].next;
			cursor[l].next=cursor[p].next;
			freeNode(p);
			return true;
		}
	}

	public static void insertLast(int l,Object x){
		int current=cursor[l].next;
		if(isEmpty(l))
			insertFirst(l, x);
		while(cursor[current].next!=0)
			current=cursor[current].next;
		int temp=newNode();
		cursor[temp].element=x;
		cursor[current].next=temp;
		}


	public static boolean deletePosition(int l,int p){
		int current=cursor[l].next;
		int counter=1;
		while(current!=0 && counter<p-1){
			current=cursor[current].next;
			counter++;
		}
		if(current!=0){
			int temp=cursor[current].next;
			cursor[current].next=cursor[temp].next;
			freeNode(temp);
			return true;
		}
			return false;
	}


	public static boolean deleteObject(int l,Object x){
		if (isEmpty(l))
			return false;
		if (cursor[cursor[l].next].element.equals(x))
			return removeFirst(l);
		int prev = l;
		l = cursor[l].next;
		while (l != 0) {
		if (cursor[l].element.equals(x)) {
			cursor[prev].next = cursor[l].next;
			freeNode(l);
			return true;
		}
		prev = l;
		l = cursor[l].next;
		}
		return true;
	}

	public static void print(int l){

		int p=cursor[l].next;
		while(p!=0){

			System.out.println(cursor[p].element);
			p=cursor[p].next;
		}
	}
}
