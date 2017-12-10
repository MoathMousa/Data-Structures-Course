import java.util.LinkedList;

public class Driver {
	public static void main(String[] args) {
		String paragraph = "Everything LaTeX numbers for you has a counter associated with it."
				+ " The name of the counter is the same as the name of the environment or command that produces the number,"
				+ " except with no. "
				+ "Below is alist of some of the counters used in LaTeX's standard document styles to control numbering.";
		String[] words = paragraph.split(" ");
		LinkedList<DoubleLL> mainList = new LinkedList<>();
		boolean foundLength;
		for (int i = 0; i < words.length; i++) {
			foundLength = false;
			for (int j = 0; j < mainList.size(); j++)
				if (mainList.get(j).wordLength == words[i].length()) {
					mainList.get(j).addLast(words[i]);
					foundLength = true;
					break;
				}

			if (!foundLength) {
				mainList.add(new DoubleLL());
				mainList.get(mainList.size() - 1).wordLength = words[i].length();
			}
		}
		for (int i = 0; i < mainList.size() - 2; i++)
				System.out.println(mainList.get(i));
				
	}
}