package combridgelabzaddressbook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class AddressBookMain 
 {
    public int indexValue = 1;
    public HashMap<Integer,Contacts> contacts = new HashMap<>();
    public static Scanner sc = new Scanner(System.in);
    static AddressBookMain addressbook = new AddressBookMain();
    private void addContacts()
    {
        System.out.println("Enter Number of person you want to add");
        int numOfPerson = sc.nextInt();
        for (int add = 1; add <= numOfPerson; add++){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter The First Name: ");
            String firstName = scanner.nextLine();
            System.out.println("Enter The Last Name: ");
            String lastName = scanner.nextLine();
            System.out.println("Enter The Address: ");
            String address = scanner.nextLine();
            System.out.println("Enter The City: ");
            String city = scanner.nextLine();
            System.out.println("Enter The State: ");
            String state = scanner.nextLine();
            System.out.println("Enter The Zip Code: ");
            int zipCode = scanner.nextInt();
            System.out.println("Enter The Mobile Number: ");
            String number = scanner.next();
            System.out.println("Enter The Email-id: ");
            String email = scanner.next();
                if (addressbook.check(firstName)) 
                {
                    add--;
                    continue;
                }
                Contacts contacts = new Contacts(firstName, lastName, address, city, state, zipCode, number, email);
                contacts.put(indexValue, contacts);
                indexValue++;
        }
        System.out.println("\nContacts added Successfully");
    }
   
    private boolean check(String firstName) 
    {
        if (contacts.isEmpty())
            return false;
        else 
        {
            System.out.println("\nAdd contact again with different first name.");
            Iterator<Integer> itr = contacts.keySet().iterator();
            while (((Iterator<?>) itr).hasNext()) {
                int key = itr.next();
                if (contacts.get(key).firstName.equals(check(firstName))) 
                {
                    System.out.println("\nAdd contact again with different first name.");
                    return true;
                }
            }
        }
        return false;
    }
 
    public void editContact()
    {
        if (contacts.isEmpty())
        {
            System.out.println("Contact list is empty.");
        } else {
            System.out.println("Enter the first name to edit contact.");
            String name = sc.next();
            Iterator<Integer> itr = contacts.keySet().iterator();
            while(itr.hasNext()) {
                int key = itr.next();
                if (contacts.get(key).firstName.equals(name)) {
                    System.out.println("\nEnter First Name to Edit");
                    String first = sc.next();
                    sc.nextLine();
                    System.out.println("Enter Last Name to Edit");
                    String last = sc.next();
                    sc.nextLine();
                    System.out.println("Enter Address to Edit");
                    String address = sc.next();
                    sc.nextLine();
                    System.out.println("Enter City to Edit");
                    String city = sc.nextLine();
                    System.out.println("Enter State to Edit");
                    String state = sc.next();
                    sc.nextLine();
                    System.out.println("Enter Zip Code to Edit");
                    int zip = sc.nextInt();
                    System.out.println("Enter Phone Number to Edit");
                    String phone = sc.next();
                    System.out.println("Enter E-mail to Edit");
                    String email = sc.next();
                    Contacts contact = new Contacts(first, last, address, city, state, zip, phone, email);
                    contact.put(key, contact);
                    System.out.println("Contact edited with given first name : "+name);
                }
            }
        }
    }
  
    public void createNewAddressBook()
    {
        System.out.println("Enter the name for Address Book:");
        String addressBookName = sc.next();
        AddressBookList addressBookListobj = new AddressBookList(addressBookName);
    } 
    public static void main(String[] args) 
    {
        int choice = 1;
        do 
        {
            System.out.println("Enter your choice\n1. Add Contact\t\t2. Edit Contact\n3. Exit");
            int userInput = sc.nextInt();
            switch (userInput) 
            {
                case 1:
                    addressbook.addContacts();
                    break;
                case 2:
                    addressbook.editContact();
                    break;
                default:
                    System.out.println("You press exit.\nThank You!");
                    choice = 0;
                    break;
            }
        }
        while (choice != 0);
    }
}