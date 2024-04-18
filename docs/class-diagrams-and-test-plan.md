
# Class Diagrams and Test Plan

```mermaid
classDiagram
    class AddressBook {
        -contacts ArrayList<Contact>
        +AddressBook()
        +getContacts() ArrayList<Contact>
        +addContact(contact Contact) void
        +removeContact(contact Contact) void
        +editContactName(contact Contact, newName String) void
        +editContactPhoneNumber(contact Contact, newPhoneNumber String) void
        +editContactEmail(contact Contact, newEmail String) void
        +deleteAllContacts() void
        +validateContactDoesNotExist(contact Contact) void
        +validateContactExists(contact Contact) void
        +validateName(name String)$ void
        +validatePhoneNumber(phoneNumber String)$ void
        +validateEmail(email String)$ void
    }
    
    class Contact {
        -name String
        -phoneNumber String
        -email String
        -emailList$ ArrayList<String>
        -phoneNumberList$ ArrayList<String>
        +Contact(name String, phoneNumber String, email String)
        +getName() String
        +getPhoneNumber() String
        +getEmail() String
        +setName(name String) void
        +setPhoneNumber(phoneNumber String) void
        +setEmail(email String) void
        +validateName(name String)$ void
        +validatePhoneNumber(phoneNumber String)$ void
        +validateEmail(email String)$ void
    }
    
    class ContactSearch {
        +ContactSearch()
        +searchByName() name String, phoneNumber String, email String
        +searchByPhoneNumber() name String, phoneNumber String, email String
        +searchByEmail() name String, phoneNumber String, email String
        +validateName(name String)$ void
        +validatePhoneNumber(phoneNumber String)$ void
        +validateEmail(email String)$ void
    }
    
    class ContactViewer {
        +ContactViewer()
        +viewContacts(addressBook AddressBook) String
        +validateAddressBook(addressBook AddressBook) void
    }

```
# Test Plan

## Contact
- **Test 1:** Test that the name of the contact cannot be null
- **Test 2:** Test that the name of the contact cannot be empty
- **Test 3:** Test that the phone number of the contact cannot be null
- **Test 4:** Test that the phone number of the contact cannot be empty
- **Test 5:** Test that the email of the contact cannot be null
- **Test 6:** Test that the email of the contact cannot be empty
- **Test 7:** Test that a contact cannot be added with the same email as another contact
- **Test 8:** Test that a contact cannot be added with the same phone number as another contact

## AddressBook
- **Test 1:** Test that a contact can be added to the address book
- **Test 2:** Test that the correct contact has been added to the address book
- **Test 3:** Test that a contact cannot be added if it already exists
- **Test 4:** Test that a contact can be removed from the address book
- **Test 5:** Test that a contact cannot be removed if it does not exist
- **Test 6:** Test that a contact's name can be edited
- **Test 7:** Test that a contact's phone number can be edited
- **Test 8:** Test that a contact's email can be edited
- **Test 9:** Test that a contact cannot be edited if it does not exist

## ContactSearch
- **Test 1:** Test that the email and phone number are displayed when a name is searched for
- **Test 2:** Test that a contact cannot be searched for if it does not exist
- **Test 3:** Test that a contact cannot be searched for if the name is null
- **Test 4:** Test that a contact cannot be searched for if the name is empty

## ContactViewer
- **Test 1:** Test that all contacts can be viewed
- **Test 2:** Test that the contacts cannot be viewed if there are none (the address book is empty)


