import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ReadFile implements Runnable {

	private int threadNum = 0;
	private int wordCount = 0;
	private String ReadFile = null;

	// @param inFile file to have words counted
	public ReadFile(String inFile, int inThreadnum) throws Exception {
		ReadFile = inFile;
		threadNum = inThreadnum;
	}

	public void run() {
		try {
			File file = new File(ReadFile);
			Scanner s = new Scanner(new FileInputStream(file));
			while(s.hasNextLine()){
			String line = s.nextLine();	
			    wordCount += new StringTokenizer(line, " ").countTokens();
			    //show count .. prove threading is working.
			    System.out.println("Current word count on thread #" + threadNum + " - " + wordCount);
			}
		    System.out.println("Final word count on thread #" + threadNum + " - " + wordCount);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
