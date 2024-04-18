package com.addressbook.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ContactViewerTest {
    @Nested
    @DisplayName("viewContacts method tests")
    class viewContactTests {
        @Test
        @DisplayName("Test that contacts can be viewed")
        public void testContactsCanBeViewed() {
            // Arrange
            AddressBook testAddressBook = new AddressBook();
            Contact contact1 = new Contact("Ahmed", "1234", "email1");
            Contact contact2 = new Contact("John", "5678", "email2");
            testAddressBook.addContact(contact1);
            testAddressBook.addContact(contact2);
            ContactViewer testContactViewer = new ContactViewer();

            // Act and assert
            assertEquals("Name: Ahmed\nPhone Number: 1234\nEmail: email1\n\nName: John\nPhone Number: 5678\nEmail: email2\n\n", testContactViewer.viewContacts(testAddressBook));
        }
        @Test
        @DisplayName("Test that contacts cannot be viewed when there are no contacts")
        public void testContactsCannotBeViewedWhenThereAreNoContacts() {
            // Arrange
            AddressBook testAddressBook = new AddressBook();
            ContactViewer testContactViewer = new ContactViewer();
            // Act and assert
            assertThrows(IllegalArgumentException.class, () -> testContactViewer.viewContacts(testAddressBook));
        }
    }
}
