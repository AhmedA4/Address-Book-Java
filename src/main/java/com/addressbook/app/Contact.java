package com.addressbook.app;

import java.sql.Array;
import java.util.ArrayList;

public class Contact {
    protected String name;
    protected String phoneNumber;
    protected String email;
    private static ArrayList<String> emailList = new ArrayList<>();
    private static ArrayList<String> numberList = new ArrayList<>();

    public Contact(String name, String phoneNumber, String email) {

        validateName(name);
        validatePhoneNumber(phoneNumber);
        validateEmail(email);

        if (numberList.contains(phoneNumber)) {
            throw new IllegalArgumentException("Phone number already exists");
        };

        if (emailList.contains(email)) {
            throw new IllegalArgumentException("Email already exists");
        };

        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;

        emailList.add(email);
        numberList.add(phoneNumber);

    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        validateName(name);
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        validatePhoneNumber(phoneNumber);
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        validateEmail(email);
        this.email = email;
    }

    public static void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name invalid");
        }
    }

    public static void validatePhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.trim().isEmpty() || !phoneNumber.matches("^\\d+$")) {
            throw new IllegalArgumentException("Phone number invalid");
        }
    }

    public static void validateEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email invalid");
        }
    }
}
