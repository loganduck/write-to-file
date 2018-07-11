import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class CreateAndWriteToFile {
	static final String FILE_NAME = "example.txt"; 
	static final String FILE_PATH = "/Users/LoganDuck/Desktop/";
	static final File FILE = new File(FILE_PATH + FILE_NAME);
	
	private static PrintWriter writer;

	public static void main(String[] args) {
		if (checkForFile()) {
			System.out.println("Error: File already exists. Program ending...");
			System.exit(1);
		}
		
		try {
			writer = new PrintWriter(FILE);
			FILE.createNewFile();
			System.out.println("File successfully created.");
		} catch(IOException e) {
			e.printStackTrace();
		}
		writer.println("This text will show in example.txt");
		writer.close();
		System.out.println("Write to file complete. Open 'example.txt' from Desktop.");
	}
	
	public static boolean checkForFile() {
		File filesOnDesktop = new File(FILE_PATH);
		File[] files = filesOnDesktop.listFiles();
		for (File f : files) {
			if (f.getName().equals(FILE.getName())) return true;
		}
		
		return false;
	}
}