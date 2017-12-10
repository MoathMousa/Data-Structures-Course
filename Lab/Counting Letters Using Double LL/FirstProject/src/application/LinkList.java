package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
public class LinkList {
	
	private Node first;
	private Node last;
	private int count=0;
	
	public LinkList(){
		
	}
	
	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	public Object getFirst(){
		if(count==0)
			return null;
		else
			return first.getElement();
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
			last.next=new Node(x);;
			last=last.next;
			last.next=null;
		}
		count++;
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
	
	public String toString(){
		Node current=first;
		String result="";
		while(current != null){
			result += current.toString()+"\n";
			current=current.next;
		}
		return result;
	}
}
	
