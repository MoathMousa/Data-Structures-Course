import java.util.Scanner;

public class RadixSort {
	
	
	private static final int LENGTH=10;
	
	private static LinkedList[] r ={
			new LinkedList(),
			new LinkedList(),
			new LinkedList(),
			new LinkedList(),
			new LinkedList(),
			new LinkedList(),
			new LinkedList(),
			new LinkedList(),
			new LinkedList(),
			new LinkedList(),
	};

	public static void main(String[] args) {
		
		Scanner input=new Scanner(System.in);
		
		Object[] list=new Object[LENGTH];
		
		for(int i=0;i<LENGTH;i++){
			System.out.println("Enter a new number");
			list[i]=input.nextInt();
		}
		
//		Object[] sortedList=sort(list);
		
//		for(int i=0;i<LENGTH;i++)
//			System.out.println(sortedList[i]);
	}
}
/*	public static Object[] sort(Object[] a){
		int index=0;
		Node temp=first;
		while(index<){
			for(int i=0;i<LENGTH;i++){
				temp=a[i].element;
				while(temp!=null){
					a[getDigit(temp.element,index)].addLast(temp.element);
					temp=temp.next;
				}
			}
			
			index++;
		}
		return a;
	}
	
	public static int getDigit(int n,int index){
		return (int) ((n/Math.pow(n, index))%10);
	}
}*/
