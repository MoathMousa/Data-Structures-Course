package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Library {
	
	private static LinkList storage = new LinkList();
	
	public static Node getFirst(){
		return (Node) storage.getFirst();
	}

	public Library(){
		super();
	}
	
	public void load(File file) throws FileNotFoundException{
		
		Scanner input=new Scanner(file);
	
		while(input.hasNext()){
			String[]info=input.nextLine().split(":");
			storage.addLast(new Book(info[0],info[1],info[2],info[3],
					Double.parseDouble(info[4].trim()),Integer.parseInt(info[5].trim())));
		}	
	}
	
	public static void display(){
		Node current=(Node) storage.getFirst();
		while(current!=null){
			System.out.println(current.getElement().toString());
			current=current.next;
			}
	}
	
	public static boolean search(String s){
		Node current=(Node) storage.getFirst();
		while(current!=null){
			if((((Book)current.getElement()).getTitle()).toLowerCase().contains(s)
					|| (((Book)current.getElement()).getAuthor()).toLowerCase().contains(s)
					|| (((Book)current.getElement()).getAuthor()).contains(s)
					|| ((Book)current.getElement()).getTitle().contains(s))
				return true;
			current=current.next;
		}
		return false;
	}
	
	public static boolean sale(String title){
		if(storage.getCount()>=1){
			Node current=(Node) storage.getFirst();
			Node previous=null;
			while(current.next!=null && title.compareTo(((Book)(current.getElement())).getTitle())!=0){
				previous=current;
				current=current.next;
			}
			System.out.println(((Book)(previous.getElement())).getTitle());
			if(previous==null)
				return false;
			
			else {	
				if(previous==storage.getFirst() && (((Book)previous.getElement()).getQuantity())== 1){
					storage.removeFirst();
					return true;
				}
				else if(previous==storage.getFirst()){
					((Book)(previous.getElement())).setQuantity(((Book)(previous
							.getElement())).getQuantity() - 1);
					return true;
				}
			}
				if(((Book)previous.getElement()).getQuantity()==1){
					previous=current.next;
					current.next=current.next;
					storage.setCount(storage.getCount()-1);
					return true;
					}
				else{
					((Book)previous.getElement()).setQuantity(((Book)previous.getElement()).getQuantity()-1);
					return true;
					}
				}
		return false;
		
	}
	
	public  static void purchase(String author, String title, String edition, String publisher, double price,int quantity){
		Node current=(Node) storage.getFirst();
		Node previous = null;
		Node newNode;
		if(current==null)
			storage.addFirst(new Book(author, title, edition, publisher, price, quantity));
		else{
			while(current!=null){
				if(title.equals(((Book)(current).getElement()).getTitle())){
					((Book)(current).getElement()).setQuantity(((Book)(current).getElement()).getQuantity()+quantity);
					return;
					}
				else if(current.next==null)
					if(title.compareToIgnoreCase(((Book)(current).getElement()).getTitle())>=0){
						storage.addLast(new Book(author, title, edition, publisher, price, quantity));
						return;
						}
					else{
						storage.addFirst(new Book(author, title, edition, publisher, price, quantity));
						return;}
					
				else if(title.compareToIgnoreCase(((Book)(current).getElement()).getTitle())>=0&&
						title.compareToIgnoreCase(((Book)(current.next).getElement()).getTitle())<0){
					newNode=new Node(new Book(author, title, edition, publisher, price, quantity));
					newNode.next=current;
					previous.next=newNode;
					return;
					}
				previous=current;
				current=current.next;					
			}
		}
	}
	
	public static void report() throws FileNotFoundException{

		PrintWriter output = new PrintWriter("output.txt");
		Node current=(Node) storage.getFirst();
		while(current != null){
			output.println(current.toString());
			current=current.next;
		}
		output.close();
	}

	public String toString(){
		Node current=(Node) storage.getFirst();
		String result="";
		while(current != null){
			result += current.toString()+"\n";
			current=current.next;
		}
		return result;
	}

}
