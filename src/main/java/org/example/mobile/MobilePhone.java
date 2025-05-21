package org.example.mobile;

import java.util.ArrayList;
import java.util.List;

public class MobilePhone {
    private String myNumber;
    private List<Contact> myContacts;

    public MobilePhone(String myNumber, List<Contact> myContacts) {
        this.myNumber = myNumber;
        this.myContacts = myContacts;


    }
    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }

    public String getMyNumber() {
        return myNumber;
    }

    public List<Contact> getMyContacts() {
        return myContacts;
    }
    public boolean addNewContact(Contact contact) {
        if (!myContacts.contains(contact)) {
            myContacts.add(contact);
            return true;
        }
        return false;
    }

    public boolean updateContact(Contact contact1, Contact contactUpdate) {
        int index = myContacts.indexOf(contact1);

        if (index != -1) {
            myContacts.set(index, contactUpdate);
            return true;
        }
        return false;
    }
    public boolean removeContact(Contact contact) {


        if (findContact(contact)!=-1) {
            myContacts.remove(findContact(contact));
            return true;
        }
        return false;
    }
    public int findContact(Contact contact) {
        if(myContacts.contains(contact)){
            return myContacts.indexOf(contact);
        }
        else {
            return -1;
        }
    }
    public int findContact(String contactName) {
        for (int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }
    public Contact queryContact(String contactName) {
        for (Contact contact : myContacts) {
            if (contact.getName().equals(contactName)) {
                return contact;
            }
        }
        return null;
    }
    public void printContact() {
        for (int i = 0; i <myContacts.size() ; i++) {
            System.out.println(i+1+". "+myContacts.get(i).getName()+"->"+myContacts.get(i).getPhoneNumber());
        }

    }

}
