package phonebook;

import java.util.LinkedList;

public final class PhoneBook {
    private final LinkedList<Contact> contacts = new LinkedList<>();

    public final LinkedList<Contact> getContacts() {
        return this.contacts;
    }

    public final boolean addContact(Contact contact) {
        if (contacts.contains(contact))
            return false;
        return contacts.add(contact);
    }

    public final boolean removeContact(int index) {
        return this.contacts.remove(this.get(index));
    }

    public final LinkedList<Contact> find(String substr) {
        LinkedList<Contact> result = new LinkedList<>();
        for (Contact contact: this.contacts) {
            LinkedList<String> strings = new LinkedList<>();
            strings.add(contact.getName());
            strings.add(contact.getSurname());
            for (PhoneNumber phoneNumber: contact.getPhoneNumbers()) {
                strings.add(phoneNumber.getNumber());
            }
            for (String str : strings) {
                if (str.contains(substr)) {
                    result.add(contact);
                    break;
                }
            }
        }
        return result;
    }

    public final Contact get(int i) {
        return contacts.get(i);
    }

    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof PhoneBook && contacts == ((PhoneBook) other).contacts;
    }

    public int hashCode() {
        return this.contacts.hashCode();
    }
}