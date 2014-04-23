package simple.maps.lab1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * This is a generic implementation of a File Reader Strategy designed to 
 * ready any text file in any format. It accomplishes this by making sure that 
 * all input and output is reusable. For example, the readAll method requires 
 * that you pass in a filePath, which could be a path to any file. And the 
 * method returns a List of Maps, which can be used to represent any type of 
 * data in any format. That's what makes this generic. Also, notice that this 
 * reader implementation relies on a strategy component to decode the data 
 * format in the file. The data is decoded to an intermediate format that any
 * app can use.
 * 
 * @author Jim Lombardo
 */
public class TextFileReader implements FileReaderStrategy {
    private File file;
    private TextFileFormatStrategy formatter;
    
    public TextFileReader(TextFileFormatStrategy formatter) {
        this.formatter = formatter;
    }
    
    public List<Map<String, String>> readAll(String filePath) 
            throws FileNotFoundException, IOException {
        
        file = new File(filePath);
        List<String> rawData = new ArrayList<String>();
        
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line = in.readLine();
        while(line !=null) {
            rawData.add(line);
            line = in.readLine();
        }
         
        return formatter.decode(rawData);
    }
    
}
