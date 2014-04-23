package simple.maps.lab1;

import java.util.List;
import java.util.Map;

/**
 * This interface represents the general contract for any format strategy implementation
 * previously provided or developed in the future.
 * 
 * @author Jim Lombardo
 */
public interface TextFileFormatStrategy {

    List<Map<String, String>> decode(List<String> rawData);
    
}
