package lab1.c21;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

/**
 *
 * @author Instlogin
 */
public class ContactManager {
    private TextFileReader reader;
    private String path;
    private List<Contact> contacts;
    
    public ContactManager(final TextFileReader reader, String path) {
        setReader(reader);
        setPath(path);
    }
    
    public void createContactList() throws Exception {
        List<String> rawData = reader.readAll(path);
        List<Contact> contacts = new ArrayList<>();
        
        for(int i=0; i < rawData.size(); i++) {
            if((i+1) % 6 == 0) {
                Contact contact = new Contact();
                contact.setFirstName(rawData.get(i+1-6));
                contact.setLastName(rawData.get(i+1-5));
                contact.setAddress(rawData.get(i+1-4));
                contact.setCity(rawData.get(i+1-3));
                contact.setState(rawData.get(i+1-2));
                contact.setZip(rawData.get(i+1-1));
                contacts.add(contact);
            }
        }
        this.contacts = contacts;
        removeDuplicates();
    }
    
    private void removeDuplicates() {
        HashSet<Contact> set = new LinkedHashSet<Contact>(contacts);
        contacts = new ArrayList<Contact>(set);
    }

    public final TextFileReader getReader() {
        return reader;
    }

    public final void setReader(final TextFileReader reader) throws IllegalArgumentException {
        if(reader == null) {
            throw new IllegalArgumentException("reader cannot be null");
        }
        this.reader = reader;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) throws IllegalArgumentException {
        if(path == null || path.length() == 0) {
            throw new IllegalArgumentException("path cannot be empty");
        }
        this.path = path;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }
    
    public static void main(String[] args) throws Exception {
        ContactManager mgr = 
                new ContactManager(new TextFileReader(), 
                        "src/contacts.txt");
        mgr.createContactList();
        System.out.println(mgr.contacts);
    }
}
