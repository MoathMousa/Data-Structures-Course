package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Library {
	
	private static LinkList storage = new LinkList();

	
	public static Node getFirst(){
		return storage.getFirst();
	}

	public Library(){
		super();
	}
	
	public void load(File file) throws FileNotFoundException{//read data from the file
		
		Scanner input=new Scanner(file);
		
		while(input.hasNext()){
			String[]info=input.nextLine().split(":");//split by :
			storage.addLast(new Book(info[0],info[1],info[2],info[3],
					Double.parseDouble(info[4].trim()),Integer.parseInt(info[5].trim())));//to take the real value 
		}	
	}
	
	
	public static String display(){//to display //secondary
		Node current = storage.getFirst();
		while(current !=null)
			return current.toString();
		current=current.next;
		return null;
	}
	
	public static boolean search(String s){//search by title or author
		Node current=(Node) storage.getFirst();
		while(current!=null){
			if((((Book)current.getElement()).getTitle()).toLowerCase().contains(s)// to avoids errors
					|| (((Book)current.getElement()).getAuthor()).toLowerCase().contains(s)
					|| (((Book)current.getElement()).getAuthor()).contains(s)
					|| ((Book)current.getElement()).getTitle().contains(s))
				return true;
			current=current.next;
		}
		return false;
	}
	
	public static boolean sale(String title) {//sale by exactly title
		Node current = storage.getFirst();
		Node previous = null;
		if (current == null)
			return false;

		while (current != null && !title.equalsIgnoreCase(((Book) (current.getElement())).getTitle())) {//to reach to its exactly position
			previous = current;
			current = current.next;
		}
		if (current == null)
			return false;
		else {
			if (current == storage.getFirst() && ((Book) (current.getElement())).getQuantity() <= 1) {
				storage.removeFirst();//first// quantity = 1
				return true;
			} else if (current == storage.getFirst()) {
				((Book) (current.getElement())).setQuantity(((Book) (current.getElement())).getQuantity() - 1);
				return true;//first// quantity != 1
			}
			if (((Book) (current.getElement())).getQuantity() <= 1) {
				previous.next = current.next;//not first// quantity = 1
				current.next = null;
				return true;
			} else {
				((Book) (current.getElement())).setQuantity(((Book) (current.getElement())).getQuantity() - 1);
				return true;//not first// quantity = 1
			}
		}
	}
	public  static void purchase(String author, String title, String edition, String publisher, double price,int quantity){
		Node current=(Node) storage.getFirst();//to add books by full information
		Node previous = null;
		Node newNode;
		if(current==null)//to add sorted//if the library is empty
			storage.addFirst(new Book(author, title, edition, publisher, price, quantity));
		else{//other cases
			while(current!=null){
				if(title.equals(((Book)(current).getElement()).getTitle())){
					((Book)(current).getElement()).setQuantity(((Book)(current).getElement()).getQuantity()+quantity);
					return;//add one to quantity
					}
				else if(current.next==null)
					if(title.compareToIgnoreCase(((Book)(current).getElement()).getTitle())>=0){
						storage.addLast(new Book(author, title, edition, publisher, price, quantity));
						return;//add new book//if last
						}
					else{
						storage.addFirst(new Book(author, title, edition, publisher, price, quantity));
						return;}//add new book //if first
					
				else if(title.compareToIgnoreCase(((Book)(current).getElement()).getTitle())>=0&&
						title.compareToIgnoreCase(((Book)(current.next).getElement()).getTitle())<0){
					newNode=new Node(new Book(author, title, edition, publisher, price, quantity));
					newNode.next=current;
					previous.next=newNode;
					return;//add new book //between other books
					}
				previous=current;
				current=current.next;					
			}
		}
	}
	
	public static void report(File file) throws FileNotFoundException{
		//to write on the file
		PrintWriter output = new PrintWriter(file);
		file=null;
		Node current = (Node) storage.getFirst();

		while(current != null){
			output.println(current.toString());
			current=current.next;
		}
		output.close();
	}

	public String toString(){//to string method
		Node current=(Node) storage.getFirst();
		String result="";
		while(current != null){
			result += current.toString()+"\n";
			current=current.next;
		}
		return result;
	}

}
