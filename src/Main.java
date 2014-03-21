/*
John Bingley.
Threading Homework.
*/

public class Main {

	public static void main(String[] args) throws Exception {
		
		// Create 100 threads to test
		// ReadFile(FILENAME, THREADNUMBER)
		
		for (int i = 1; i < 101; i++){
			Runnable r = new ReadFile("file1.txt", i);
			Thread t = new Thread(r);
			t.start();
		}
	}
}
