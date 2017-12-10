package application;

public class LinkList {//to build the cursor
	
	static Node cursor[];
	
	public  LinkList(int length){//to initialize new nodes and set nexts
		cursor=new Node[length];
		for (int i = 0; i < length; i++) {
			cursor[i]=new Node(null, i+1);
		}
	}
	
	public static int alloc(){
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
	
	public static Object getFirst(int l){
		return cursor[cursor[l].next].getElement();
	}
	
	public static void insertFirst(int l,Object x){
		int temp=alloc();
		if(temp!=0){
		cursor[temp].element=x;
		cursor[temp].next=cursor[l].next;
		cursor[l].next=temp;
		}
	}
	
	public static void insertLast(int l,Object x){
		int current=cursor[l].next;
		if(isEmpty(l))
			insertFirst(l, x);
		while(cursor[current].next!=0)
			current=cursor[current].next;
		int temp=alloc();
		cursor[temp].element=x;
		cursor[current].next=temp;
		}
	
	public static boolean removeFirst(int l){
		if(isEmpty(l))
			return false;
		else{
			int p=cursor[l].next;
			cursor[l].next=cursor[p].next;
			freeNode(p);
			return true;
		}
	}
	
	public static void print(int l){
		int p=cursor[l].next;
		while(p!=0){
			System.out.println(cursor[p].element+" ");
			p=cursor[p].next;
		}
	}
	
	public static boolean remove(int l,Object x){
		if (isEmpty(l))
			return false;
		if (cursor[cursor[l].next].element.equals(x))
			return removeFirst(l);
		int previous = l;
		l = cursor[l].next;
		while (l != 0) {
			if (cursor[l].element.equals(x)) {
				cursor[previous].next = cursor[l].next;
				freeNode(l);
				return true;
			}
			previous = l;
			l = cursor[l].next;
		}
		return false;
	}
	
	public static int printIndex(int index){
		return (int) cursor[index].element;
	}
	
	public static void add(int l,int index,Object x){
		int p =alloc();
		cursor[p].element=x;
		int current=cursor[l].next;
		for(int i=1 ;i<index && cursor[i].next!=0 ;i++){
			 current=cursor[current].next;
		}
		cursor[p].next=cursor[current].next;
		cursor[current].next=p;
	}

	public static int Compare(Object o1,Object o2){
		int x=((String)o1).compareToIgnoreCase((String)o2);
		return x;
	}

}
