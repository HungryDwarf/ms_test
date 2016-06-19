package ms_test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MS_Test {

	static ArrayList<Integer> array;
	static BufferedReader br;
	public static Graph graph;

	public static void main(String[] args) {

		readData(args[0]);

		graph = new Graph(array);

		System.out.println(graph.getResult());
	}

	/*
	 * Reads data from file Takes it to ArrayList<Integer> array
	 */
	private static void readData(String arg) {
		array = new ArrayList<>();
		String currentLine = null;
		int nullSymbol = 47; // in Unicode
		int nineSymbol = 57; // in Unicode

		try {
			br = new BufferedReader(new FileReader(arg));

			while ((currentLine = br.readLine()) != null) {
				for (char ch : currentLine.toCharArray()) {
					if(ch < nullSymbol || ch > nineSymbol){
						throw new Exception("Only numbers allowed");
					}
					if (ch != ' ') {
						int i = Character.getNumericValue(ch);
						array.add(i);
					}
				}
			}
			if (array.size() % 2 != 0) {
				throw new Exception("List of nodes is odd");
			}
		} catch (IOException e) {
			e.printStackTrace();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

}
