package com.addressbook.app;

import java.util.ArrayList;

import static com.addressbook.app.Contact.*;

public class AddressBook {
protected ArrayList<Contact> contacts;

public AddressBook() {
    this.contacts = new ArrayList<>();
}

    public ArrayList<Contact> getContacts() {
        return contacts;
};

    public void addContact(Contact contact) {
        validateContactDoesNotExist(contact);
        contacts.add(contact);
    };

    public void removeContact(Contact contact) {
        validateContactExists(contact);
        contacts.remove(contact);
    };

    public void editContactName(Contact contact, String newName) {
        validateContactExists(contact);
        validateName(newName);
        contact.setName(newName);
    };

    public void editContactPhoneNumber(Contact contact, String newPhoneNumber) {
        validateContactExists(contact);
        validatePhoneNumber(newPhoneNumber);
        contact.setPhoneNumber(newPhoneNumber);
    };

    public void editContactEmail(Contact contact, String newEmail) {
        validateContactExists(contact);
        validateEmail(newEmail);
        contact.setEmail(newEmail);
    };

    public void deleteAllContacts() {
        contacts.clear();
    };

    public void validateContactDoesNotExist(Contact contact) {
        if (contacts.contains(contact)) {
            throw new IllegalArgumentException("Contact already exists");
        }
    };

    public void validateContactExists(Contact contact) {
        if (!contacts.contains(contact)) {
            throw new IllegalArgumentException("Contact does not exist");
        }
    };
}
