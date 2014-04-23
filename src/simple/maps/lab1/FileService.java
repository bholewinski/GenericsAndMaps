package simple.maps.lab1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * This class represents the high-level module in the DIP. It is a service
 * class (a Facade) that hides the complexity of the rest of the File Management
 * system. It is the front-facing object to our app and the only object our
 * app should ever talk to. Notice how the FileService doesn't actually do
 * any of the work. That is delegated to the reader component.
 * 
 * @author Jim Lombardo
 */
public class FileService {
    
    public List<Map<String, String>> readAll(FileReaderStrategy reader, String filePath) 
            throws FileNotFoundException, IOException {
        
        return reader.readAll(filePath);
    }
}
