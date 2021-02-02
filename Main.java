import phonebook.*;

import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        Contact contact1 = new Contact("Nikita", "Tepelin");
        contact1.addPhoneNumber("11111111111", "MOBILE");

        phoneBook.addContact(contact1);
        Contact contact2 = new Contact("Daniil", "Darenskih");
        contact2.addPhoneNumber("22222222222", "MOBILE");
        contact2.addPhoneNumber("33333333333", "MOBILE");
        phoneBook.addContact(contact2);
        System.out.println("=[PHONEBOOK APP]=");

        while(true) {
            System.out.println("Options: ");
            System.out.println("1 - add contact");
            System.out.println("2 - edit contact");
            System.out.println("3 - remove contact");
            System.out.println("4 - find contact");
            System.out.println("5 - print contacts");
            System.out.println("6 - quit");
            System.out.print("Your choose: ");
            Scanner scanner = new Scanner(System. in);
            Contact contact;
            int i;
            switch(scanner.nextLine()) {
                case "1":
                    System.out.print("Contact name: ");
                    String name = scanner.nextLine();
                    System.out.print("Contact surname: ");
                    String surname = scanner.nextLine();
                    contact = new Contact(name, surname);

                    if (phoneBook.addContact(contact)) {
                        System.out.print("Add a phone number? 'y', 'n': ");
                        String option;
                        option = scanner.nextLine();
                        while(option.equals("y")) {

                            System.out.print("Contract phone number: ");
                            String number = scanner.nextLine();
                            System.out.print("Contact number type: ");
                            String type = scanner.nextLine();

                            if (!contact.addPhoneNumber(number, type)) {
                                System.out.println("Cannot add existing phone number!");
                            }

                            System.out.print("Add a phone number? 'y', 'n': ");
                            option = scanner.nextLine();
                        }
                    } else {
                        System.out.println("Cannot add existing contact!");
                    }
                    break;
                case "2":
                    i = 0;
                    for (Contact c : phoneBook.getContacts()) {
                        System.out.println("[" + (i++) + "] " + c);
                    }

                    System.out.print("Contact index: ");
                    int index = scanner.nextInt();
                    scanner.nextLine();
                    contact = phoneBook.get(index);
                    System.out.println("1 - remove phone number");
                    System.out.println("2 - add phone number");
                    System.out.println("3 - edit name");
                    System.out.println("4 - edit surname");
                    System.out.println("5 - edit phone number");
                    System.out.println("6 - edit phone number type");

                    System.out.print("Your choose: ");

                    switch (scanner.nextLine()) {
                        case "1":
                            System.out.print("Contact phone number to remove (index): ");
                            contact.removePhoneNumber(scanner.nextInt());
                            scanner.nextLine();
                            break;
                        case "2":
                            System.out.print("Contact phone number: ");
                            String number = scanner.nextLine();
                            System.out.print("Contact number type: ");
                            String type = scanner.nextLine();
                            if (!contact.addPhoneNumber(number, type)) {
                                System.out.println("Cannot add existing phone number!");
                            }
                            break;
                        case "3":
                            System.out.print("Contact name: ");
                            contact.setName(scanner.nextLine());
                            break;
                        case "4":
                            System.out.print("Contact surname: ");
                            contact.setSurname(scanner.nextLine());
                            break;
                        case "5":
                            System.out.print("Contact phone number (index): ");
                            i = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Contact phone number: ");
                            contact.updatePhoneNumber(i, scanner.nextLine());
                            break;
                        case "6":
                            System.out.print("Contact phone number (index): ");
                            i = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Contact phone number type: ");
                            contact.updatePhoneNumberType(i, scanner.nextLine());
                            break;

                    }
                    break;
                case "3":
                    i = 0;
                    for (Contact c : phoneBook.getContacts()) {
                        System.out.println("[" + (i++) + "] " + c);
                    }
                    System.out.print("Contact to remove (index): ");
                    phoneBook.removeContact(scanner.nextInt());
                    scanner.nextLine();
                    break;
                case "4":
                    System.out.print("Enter substring: ");
                    List<Contact> contracts = phoneBook.find(scanner.nextLine());
                    for (Contact c : contracts) {
                        System.out.println(c);
                    }
                    break;
                case "5":
                    i = 0;
                    for (Contact c : phoneBook.getContacts()) {
                        System.out.println("[" + (i++) + "] " + c);
                    }
                    break;
                case "6":
                    return;
            }
        }
    }
}