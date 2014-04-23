package simple.maps.lab1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This is an application-specific implementation of a Text File Format
 * Strategy. Note that an app that needs such a custom feature will always 
 * need to implement it's own version. This is why it's normally better to 
 * use industry-standard formats like CSV or XML.
 * 
 * @author Jim Lombardo
 */
public class ContactFormatter implements TextFileFormatStrategy {
    
    @Override
    public List<Map<String,String>> decode(List<String> rawData) {
        final int LINES_PER_REC = 6;
        List<Map<String,String>> records = new ArrayList<Map<String,String>>();
        
        for(int i=1; i < rawData.size()+1; i++) {
            if(i % LINES_PER_REC == 0) {
                Map<String,String> rec = new HashMap<String,String>();
                rec.put("firstName",rawData.get(i-6));
                rec.put("lastName",rawData.get(i-5));
                rec.put("address",rawData.get(i-4));
                rec.put("city",rawData.get(i-3));
                rec.put("state",rawData.get(i-2));
                rec.put("zip",rawData.get(i-1));
                records.add(rec);
            }
        }
        
        return records;
    }
}
