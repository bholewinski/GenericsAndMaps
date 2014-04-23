package lab1.c21;

/**
 *
 * @author Instlogin
 */
public class Startup {
    public static void main(String[] args) {
        try {
            ContactManager mgr =
                    new ContactManager(new TextFileReader(),
                            "src/contacts.txt");
            mgr.createContactList();
            System.out.println(mgr.getContacts());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
