package com.addressbook.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ContactSearchTest {
    @Nested
    @DisplayName("searchByName method tests")
    class searchByNameTests {
        @Test
        @DisplayName("Test that a contact can be searched for by name")
        public void testContactCanBeSearchedForByName() {
            // Arrange
            AddressBook testAddressBook = new AddressBook();
            Contact contact1 = new Contact("Ahmed", "1234", "email1");
            testAddressBook.addContact(contact1);
            ContactSearch testContactSearch = new ContactSearch();

            // Act and assert
            assertEquals("Name: Ahmed\nPhone Number: 1234\nEmail: email1\n", testContactSearch.searchByName(testAddressBook, "Ahmed"));
        }

        @Test
        @DisplayName("Test that a contact cannot be searched for if it does not exist")
        public void testContactCannotBeSearchedForIfItDoesNotExist() {
            // Arrange
            AddressBook testAddressBook = new AddressBook();
            ContactSearch testContactSearch = new ContactSearch();
            // Act and assert
            assertEquals("Contact not found", testContactSearch.searchByName(testAddressBook, "Ahmed"));
        }

        @Test
        @DisplayName("Test that a contact cannot be searched for if name is null")
        public void testContactCannotBeSearchedForIfNameIsNull() {
            // Arrange
            AddressBook testAddressBook = new AddressBook();
            ContactSearch testContactSearch = new ContactSearch();
            // Act and assert
            assertThrows(IllegalArgumentException.class, () -> testContactSearch.searchByName(testAddressBook, null));
        }

        @Test
        @DisplayName("Test that a contact cannot be searched for if name is empty")
        public void testContactCannotBeSearchedForIfNameIsEmpty() {
            // Arrange
            AddressBook testAddressBook = new AddressBook();
            ContactSearch testContactSearch = new ContactSearch();
            // Act and assert
            assertThrows(IllegalArgumentException.class, () -> testContactSearch.searchByName(testAddressBook, ""));
        }
    }

    @Nested
    @DisplayName("searchByPhoneNumber method tests")
    class searchByPhoneNumberTests {
        @Test
        @DisplayName("Test that a contact can be searched for by phone number")
        public void testContactCanBeSearchedForByPhoneNumber() {
            // Arrange
            AddressBook testAddressBook = new AddressBook();
            Contact contact1 = new Contact("Ahmed", "1234", "email1");
            testAddressBook.addContact(contact1);
            ContactSearch testContactSearch = new ContactSearch();

            // Act and assert
            assertEquals("Name: Ahmed\nPhone Number: 1234\nEmail: email1\n", testContactSearch.searchByPhoneNumber(testAddressBook, "1234"));
        }
        @Test
        @DisplayName("Test that a contact cannot be searched for if phone number is null")
        public void testContactCannotBeSearchedForIfPhoneNumberIsNull() {
            // Arrange
            AddressBook testAddressBook = new AddressBook();
            ContactSearch testContactSearch = new ContactSearch();
            // Act and assert
            assertThrows(IllegalArgumentException.class, () -> testContactSearch.searchByPhoneNumber(testAddressBook, null));
        }
        @Test
        @DisplayName("Test that a contact cannot be searched for if phone number contains whitespace")
        public void testContactCannotBeSearchedForIfPhoneNumberContainsWhitespace() {
            // Arrange
            AddressBook testAddressBook = new AddressBook();
            ContactSearch testContactSearch = new ContactSearch();
            // Act and assert
            assertThrows(IllegalArgumentException.class, () -> testContactSearch.searchByPhoneNumber(testAddressBook, " "));
        }
        @Test
        @DisplayName("Test that a contact cannot be searched for if phone number contains anything but numbers")
        public void testContactCannotBeSearchedForIfPhoneNumberContainsAnythingButNumbers() {
            // Arrange
            AddressBook testAddressBook = new AddressBook();
            ContactSearch testContactSearch = new ContactSearch();
            // Act and assert
            assertThrows(IllegalArgumentException.class, () -> testContactSearch.searchByPhoneNumber(testAddressBook, "1234a"));
        }
    }
    @Nested
    @DisplayName("searchByEmail method tests")
    class searchByEmailTests {
        @Test
        @DisplayName("Test that a contact can be searched for by email")
        public void testContactCanBeSearchedForByEmail() {
            // Arrange
            AddressBook testAddressBook = new AddressBook();
            Contact contact1 = new Contact("Ahmed", "1234577", "email1");
            testAddressBook.addContact(contact1);
            ContactSearch testContactSearch = new ContactSearch();

            // Act and assert
            assertEquals("Name: Ahmed\nPhone Number: 1234577\nEmail: email1\n", testContactSearch.searchByEmail(testAddressBook, "email1"));
        }
        @Test
        @DisplayName("Test that a contact cannot be searched for if email is null")
        public void testContactCannotBeSearchedForIfEmailIsNull() {
            // Arrange
            AddressBook testAddressBook = new AddressBook();
            ContactSearch testContactSearch = new ContactSearch();
            // Act and assert
            assertThrows(IllegalArgumentException.class, () -> testContactSearch.searchByEmail(testAddressBook, null));
        }
        @Test
        @DisplayName("Test that a contact cannot be searched for if email is empty")
        public void testContactCannotBeSearchedForIfEmailIsEmpty() {
            // Arrange
            AddressBook testAddressBook = new AddressBook();
            ContactSearch testContactSearch = new ContactSearch();
            // Act and assert
            assertThrows(IllegalArgumentException.class, () -> testContactSearch.searchByEmail(testAddressBook, ""));
        }
    }
}