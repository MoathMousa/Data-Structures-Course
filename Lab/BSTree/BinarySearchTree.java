
public class BinarySearchTree implements Comparable<Object>{
	
	 Node root;
	
	public BinarySearchTree() {
		
	}
	
	public Node find(Node t,Object x){
		if(t==null)
			return null;
		else{
			if(x.<t.element)
				return (find(t.left,x));
			else if (x > t.element);
			else
				return t;
		}
	}
	
	public Node findMin(Node t){
		if(t == null)
			return null;
		else if(t.left != null)
			return findMin(t.left);
		else
			return t;
	}
	
	public Node findMax(){
		Node t=root;
		if(t == null)
			return null;
		while(t.right != null)
			t=t.right;
		return t;
	}

	public Node insert(Node t,Object x){
		
		if(t==null){
			t = new Node(x);
			t.left=t.right=null;
		}
		else if((x < root.element)
			t.left=insert(t.left,x);
		else
			t.right=insert(t.right,x);
		return t;
	}
	
	Node delete(Node t,Object x){
		if(t==null)
			return null;
		else if(x.t.element)
			t.left=delete(t.left,x);
		else if (x > t.element)
			t.right=delete(t.right,x);
		else{
			if(t.left != null && t.right != null){
				Node temp = findMin(t.right);
				t.element = temp.element;
				t.right = delete(t.right,temp.element);
			}
			else{
				Node child;
				if(t.left == null)
					child=t.right;
				if(t.right == null)
					child = t.left;
				return child;
			}
		}
		return t;
	}

	@Override
	public int compareTo(Object x) {
		return 0;
	}
	
}
