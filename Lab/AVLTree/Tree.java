
public class Tree {
	
	Node root;
	
	public Tree(){
		
	}
	
	public int calculateHeight(Node t){
		if(t == null)
			return -1;
		return t.height;
	}

	
	public Node sRLR(Node y){
		Node x = y.left;
		y.left = x.right;
		x.right=y;
		y.height = Math.max(calculateHeight(y.left),calculateHeight(y.right))+1;
		x.height = Math.max(calculateHeight(x.left),calculateHeight(x.right))+1;
		return x;
	}
	
	public Node sRRL(Node y){
		Node x = y.right;
		y.right = x.left;
		x.left=y;
		y.height = Math.max(calculateHeight(y.left),calculateHeight(y.right))+1;
		x.height = Math.max(calculateHeight(x.left),calculateHeight(x.right))+1;
		return x;
	}
	
	public Node dRLR(Node y){
		y.left = sRRL(y.left);
		return sRLR(y);
	}
	
	public Node dRRL(Node y){
		y.right = sRRL(y.right);
		return sRRL(y);
	}
	
	
	public Node insert(Node t,int x){
		
		if(t == null){
			t = new Node(x);
			
		}
		else{
			if(t.element > x){
				t.left = insert(t.left, x);
				if((calculateHeight(t.left) - calculateHeight(t.right))==2)
					{
						if(t.left.element > x)
							t = sRLR(t);
						else
							t = dRLR(t);
					}
			}
			else {
					t.right = insert(t.right, x);
					if((calculateHeight(t.right) - calculateHeight(t.left))==2)
					{
						if(t.right.element > x)
							t = sRRL(t);
						else
							t = dRRL(t);
					}
				}
			}
		t.height = Math.max(calculateHeight(t.left), calculateHeight(t.right)) + 1;
		return t;
	}
	
	public void inOrder(Node t){
		if(t != null) {
			inOrder(t.left);
			System.out.println(t.element + " " + t.height);
			inOrder(t.right);
		}
	}
	
	
}
