package contact;

import java.util.HashMap;

public class ContactService {

    private final HashMap<String, Contact> contacts = new HashMap<>();

    public void addContact(String id, String firstName, String lastName,
                           String phone, String address) {

        if (contacts.containsKey(id))
            throw new IllegalArgumentException();

        contacts.put(id, new Contact(id, firstName, lastName, phone, address));
    }

    public void deleteContact(String id) {
        if (!contacts.containsKey(id))
            throw new IllegalArgumentException();
        contacts.remove(id);
    }

    public void updateFirstName(String id, String firstName) {
        getContact(id).setFirstName(firstName);
    }

    public void updateLastName(String id, String lastName) {
        getContact(id).setLastName(lastName);
    }

    public void updatePhone(String id, String phone) {
        getContact(id).setPhone(phone);
    }

    public void updateAddress(String id, String address) {
        getContact(id).setAddress(address);
    }

    private Contact getContact(String id) {
        if (!contacts.containsKey(id))
            throw new IllegalArgumentException();
        return contacts.get(id);
    }
}