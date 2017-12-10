
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class TreeThing {
	
	AVLTree countryTree = new AVLTree();
	ArrayList<Countries> countryList = new ArrayList<>();

	// method that load from country file and save it in the array list and
	// return it

	public ArrayList<Countries> load(File file) throws Exception {
		
		Scanner input = new Scanner(file);
		
		String[] l;
		while (input.hasNextLine()) {
			l = input.nextLine().split("/");
			countryTree.insert(new Countries(l[0].trim(), l[1].trim()));
			countryList.add(new Countries(l[0].trim(), l[1].trim()));
		}
		return countryList;
	}

	// method that save the new tree data into the new file
	public void update(ArrayList<Countries> list) throws Exception {
		PrintWriter output = new PrintWriter(new File("update.txt"));

		for (int i = 0; i < list.size(); i++) {
			output.println(list.get(i).toString());

		}
		output.close();
	}

	public void insert(String name) throws Exception {
		File newFile = new File(name + ".txt");
		if (newFile.createNewFile())
			countryTree.insert(new Countries(name, name + ".txt"));
	}

	public void delete(String name) {
		countryTree.deleteNode(name);
	}

	public TreeNode search(String name) {
		return countryTree.search(name);
	}
}
