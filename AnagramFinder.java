import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AnagramFinder {
	private ArrayList<String> words;
	
	public AnagramFinder(String filename, String word) 
			throws FileNotFoundException {
		File file = new File(filename);
		if (!file.exists()) {
			throw new FileNotFoundException();
		}
		Scanner sfile = new Scanner(file);
		words = new ArrayList<String>();
		while (sfile.hasNextLine()) {
			words.add(sfile.nextLine());
		}
	}
	
	public static void generatePermutations(String s) {
		generatePermutations(s, " ");
	}
	
	private static void generatePermutations(String s1, String s2) {
		if (s1.equals(" ")) {
			System.out.println(s2);
		}
		for (int i = 0; i < s1.length(); i++) {
			char leadingChar = s1.charAt(i);
			StringBuilder sb = new StringBuilder(s1);
			System.out.println(sb.toString());
			sb.deleteCharAt(i);
			String s3 = leadingChar + " ";
		}
	}
	
	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("Usage: java AnagramFinder <dictionary file> <word>");
			System.exit(1);
		}
		String filename = args[0];
		String word = args[1];
		try {
			AnagramFinder af = new AnagramFinder(filename, word);
			
		} catch (FileNotFoundException fnfe) {
			System.err.println("Error: Cannot open dictionary file '" + filename + "' for input.");
			System.exit(1);
		}
	}

}
