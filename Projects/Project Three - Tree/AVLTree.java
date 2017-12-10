

public class AVLTree {
	TreeNode root;

	public AVLTree() {
		super();
	}

	public int height(TreeNode P) {
		if (P == null)
			return -1;
		else
			return P.getHeight();
	}

	private int max(int a, int b) {
		return (a > b) ? a : b;
	}

	private int getBalance(TreeNode N) {
		if (N == null) {
			return 0;
		}
		return height(N.left) - height(N.right);
	}

	TreeNode minValueNode(TreeNode node) {
		TreeNode current = node;
		while (current.left != null) {
			current = current.left;
		}

		return current;
	}

	TreeNode maxValueNode(TreeNode node) {
		TreeNode current = node;
		while (current.right != null) {
			current = current.right;
		}

		return current;
	}

	public TreeNode search(String key) {
		return search(root, key);
	}

	private TreeNode search(TreeNode node, String key) {
		if (node == null)
			return null;

		if (key.compareToIgnoreCase(((Countries) node.getKey()).getCountryName()) > 0)
			return search(node.right, key);
		else if (key.compareToIgnoreCase(((Countries) node.getKey()).getCountryName()) < 0)
			return search(node.left, key);
		else
			return node;
	}

	private TreeNode rightRotate(TreeNode y) {
		TreeNode x = y.left;
		TreeNode T2 = x.right;

		// Perform rotation
		x.right = y;
		y.left = T2;

		// Update heights
		y.setHeight(max(height(y.left), height(y.right)) + 1);
		x.setHeight(max(height(x.left), height(x.right)) + 1);

		// Return new root
		return x;
	}

	private TreeNode leftRotate(TreeNode x) {
		TreeNode y = x.right;
		TreeNode T2 = y.left;

		// Perform rotation
		y.left = x;
		x.right = T2;

		// Update heights
		x.setHeight(max(height(x.left), height(x.right)) + 1);
		y.setHeight(max(height(y.left), height(y.right)) + 1);

		// Return new root
		return y;
	}

	public TreeNode insert(Object key) {
		return root = insert(root, (Countries) key);
	}

	private TreeNode insert(TreeNode node, Object key) {

		if (node == null) {
			return (new TreeNode(key));
		}

		if (((Countries) key).getCountryName()
				.compareToIgnoreCase(((Countries) (node.getKey())).getCountryName()) < 0) {
			node.left = insert(node.left, key);
		} else {
			node.right = insert(node.right, key);
		}

		node.setHeight(max(height(node.left), height(node.right)) + 1);

		int balance = getBalance(node);

		if (balance > 1 && ((Countries) key).getCountryName()
				.compareToIgnoreCase(((Countries) node.left.getKey()).getCountryName()) < 0) {
			return rightRotate(node);
		}

		// Right Right Case
		if (balance < -1 && ((Countries) key).getCountryName()
				.compareToIgnoreCase(((Countries) node.right.getKey()).getCountryName()) > 0) {
			return leftRotate(node);
		}

		// Left Right Case
		if (balance > 1 && ((Countries) key).getCountryName()
				.compareToIgnoreCase(((Countries) node.left.getKey()).getCountryName()) > 0) {
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}

		// Right Left Case
		if (balance < -1 && ((Countries) key).getCountryName()
				.compareToIgnoreCase(((Countries) node.right.getKey()).getCountryName()) < 0) {
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}

		return node;
	}

	public TreeNode deleteNode(String key) {
		return deleteNode(root, key);
	}

	private TreeNode deleteNode(TreeNode root, String key) {

		if (root == null) {
			return root;
		}

		if (key.compareTo(((Countries) root.getKey()).getCountryName()) < 0) {
			root.left = deleteNode(root.left, key);
		}

		else if (key.compareToIgnoreCase(((Countries) root.getKey()).getCountryName()) > 0) {
			root.right = deleteNode(root.right, key);
		}

		else {

			// node with only one child or no child
			if ((root.left == null) & (root.right == null)) {
				root = null;
				return root;
			}
			if ((root.left == null) || (root.right == null)) {
				TreeNode temp = null;
				if (temp == root.left) {
					temp = root.right;
				} else {
					temp = root.left;

				}
			} 
			else {

				// two children minvalue of the right or max value in the left
				TreeNode temp;
				if (root.right.left != null)
					temp = minValueNode(root.right);
				else
					temp = maxValueNode(root.left);

				root.setKey(((Countries) temp.getKey()));
				root.right = deleteNode(root.right, ((Countries) temp.getKey()).getCountryName());
			}
		}

		// If the tree had only one node then return
		if (root == null) {
			return root;
		}


		root.setHeight(max(height(root.left), height(root.right)) + 1);

		int balance = getBalance(root);


		// Left Left Case
		if (balance > 1 && getBalance(root.left) >= 0) {
			return rightRotate(root);
		}

		// Left Right Case
		if (balance > 1 && getBalance(root.left) < 0) {
			root.left = leftRotate(root.left);
			return rightRotate(root);
		}

		// Right Right Case
		if (balance < -1 && getBalance(root.right) <= 0) {
			return leftRotate(root);
		}

		// Right Left Case
		if (balance < -1 && getBalance(root.right) > 0) {
			root.right = rightRotate(root.right);
			return leftRotate(root);
		}

		return root;
	}

	void preOrder(TreeNode node) {
		if (node == null)
			return;
		else {
			preOrder(node.left);
			System.out.print(node.getKey().toString() + "  ");
			preOrder(node.right);
		}
	}

}
