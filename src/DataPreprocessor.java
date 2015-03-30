import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class DataPreprocessor {

	static int MAX = 100000000;

	public static void main(String[] args) {

		// storeCounts();

		try {
			parseCSV();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void parseCSV() throws IOException {

		HashMap<Long, Long> map = new HashMap<Long, Long>();

		int[] array = new int[MAX];

		Scanner scanner = new Scanner(new File(
		//		"/home/jthiru/workspace/practice-java/src/practice"));
		 "/home/jthiru/Downloads/Friendster.csv"));

		String s;
		String[] vals;
		int val1, val2;

		while (scanner.hasNextLine()) {
			s = scanner.nextLine();
			vals = s.split(",");

			val1 = Integer.valueOf(vals[0]);
			val2 = Integer.valueOf(vals[1]);

			if (array[val1] != 0) {
				array[val1] += 1;
			} else {
				array[val1] = 1;
			}
		}

		scanner.close();

		FileWriter writer = new FileWriter("/home/jthiru/Downloads/WriteAFile.csv");

		for (int i = 0; i < MAX; i++) {
			if (array[i] != 0) {				
				writer.write(Long.valueOf(i) + "," + Long.valueOf(array[i])
						+ System.getProperty("line.separator"));
			}

		}
		writer.close();

		// System.out.println(map.toString());

	}

	public static void storeCounts() {

		int MAX = 100000000; // 1620991 //10000000
		int MAX2 = 100;
		int[] array = new int[MAX2];
		int[] test = { 1, 2, 3, 4, 5, 6, 7, 1, 1, 1, 1, 1, 12, 2, 2, 3, 3, 3,
				5, 1 };

		for (int i = 0; i < test.length; i++) {
			if (array[test[i]] != 0) {
				array[test[i]] += 1;
			} else
				array[test[i]] = 1;
		}
		for (int i = 0; i < 10; i++) {
			System.out.println(i + "---" + array[i]);
		}

	}

}
