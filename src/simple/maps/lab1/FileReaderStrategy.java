package simple.maps.lab1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * This interface represents the general contract for any reader strategy implementation
 * previously provided or developed in the future.
 * 
 * @author Jim Lombardo
 */
public interface FileReaderStrategy {
    
    public abstract List<Map<String, String>> readAll(String filePath) 
                    throws FileNotFoundException, IOException;
}
