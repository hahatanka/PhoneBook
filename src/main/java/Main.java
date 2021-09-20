import contacts.Contact;
import contacts.PhoneBook;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    PhoneBook phoneBook = new PhoneBook();
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        main.Menu();
    }

    void Menu() {
        String userInput;
        System.out.println();
        do {
            System.out.println("\nPlease choose what you want to do:");
            System.out.println("1. Add a Contact");
            System.out.println("2. View All Contacts");
            System.out.println("3. Find a Contact");
            System.out.println("4. Remove a Contact");
            System.out.println("5. Update a Contact by Name");
            System.out.println("\nEnter Quit to end program...");

            System.out.println("Choose a number:");
            userInput = scanner.nextLine();

            if (userInput.equals("1")) {
                addContact();
            } else if (userInput.equals("2")) {
                viewAllContacts();
            } else if (userInput.equals("3")) {
                findContact();
            } else if (userInput.equals("4")) {
                removeContact();
            } else if (userInput.equals("5")) {
                updateContactByName();
            } else if (userInput.equals("Quit"))
                System.out.println("Exiting the program..");
        }
        while (!userInput.equalsIgnoreCase("Quit"));
        return;
//

    }

    void addContact() {
        Contact contact = new Contact();
        System.out.println("Add Contact");
        System.out.println("Enter Name:");
        contact.name = scanner.nextLine();

        System.out.println("Enter Phone Number: ");
        Scanner intScanner = new Scanner(System.in);
        contact.phone = intScanner.nextLine();

        System.out.println("Enter Email: ");
        contact.email = scanner.nextLine();

        String message = phoneBook.addContact(contact);
        System.out.println(message);
    }

    void viewAllContacts() {
        ArrayList<Contact> allContacts = phoneBook.getAllContacts();
        System.out.println("All Contacts");
        for (Contact contact : allContacts) {
            System.out.println("\nName: " + contact.name + "\nPhone: " + contact.phone + "\nEmail: " + contact.email);
        }
    }

    void findContact() {
        System.out.println("FIND A CONTACT");
        System.out.println("Choose how you want to search for a contact:");
        System.out.println("a. Find contact by name");
        System.out.println("b. Find contact by phone number");
        System.out.println("c. Find contact by email");
        String userInput2 = scanner.nextLine();
        switch (userInput2) {
            case "a":
                findByName();
                break;
            case "b":
                findByPhone();
                break;
            case "c":
                findByEmail();
                break;
            default:
                break;

        }
    }

    void findByName() {
        ArrayList<Contact> allContacts = phoneBook.getAllContacts();
        System.out.println("Please enter contact name:");
        for (Contact contact : allContacts) {
            Pattern contactName = Pattern.compile(contact.name);
            Matcher userInputName = contactName.matcher(scanner.nextLine());
            if (userInputName.find()) {
                System.out.println("You found:" + "\nName: " + contact.name + "\nPhone: " + contact.phone + "\nEmail: " + contact.email);
            } else {
                System.out.println("cannot find this contact, try again");
            }
        }

    }

    void findByPhone() {
        ArrayList<Contact> allContacts = phoneBook.getAllContacts();
        System.out.println("Please enter contact phone number:");
        for (Contact contact : allContacts) {
            Pattern contactPhone = Pattern.compile(String.valueOf(contact.phone));
            Matcher userInputPhone = contactPhone.matcher(scanner.nextLine());

            if (userInputPhone.find()) {
                System.out.println("You found:" + "\nName: " + contact.name + "\nPhone: " + contact.phone + "\nEmail: " + contact.email);
            } else {
                System.out.println("cannot find this contact, try again");
            }
        }
    }

    void findByEmail() {
        ArrayList<Contact> allContacts = phoneBook.getAllContacts();
        System.out.println("Please enter contact email:");
        for (Contact contact : allContacts) {
            Pattern contactEmail = Pattern.compile(contact.email);
            Matcher userInputEmail = contactEmail.matcher(scanner.nextLine());

            if (userInputEmail.find()) {
                System.out.println("You found:" + "\nName: " + contact.name + "\nPhone: " + contact.phone + "\nEmail: " + contact.email);
            } else {
                System.out.println("cannot find this contact, try again");
            }
        }
    }

    void removeContact() {
        ArrayList<Contact> allContacts = phoneBook.getAllContacts();
        System.out.println("REMOVE CONTACT");
        System.out.println("Choose how you want to search for a contact:");
        System.out.println("a. Find contact by name");
        System.out.println("b. Find contact by phone number");
        System.out.println("c. Find contact by email");
        String userInput = scanner.nextLine();
        switch (userInput) {
            case "a":
                System.out.println("Enter the name of the contact to be removed");
                for (Contact contact : allContacts) {
                    Pattern contactName = Pattern.compile(contact.name);
                    Matcher userInputName = contactName.matcher(scanner.nextLine());
                    if (userInputName.find()) {
                        phoneBook.removeContact(contact);
                        System.out.println("Deleted successfully");
                    } else {
                        System.out.println("cannot find this contact, try again");
                    }
                }
                break;
            case "b":
                System.out.println("Enter the phone number of the contact to be removed");
                for (Contact contact : allContacts) {
                    Pattern contactPhone = Pattern.compile(String.valueOf(contact.phone));
                    Matcher userInputPhone = contactPhone.matcher(scanner.nextLine());
                    if (userInputPhone.find()) {
                        phoneBook.removeContact(contact);
                        System.out.println("Deleted successfully");
                    } else {
                        System.out.println("cannot find this contact, try again");
                    }
                }
                break;
            case "c":
                System.out.println("Enter the email of the contact to be removed");
                for (Contact contact : allContacts) {
                    Pattern contactEmail = Pattern.compile(contact.email);
                    Matcher userInputEmail = contactEmail.matcher(scanner.nextLine());
                    if (userInputEmail.find()) {
                        phoneBook.removeContact(contact);
                        System.out.println("Deleted successfully");
                    } else {
                        System.out.println("cannot find this contact, try again");
                    }
                }
            default:
                break;
        }
    }


    void updateContactByName() {
        System.out.println("Find Contact by NAME..");
        System.out.println("Enter contact NAME: ");
        String contactName = scanner.nextLine();
        Contact contacts = phoneBook.findByName(contactName);

        int contactIndex = phoneBook.getAllContacts().indexOf(contacts);
        System.out.println("Enter the property you wold like to change:");
        String property = scanner.nextLine();

        System.out.println("Enter the new value of: " + property);
        String value = scanner.nextLine();

        switch (property) {
            case "name":
                contacts.name = value;
                break;
            case "number", "phone number":
                contacts.phone = value;
                break;
            case "email":
                contacts.email = value;
                break;
            default:
                System.out.println("Please provide a value property");
                break;
        }
        phoneBook.updateContact(contactIndex, contacts);
        System.out.println(contacts.name + " updated successfully, see new info below:");
        System.out.println("Name: " + contacts.name);
        System.out.println("Phone Number: " + contacts.phone);
        System.out.println("Contact Email: " + contacts.email);

    }
}
