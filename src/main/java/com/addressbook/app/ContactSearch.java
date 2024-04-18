package com.addressbook.app;

import static com.addressbook.app.Contact.validateEmail;
import static com.addressbook.app.Contact.validatePhoneNumber;

public class ContactSearch {
    public ContactSearch() {

    }

    public String searchByName(AddressBook addressBook, String name) {
        validateName(name);
        for (Contact contact : addressBook.getContacts()) {
            if (contact.getName().equals(name)) {
                return String.format("Name: %s%nPhone Number: %s%nEmail: %s%n", contact.getName(), contact.getPhoneNumber(), contact.getEmail());
            }
        }
        return "Contact not found";
    }

    public String searchByPhoneNumber(AddressBook addressBook, String phoneNumber) {
        validatePhoneNumber(phoneNumber);
        for (Contact contact : addressBook.getContacts()) {
            if (contact.getPhoneNumber().equals(phoneNumber)) {
                return String.format("Name: %s%nPhone Number: %s%nEmail: %s%n", contact.getName(), contact.getPhoneNumber(), contact.getEmail());
            }
        }
        return "Contact not found";
    }

    public String searchByEmail(AddressBook addressBook, String email) {
        validateEmail(email);
        for (Contact contact : addressBook.getContacts()) {
            if (contact.getEmail().equals(email)) {
                return String.format("Name: %s%nPhone Number: %s%nEmail: %s%n", contact.getName(), contact.getPhoneNumber(), contact.getEmail());
            }
        }
        return "Contact not found";
    }

    public static void validateName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null");
        }
    }
}
