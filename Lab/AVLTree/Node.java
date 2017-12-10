
public class Node {
	
	int element;
	Node left,right;
	int height;
	
	public Node(int x){
		element = x;
		height = 0;
	}

	
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	


}
