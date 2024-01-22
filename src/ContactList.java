// Sam Reznik Contact List
// 1/21/2024

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class ContactList {
    private ArrayList<Person> contacts;
    private Scanner s;
    // Creates a ContactList
    public ContactList(){
        contacts = new ArrayList<Person>();
        s = new Scanner(System.in);
    }

    // Prints out the instructions
    public void instuctions(){
        System.out.println("Welcome to your Contact List");
        System.out.println("Please pick from the following menu options\n");
        System.out.println("Menu:");
        System.out.println("1. Add Contact");
        System.out.println("2. List All Contacts By First Name");
        System.out.println("3. List All Contacts By Last Name");
        System.out.println("4. List All Contacts By Phone Number");
        System.out.println("5. List All Students");
        System.out.println("6. Search By First Name");
        System.out.println("7. Search By Last Name");
        System.out.println("8. Search By By Phone Number");
        System.out.println("0. Exit");
    }

    // Returns the array list of people
    public ArrayList<Person> getContacts(){
        return contacts;
    }

    // Adds a person to the list
    public void addContact() {
        // Checks what type of Person is going to be added
        System.out.println("Select a type of Contact to add: \n1.Student \n2.Coach");
        int type = s.nextInt();
        s.nextLine();
        String first = "";
        String last = "";
        String phone = "";
        System.out.println("Please Fill in the Following Information.");
        System.out.println("First Name:");
        first = s.nextLine();
        System.out.println("Last Name:");
        last = s.nextLine();
        System.out.println("Phone Number:");
        phone = s.nextLine();
        // Adds a student
        if(type == 1){
            int grade = 0;
            System.out.println("Grade:");
            grade = s.nextInt();
            s.nextLine();
            Student a = new Student(first, last, phone, grade);
            contacts.add(a);
        }
        // Adds a coach
        else if(type == 2){
            String school = "";
            System.out.println("School:");
            school = s.nextLine();
            Coach a = new Coach(first, last, phone, school);
            contacts.add(a);
        }
    }
    // Prints a list of all the students
    public void listStudents() {
        for (Person s : contacts) {
            if (s instanceof Student) {
                System.out.println(s);
            }
        }
    }

    // Prints out all the contacts
    public void printContacts() {
        for (Person s : contacts) {
            System.out.println(s.toString());
        }
    }

    // Sort based off user input
    public void sort(int sortBy) {
        // Bubble sort
        for (int i = 0; i < contacts.size() - 1; i++) {
            for (int j = 0; j < contacts.size() - i - 1; j++) {
                Person contact1 = contacts.get(j);
                Person contact2 = contacts.get(j + 1);

                // Compare based on sortBy parameter
                int comparisonResult = 0;
                if (sortBy == 0) {
                    comparisonResult = contact1.getFirstName().compareTo(contact2.getFirstName());
                } else if (sortBy == 1) {
                    comparisonResult = contact1.getLastName().compareTo(contact2.getLastName());
                } else if (sortBy == 2) {
                    comparisonResult = contact1.getPhoneNumber().compareTo(contact2.getPhoneNumber());
                }

                // Swap if needed
                if (comparisonResult > 0) {
                    Collections.swap(contacts, j, j + 1);
                }
            }
        }
    }
    // Searches by first name and returns the Person
    public Person searchByFirstName(String firstName) {
        for(Person s : contacts) {
            if(s.getFirstName().equals(firstName)){
                return s;
            }
        }
        return null;
    }
    // Searches by last name and returns the Person
    public Person searchByLastName(String lastName) {
        for(Person s : contacts) {
            if (s.getLastName().equals(lastName)) {
                return s;
            }
        }
        return null;
    }
    // Searches by Phone number and returns the Person
    public Person searchByPhoneNumber(String phoneNumber) {
        for(Person s : contacts) {
            if (s.getPhoneNumber().equals(phoneNumber)) {
                return s;
            }
        }
        return null;
    }
    // Runs the program
    public void run() {
        instuctions();
        int console = 10;
        while (console != 0) {
            console = s.nextInt();
            s.nextLine();
            if(console == 1) {
                addContact();
            }
            else if (console == 2) {
                sort(0);
                printContacts();
            }
            else if (console == 3) {
                sort(1);
                printContacts();
            }
            else if (console == 4) {
                sort(2);
                printContacts();
            }
            else if (console == 5) {
                listStudents();
            }
            else if (console == 6) {
                System.out.println("Enter Name:");
                String name = s.nextLine();
                Person a = searchByFirstName(name);
                if(a == null) {
                    System.out.println(name + " is not in the list");
                }
                else {
                    System.out.println(a);
                }
            }
            else if (console == 7) {
                System.out.println("Enter Name:");
                String name = s.nextLine();
                Person a = searchByLastName(name);
                if(a == null) {
                    System.out.println(name + " is not in the list");
                }
                else {
                    System.out.println(a);
                }
            }
            else if (console == 8) {
                System.out.println("Enter Name:");
                String number= s.nextLine();
                Person a = searchByPhoneNumber(number);
                if(a == null) {
                    System.out.println(number + " is not in the list");
                }
                else {
                    System.out.println(a);
                }
            }

        }
    }

    public static void main(String[] args) {
        ContactList contactList = new ContactList();
        contactList.run();
    }


}
