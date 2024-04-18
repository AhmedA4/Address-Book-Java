package com.addressbook.app;

public class ContactViewer {
    public ContactViewer() {

    }

    public String viewContacts(AddressBook addressBook) {
        validateAddressBook(addressBook);
        String contacts = "";
        for (Contact contact : addressBook.getContacts()) {
            contacts += String.format("Name: %s%nPhone Number: %s%nEmail: %s%n%n", contact.getName(), contact.getPhoneNumber(), contact.getEmail());
        }
        return contacts;
    }

    public void validateAddressBook(AddressBook addressBook) {
        if (addressBook.getContacts().isEmpty()) {
            throw new IllegalArgumentException("Address book is empty");
        }
    }
}
