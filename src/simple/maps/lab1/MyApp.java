package simple.maps.lab1;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Here's an example of an app that needs information from a text file, that
 * has a custom format known to the app developer. The app developer needs 
 * the information to come back from the text file as a List of Contacts. But 
 * the generic File Service cannot do that because that would make the File
 * Service ridid -- it would only work for this app. Instead the File Service 
 * provides an Intermediate format that is easy to use by any app. In this 
 * example that format is a List of Maps, where a map represents one record.
 * 
 * @author Jim Lombardo
 */
public class MyApp {
    public static void main(String[] args) throws Exception {
        // Initialize a FileReaderStrategy with the needed imlpementation
        // Note that this implementation needs a TextfileFormatStrategy
        // component (ContactFormatter) to do its job. We also need a
        // FileService as the service provider for the work to be done.
        // In the future we'll learn to hide the FileReaderStrategy, 
        // TextFileReader and ContactFormatter from the app, so that only
        // the service is exposed.
        FileReaderStrategy reader = new TextFileReader(new ContactFormatter());
        FileService fileService = new FileService();
        
        // Now we ask the FileService to read the file using the FileReaderStrategy
        // component. What we get back is the intermediate format that the
        // app must use.
       List<Map<String, String>> rawData = 
                fileService.readAll(reader,"src/contacts.txt");
        
       // This is the format the app actually wants
       List<Contact> contacts = new ArrayList<Contact>();
        
       // So the app must do the conversion
       for(Map<String,String> rec : rawData) {
            Contact c = new Contact();
            c.setFirstName(rec.get("firstName"));
            c.setLastName(rec.get("lastName"));
            c.setAddress(rec.get("address"));
            c.setCity(rec.get("city"));
            c.setState(rec.get("state"));
            c.setZip(rec.get("zip"));
            contacts.add(c);
       }
       
       // Now we can do what we want with the data. Here we remove the
       // duplicates from the List. Note that the LinkedHashSet maintains order.
       Set<Contact> nodupes = new LinkedHashSet<Contact>(contacts);
       contacts = new ArrayList<Contact>(nodupes);
       
       // Now just to prove everything works, output it to the console. We
       // should have 3 records -- one dupe removed.
       System.out.println(contacts);
    }
}
