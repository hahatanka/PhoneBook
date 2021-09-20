package contacts;

import java.beans.beancontext.BeanContextServiceAvailableEvent;
import java.util.ArrayList;
//Make a phonebook application, users should be able to add different people to the phonebook (name, phone number, email (optional)).
//Users should be able to remove, find different contacts by name, phone number or part of name of contact,
//Users should be able to update contact.
//Users should be able to see all contacts.


public class PhoneBook {
    //we create an array list "contacts" where we store the list of contacts from the Contact class.
    private ArrayList<Contact> contacts = new ArrayList<Contact>();

    //addContact/
    public String addContact(Contact contact) {
        this.contacts.add(contact);//method adds contact to the "contacts" arraylist
        return "Contact added successfully";
    }

    //viewAllContacts
    public ArrayList<Contact> getAllContacts() { //creating a method that returns an array of all cars
        return contacts;
    }

    //removeContact

    public void removeContact(Contact contact) {
        int contactID;
        contactID = contacts.indexOf(contact);
        contacts.remove(contactID);
        System.out.println("Contact" + contact.name);
    }

    //update car
    public Contact updateContact(int contactIndex, Contact contact) {
        return contacts.set(contactIndex, contact);
    }

    //find by name
    public Contact findByName(String name) {
        for (Contact contacts : contacts) {
            if (contacts.name.equals((name))) {
                return contacts;
            }
        }
        return null;
    }
}



