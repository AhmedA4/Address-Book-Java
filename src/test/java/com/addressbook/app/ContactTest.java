package com.addressbook.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {
    @Nested
    @DisplayName("Constructor tests")

    class ConstructorTests {
        @Test
        @DisplayName("Constructor sets expected values when valid")
        public void testConstructorSetsValuesWhenValid() {
            // Arrange
            String testName = "Ahmed";
            String testPhoneNumber = "1234";
            String testEmail = "ahmed@email.com";

            // Act
            Contact testContact = new Contact(testName, testPhoneNumber, testEmail);

            // Assert
            assertAll("Constructor sets values when valid",
                    () -> assertEquals(testName, testContact.getName()),
                    () -> assertEquals(testPhoneNumber, testContact.getPhoneNumber()),
                    () -> assertEquals(testEmail, testContact.getEmail()));
        }

        @Nested
        @DisplayName("Name tests using Contact")
        class NameTests {
            @Test
            @DisplayName("Constructor throws exception when name is null")
            public void testConstructorThrowsExceptionWhenNameIsNull() {
                // Arrange
                String testName = null;
                String testPhoneNumber = "1234";
                String testEmail = "email@email.com";
                // Act and Assert
                assertThrows(IllegalArgumentException.class, () -> new Contact(testName, testPhoneNumber, testEmail));
            }

            @Test
            @DisplayName("Constructor throws exception when name is empty")
            public void testConstructorThrowsExceptionWhenNameIsEmpty() {
                // Arrange
                String testName = " ";
                String testPhoneNumber = "1234";
                String testEmail = "email@email.com";
                // Act and Assert
                assertThrows(IllegalArgumentException.class, () -> new Contact(testName, testPhoneNumber, testEmail));
            }
        }

        @Nested
        @DisplayName("Phone number tests using Contact")
        class PhoneNumberTests {
            @Test
            @DisplayName("Constructor throws exception when phone number is null")
            public void testConstructorThrowsErrorWhenPhoneNumberIsNull() {
                // Arrange
                String testName = "Ahmed";
                String testPhoneNumber = null;
                String testEmail = "email@email.com";
                // Act and Assert
                assertThrows(IllegalArgumentException.class, () -> new Contact(testName, testPhoneNumber, testEmail));
            }

            @Test
            @DisplayName("Constructor throws exception when phone number is empty")
            public void testConstructorThrowsErrorWhenPhoneNumberIsEmpty() {
                // Arrange
                String testName = "Ahmed";
                String testPhoneNumber = " ";
                String testEmail = "email@email.com";
                // Act and Assert
                assertThrows(IllegalArgumentException.class, () -> new Contact(testName, testPhoneNumber, testEmail));
            }

            @Test
            @DisplayName("Constructor throws exception when phone number is same as another contact's phone number")
            public void testConstructorThrowsExceptionWhenNumberIsSameAsAnotherContactNumber() {
                // Arrange
                String testName = "Ahmed";
                String testPhoneNumber = "1234";
                String testEmail = "email";
                Contact testContact2 = new Contact("Erik", "1234", "email2");
                // Act and Assert
                assertThrows(IllegalArgumentException.class, () -> new Contact(testName, testPhoneNumber, testEmail));
            }
        }
        @Nested
        @DisplayName("Email tests using Contact")
        class EmailTests {
            @Test
            @DisplayName("Constructor throws exception when email is null")
            public void testConstructorThrowsExceptionWhenEmailIsNull() {
                // Arrange
                String testName = "Ahmed";
                String testPhoneNumber = "1234";
                String testEmail = null;
                // Act and Assert
                assertThrows(IllegalArgumentException.class, () -> new Contact(testName, testPhoneNumber, testEmail));
            }

            @Test
            @DisplayName("Constructor throws exception when email is empty")
            public void testConstructorThrowsExceptionWhenEmailIsEmpty() {
                // Arrange
                String testName = "Ahmed";
                String testPhoneNumber = "1234";
                String testEmail = " ";
                // Act and Assert
                assertThrows(IllegalArgumentException.class, () -> new Contact(testName, testPhoneNumber, testEmail));
            }

            @Test
            @DisplayName("Constructor throws exception when email is same as another contact's email")
            public void testConstructorThrowsExceptionWhenEmailIsSameAsAnotherContactEmail() {
                // Arrange
                String testName = "Ahmed";
                String testPhoneNumber = "1234";
                String testEmail = "email@email.com";
                Contact testContact2 = new Contact("Erik", "5678", testEmail);
                // Act and Assert
                assertThrows(IllegalArgumentException.class, () -> new Contact(testName, testPhoneNumber, testEmail));
            }
        }
    }
}
