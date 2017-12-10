
public class Driver {

	public static void main(String[] args) {

		int l1, l2=0, l3=0;
		l1=LinkedList.newNode();
		l2=LinkedList.newNode();
		l3=LinkedList.newNode();
//		System.out.println(LinkedList.newNode());

//		System.out.println(LinkedList.isEmpty(l1));
		LinkedList.insertLast(l1, 3);
		LinkedList.insertLast(l1, 6);
		LinkedList.insertLast(l1, 9);
		LinkedList.print(l1);
		LinkedList.deleteObject(l1, 6);
		LinkedList.print(l1);

	}

}
