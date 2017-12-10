
public class TreeNode {
	
	private Object Key;

	private int height;
	TreeNode left, right;

	public TreeNode(Object data) {
		this.height = 1;
		this.Key = data;
	}

	public Object getKey() {
		return Key;
	}

	public void setKey(Object key) {
		this.Key = key;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	public String toString(){
		return ((Countries)Key).toString();
	}

}
