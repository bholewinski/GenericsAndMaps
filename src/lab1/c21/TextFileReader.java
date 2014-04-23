package lab1.c21;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Instlogin
 */
public class TextFileReader {
    
    public List<String> readAll(String path) throws Exception {
        List<String> lines = new ArrayList<>();
        
        File file = new File(path);
        BufferedReader r = new BufferedReader(new FileReader(file));
        
        String line = null;
        try {
            line = r.readLine();
            while(line != null) {
                lines.add(line);
                line = r.readLine();
            }
        
        } catch(Exception e) {
            throw e;
        } finally {
            r.close();
        }
    
        
        return lines;
    }
    
    public static void main(String[] args) {
        String path = "src/contacts.txt";
        TextFileReader reader = new TextFileReader();
        try {
            List<String> list = reader.readAll(path);
            System.out.println(list);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } 
    }
}
