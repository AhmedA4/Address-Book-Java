package com.addressbook.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AddressBookTest {
    @Nested
    @DisplayName("addContact method tests")
    class addContactTests {
        @Test
        @DisplayName("Test that a contact can be added to the address book")
        public void testContactCanBeAddedToAddressBook() {
            // Arrange
            AddressBook testAddressBook = new AddressBook();
            Contact contactMock = mock(Contact.class);

            // Act
            testAddressBook.addContact(contactMock);

            // Assert
            assertEquals(1, testAddressBook.contacts.size());
        }

        @Test
        @DisplayName("Test that the correct contact has been added to the address book")
        public void testCorrectContactAddedToAddressBook() {
            // Arrange
            AddressBook testAddressBook = new AddressBook();
            Contact contactMock = mock(Contact.class);

            // Act
            testAddressBook.addContact(contactMock);

            // Assert
            assertEquals(contactMock, testAddressBook.contacts.get(0));
        }

        @Test
        @DisplayName("Test that a contact cannot be added if it already exists")
        public void testContactCannotBeAddedIfItAlreadyExists() {
            // Arrange
            AddressBook testAddressBook = new AddressBook();
            Contact contactMock = mock(Contact.class);

            // Act
            testAddressBook.addContact(contactMock);

            // Assert
            assertThrows(IllegalArgumentException.class, () -> testAddressBook.addContact(contactMock));
        }

        @Nested
        @DisplayName("removeContact method tests")
        class removeContactTests {
            @Test
            @DisplayName("Test that a contact can be removed from the address book")
            public void testContactCanBeRemovedFromAddressBook() {
                // Arrange
                AddressBook testAddressBook = new AddressBook();
                Contact contactMock = mock(Contact.class);
                testAddressBook.addContact(contactMock);

                // Act
                testAddressBook.removeContact(contactMock);

                // Assert
                assertEquals(0, testAddressBook.contacts.size());
            }

            @Test
            @DisplayName("Test that a contact cannot be removed if it does not exist")
            public void testContactCannotBeRemovedIfItDoesNotExist() {
                // Arrange
                AddressBook testAddressBook = new AddressBook();
                Contact contactMock = mock(Contact.class);

                // Act and Assert
                assertThrows(IllegalArgumentException.class, () -> testAddressBook.removeContact(contactMock));
            }
        }

        @Nested
        @DisplayName("editContact method tests")
        class editContactTests {
            @Test
            @DisplayName("Test that a contact name can be edited")
            public void testContactCanBeEdited() {
                // Arrange
                AddressBook testAddressBook = new AddressBook();
//                Contact contactMock = mock(Contact.class);
//                testAddressBook.addContact(contactMock);
//                String name1 = "Ahmed";
//                when(contactMock.getName()).thenReturn(name1);
                // Mocking did not work as would still return name1 - "Ahmed" instead of "John"
                Contact contact = new Contact("Ahmed", "1234", "email");
                testAddressBook.addContact(contact);
                // Act
                testAddressBook.editContactName(contact, "John");
                // Assert
                assertEquals("John", testAddressBook.contacts.get(0).getName());
            }

            @Test
            @DisplayName("Test that a contact phone number can be edited")
            public void testContactPhoneNumberCanBeEdited() {
                // Arrange
                AddressBook testAddressBook = new AddressBook();
                Contact contact = new Contact("Ahmed", "1234", "email");
                testAddressBook.addContact(contact);
                // Act
                testAddressBook.editContactPhoneNumber(contact, "5678");
                // Assert
                assertEquals("5678", testAddressBook.contacts.get(0).getPhoneNumber());
            }

            @Test
            @DisplayName("Test that a contact email can be edited")
            public void testContactEmailCanBeEdited() {
                // Arrange
                AddressBook testAddressBook = new AddressBook();
                Contact contact = new Contact("Ahmed", "1234", "email");
                testAddressBook.addContact(contact);
                // Act
                testAddressBook.editContactEmail(contact, "email2");
                // Assert
                assertEquals("email2", testAddressBook.contacts.get(0).getEmail());
            }

            @Test
            @DisplayName("Test that a contact cannot be edited if it does not exist")
            public void testContactCannotBeEditedIfItDoesNotExist() {
                // Arrange
                AddressBook testAddressBook = new AddressBook();
                Contact contact = new Contact("Ahmed", "1234", "email");
                // Act and Assert
                assertAll("Contact does not exist",
                        () -> assertThrows(IllegalArgumentException.class, () -> testAddressBook.editContactName(contact, "John")),
                        () -> assertThrows(IllegalArgumentException.class, () -> testAddressBook.editContactPhoneNumber(contact, "5678")),
                        () -> assertThrows(IllegalArgumentException.class, () -> testAddressBook.editContactEmail(contact, "email2")));
            }
        }
        @Nested
        @DisplayName("deleteAllContacts method tests")
        class deleteAllContactsTests {
            @Test
            @DisplayName("Test that all contacts can be deleted from the address book")
            public void testAllContactsCanBeDeletedFromAddressBook() {
                // Arrange
                AddressBook testAddressBook = new AddressBook();
                Contact contact1 = new Contact("Ahmed", "1234", "email");
                Contact contact2 = new Contact("John", "5678", "email2");
                testAddressBook.addContact(contact1);
                testAddressBook.addContact(contact2);
                // Act
                testAddressBook.deleteAllContacts();
                // Assert
                assertEquals(0, testAddressBook.contacts.size());
            }
        }
    }
}



