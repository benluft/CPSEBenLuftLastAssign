
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;


/**
 * Writes the data of a node from the binary search tree to a file
 * 
 * @author Ben Luft
 *
 */
public class FileWriting {
	
	/**
	 * Buffered writer that can write to a file
	 */
	BufferedWriter writer;
	
	/**
	 * Creates a buffered writer than can be used to write to a file
	 * 
	 * @param filename file to write to 
	 */
	public FileWriting(String filename)
	{
		try{
				writer = new BufferedWriter(new FileWriter(filename));
		} 
		catch (FileNotFoundException e) {
			System.out.println("File was not found");
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Writes a string to a file
	 * 
	 * @param w string to write
	 */
	public void writeToFile(String w)
	{
		try {
			writer.write(w);
			writer.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Closes the Print Writer when all data has been writen to the file
	 * 
	 */
	public void closePrintWriter()
	{
		try {
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
