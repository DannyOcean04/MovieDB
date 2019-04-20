package FileHandler;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Danyal Ahmed
 * @version 16/07/2018
 *
 */
public class InputReader
{
    private Scanner reader;
    private File f;

    /**
     * Create a new InputReader that reads text from the file with the given name.
     */
    public InputReader(String fname) {
    	f = new File(fname);
        try {
            reader = new Scanner(f);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(InputReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Read a line of text from the input (a SIM file),
     * and return it as an array of String data values.
     *
     * @return  An array of Strings, where each String is one of the
     *          fields in the input.
     */
    public String[] getInput()
    {
        String[] input = reader.nextLine().trim().split(",");
        return input;
    }
    public boolean hasNext(){
    	return reader.hasNext();
    }

    public void closeFile(){
    	reader.close();
    }

    public void deleteFile(){
   f.delete();
    }
}
