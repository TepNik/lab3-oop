package phonebook;

import java.util.LinkedList;
import java.util.Objects;

public final class Contact {
    private final LinkedList<PhoneNumber> phoneNumbers;
    private String name;
    private String surname;

    public Contact(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.phoneNumbers = new LinkedList<>();
    }

    public final LinkedList<PhoneNumber> getPhoneNumbers() {
        return this.phoneNumbers;
    }

    public final boolean addPhoneNumber(String number, String type) {
        PhoneNumber phoneNumber = new PhoneNumber(number, type);
        if (phoneNumbers.contains(phoneNumber))
            return false;
        return this.phoneNumbers.add(phoneNumber);
    }

    public String toString() {
        StringBuilder result = new StringBuilder(name + " " + surname );
        for (int i = 0; i < phoneNumbers.size(); ++i) {
            PhoneNumber phoneNumber = phoneNumbers.get(i);
            result.append(" [").append(i).append("]: ").append(phoneNumber.getType()).append(" ").append(phoneNumber.getNumber());
        }
        return result.toString();
    }
    
    public final void updatePhoneNumber(int index, String number) {
        phoneNumbers.get(index).setNumber(number);
    }

    public final void removePhoneNumber(int index) {
        phoneNumbers.remove(index);
    }

    public final void updatePhoneNumberType(int index, String type) {
        phoneNumbers.get(index).setType(type);
    }

    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof Contact && name.equals(((Contact) other).name)
                && surname.equals(((Contact) other).surname) && phoneNumbers == ((Contact)other).phoneNumbers;
    }

    public int hashCode() {
        return Objects.hash(name, surname, phoneNumbers);
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String name) {
        this.name = name;
    }

    public final String getSurname() {
        return this.surname;
    }

    public final void setSurname(String surname) {
        this.surname = surname;
    }
}