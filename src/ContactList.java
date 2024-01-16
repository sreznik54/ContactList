import java.util.ArrayList;

public class ContactList {
    private ArrayList<Person> contacts;

    public ContactList(){
        contacts = new ArrayList<Person>();
    }

    public Person getContacts(){
        return contacts;
    }
}
