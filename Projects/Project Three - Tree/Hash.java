import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Hash {
	private HashNode[] hashTable;
	private int size = 0;

	public Hash(int size) {
		findTabelSize(size);
		for (int i = 0; i < hashTable.length; i++) {
			hashTable[i] = new HashNode(null, -1);
		}
		System.out.println(hashTable.length);

	}

	private void findTabelSize(int size) {
		int temp = size * 2 + 1;
		while (true) {
			int i = 2;
			for (; i < temp / 2; i++) {
				if (temp % i == 0)
					break;

			}
			if (i >= temp / 2) {
				this.hashTable = new HashNode[temp];
				break;
			} else
				temp++;
		}

	}

	public void insert(Object p) {

		size++;
		if (size == this.hashTable.length / 2)
			reHashing();
		String s = ((Person) p).getName();
		long val = 0;
		for (int j = 0; j < s.length(); j++) {
			val += (val >> 5) + ((int) s.charAt(j));

		}
		int w = (int) (val) % hashTable.length;
		int i = 0;
		while (hashTable[w].getFlag() > 0) {
			i++;
			w = (int) ((val + i * i) % hashTable.length);

		}
		hashTable[w].setData(p);
		hashTable[w].setInServ();

	}

	@Override
	public String toString() {
		String str = null;
		for (int i = 0; i < hashTable.length; i++)
			str += hashTable[i].getData() + "\n";

		return str;
	}

	public boolean check(int i) {
		return hashTable[i].getFlag() == 1;
	}

	public Person getDataInHash(int i) {
		return (Person) hashTable[i].getData();
	}

	private void reHashing() {
		HashNode[] pretabel = hashTable;
		findTabelSize(pretabel.length);
		for (int i = 0; i < hashTable.length; i++) {
			hashTable[i] = new HashNode(null, -1);
		}
		for (int i = 0; i < pretabel.length; i++) {
			if (pretabel[i].getData() != null)
				this.insert(pretabel[i].getData());

		}

	}
//
//	public ObservableList display() {
//		ObservableList ol = FXCollections.observableArrayList();
//		for (int i = 0; i < hashTable.length; i++) {
//			if (hashTable[i].getData() != null)
//				ol.add(((Person) (hashTable[i].getData())).toString() + "\t\t" + i + "\t\t" + hashTable[i].getFlag()
//						+ "\n");
//			else {
//				ol.add(null + "\t\t" + i + "\t\t" + hashTable[i].getFlag() + "\n");
//
//			}
//		}
//		return ol;
//	}

	public Object find(String key) {

		long val = 0;
		for (int j = 0; j < key.length(); j++) {
			val += (val >> 5) + ((int) key.charAt(j));

		}
		int w = (int) (val) % hashTable.length;
		int i = 0;

		while (hashTable[w].getFlag() >= 0
				&& ((Person) hashTable[w].getData()).getName().compareToIgnoreCase(key) != 0) {
			i++;
			w = (int) ((val + i * i) % hashTable.length);
		}
		if (((Person) hashTable[w].getData()).getName().compareToIgnoreCase(key) == 0)
			return hashTable[w].getData();
		return null;

	}

	public void remove(String key) {

		long val = 0;
		for (int j = 0; j < key.length(); j++) {
			val += (val >> 5) + ((int) key.charAt(j));

		}
		int w = (int) (val) % hashTable.length;
		int i = 0;

		while (hashTable[w].getFlag() >= 0
				&& ((Person) hashTable[w].getData()).getName().compareToIgnoreCase(key) != 0) {
			i++;
			w = (int) ((val + i * i) % hashTable.length);
		}
		if (((Person) hashTable[w].getData()).getName().compareToIgnoreCase(key) == 0)
			hashTable[w].setOut();
		;

	}

	public int getTabelSize() {
		return hashTable.length;
	}

	public Object getElement(int i) {
		return hashTable[i].getData();

	}

	public void save(File out) {
		try {
			PrintWriter pw = new PrintWriter(out);
			for (int i = 0; i < hashTable.length; i++) {
				if (hashTable[i].getFlag() == 1) {
					pw.println(((Person) hashTable[i].getData()).toString());
				}

			}
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

