
public class Driver {
	
	public static void main(String[] args) {
		
		Tree tree = new Tree();
		
		tree.root = tree.insert(tree.root, 80);
		tree.root = tree.insert(tree.root, 70);
		tree.root = tree.insert(tree.root, 60);
		tree.root = tree.insert(tree.root, 50);
		tree.root = tree.insert(tree.root, 40);
		tree.root = tree.insert(tree.root, 30);
		tree.root = tree.insert(tree.root, 20);
		tree.root = tree.insert(tree.root, 10);
		tree.inOrder(tree.root);
//		tree.print();

	}

}
