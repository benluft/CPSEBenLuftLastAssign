import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Reads an input file that contains string separated by a newline character.  The fields in this class
 * are the words read, and the number of words read.
 * 
 * @author Ben Luft
 *
 */
public class FileReading {
	
	/**
	 * An array containing all the strings read from the file
	 */
	private String[] wordList;
	
	/**
	 * The number of elements in the wordList array
	 */
	private int listLength;

	/**
	 * Gets the list of data
	 * 
	 * @return string array of data
	 */
	public String[] getWordList() {
		return wordList;
	}
	

	/**
	 * Finds the length of the list
	 * 
	 * @return length of list
	 */
	public int getListLength()
	{
		return listLength;
	}
	
	/**
	 * first finds the length of the file, then fills an array with the data
	 * in the file
	 * 
	 * @param filename file to be read from
	 */
	public FileReading(String filename)
	{
		findFileLength(filename);
		fillWordList(filename);
	}
	
	/**
	 * Determines the number of lines in a file
	 * 
	 * @param filename file to be read from
	 */
	private void findFileLength(String filename)
	{
		listLength = 0;
		try {
			FileReader fileReader = new FileReader(filename);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			String Line = bufferedReader.readLine();
			
			while(Line != null)
			{
				listLength++;
				Line = bufferedReader.readLine();
			}
			
			bufferedReader.close();
			fileReader.close();
		}
		catch(FileNotFoundException ex)
		{
			System.out.println("Input file cannot be opened");
			System.exit(0);
		}
		catch(IOException e)
		{
			System.out.println("Error reading Items file");
			System.exit(0);
		}
	}
	
	/**
	 * Makes an array of strings with each string containing a line from the file
	 * 
	 * @param filename file to read from
	 */
	private void fillWordList(String filename)
	{
		wordList = new String[listLength];
		
		try {
			FileReader fileReader = new FileReader(filename);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			String Line = bufferedReader.readLine();
			
			for(int i = 0; i < listLength; i++)
			{
				wordList[i] = Line;
				Line = bufferedReader.readLine();
			}
		
			bufferedReader.close();
			fileReader.close();
		}
		catch(FileNotFoundException ex)
		{
			System.out.println("The filename specified by the first argument to main does not exist or cannot"
					+ "be read.  Please specify a valid filename for the first argument to main");
			System.exit(0);
		}
		catch(IOException e)
		{
			System.out.println("Error reading the file specified by the first argument to main.  "
					+ "Please use a valid filename for the first arument to main");
			System.exit(0);
		}
		
	}

}
