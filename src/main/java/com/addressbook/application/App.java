package com.addressbook.application;

import com.addressbook.app.AddressBook;
import com.addressbook.app.Contact;
import com.addressbook.app.ContactSearch;
import com.addressbook.app.ContactViewer;

import java.sql.SQLOutput;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {

        Contact contact = new Contact("Raphael", "1212", "email"); // Creates first contact

        AddressBook addressBook = new AddressBook(); // Creates an address book

        addressBook.addContact(contact); // Adds first contact to address book

//        System.out.println(addressBook.getContacts().get(0).getName());
//        System.out.println(addressBook.getContacts().get(0).getPhoneNumber());
//        System.out.println(addressBook.getContacts().get(0).getEmail());

        Contact contact2 = new Contact("Bruno", "5678", "email2"); // Creates second contact
        Contact contact3 = new Contact("Marcus", "2468", "email3"); // Creates third contact
        Contact contact4 = new Contact("Rasmus", "1357", "email4"); // Creates fourth contact

        addressBook.addContact(contact2); // Adding all contacts to the address book
        addressBook.addContact(contact3);
        addressBook.addContact(contact4);

        ContactSearch contactSearch = new ContactSearch(); // Creates a contact search object
        System.out.println(contactSearch.searchByName(addressBook, "Bruno")); // Searches for contact2 by name

        addressBook.removeContact(contact2); // Removes contact2 from address book
        System.out.println(contactSearch.searchByName(addressBook, "Bruno")); // Throws an error as contact2 has been removed

        System.out.println(contactSearch.searchByName(addressBook, "Marcus")); // Searches for contact3 by name
        addressBook.editContactEmail(contact3, "newEmail"); // Edit contact3's email
        System.out.println(contactSearch.searchByName(addressBook, "Marcus")); // We see that contact3's email has been edited

//        Contact contact5 = new Contact("Kobbie", "246448", "email4"); // Throws an error as phone number already exists

        ContactViewer contactViewer = new ContactViewer(); // Creates a contact viewer object
        System.out.println(contactViewer.viewContacts(addressBook)); // Views all contacts in the address book 'addressBook'

        System.out.println(contactSearch.searchByEmail(addressBook, "email4")); // Searches for contact4 by email

        System.out.println(contactSearch.searchByPhoneNumber(addressBook, "1357")); // Searches for contact4 by phone number

        addressBook.deleteAllContacts(); // Deletes all contacts in the address book 'addressBook'

        System.out.println(contactViewer.viewContacts(addressBook)); // Throws an error as address book is empty
    }
}
