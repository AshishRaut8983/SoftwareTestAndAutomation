import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private Map<String, Contact> contacts;
    
    // Constructor
    public ContactService() {
        contacts = new HashMap<>();
    }
    
    // Add a contact
    public void addContact(Contact contact) {
        String contactID = contact.getContactID();
        
        // Check if contact with the same ID already exists
        if (contacts.containsKey(contactID)) {
            throw new IllegalArgumentException("Contact ID must be unique");
        }
        
        contacts.put(contactID, contact);
    }
    
    // Delete a contact
    public void deleteContact(String contactID) {
        if (!contacts.containsKey(contactID)) {
            throw new IllegalArgumentException("Contact with ID " + contactID + " does not exist");
        }
        
        contacts.remove(contactID);
    }
    
    // Update firstName
    public void updateFirstName(String contactID, String firstName) {
        Contact contact = getContact(contactID);
        contact.setFirstName(firstName);
    }
    
    // Update lastName
    public void updateLastName(String contactID, String lastName) {
        Contact contact = getContact(contactID);
        contact.setLastName(lastName);
    }
    
    // Update phone
    public void updatePhone(String contactID, String phone) {
        Contact contact = getContact(contactID);
        contact.setPhone(phone);
    }
    
    // Update address
    public void updateAddress(String contactID, String address) {
        Contact contact = getContact(contactID);
        contact.setAddress(address);
    }
    
    // Helper method to get a contact by ID
    private Contact getContact(String contactID) {
        if (!contacts.containsKey(contactID)) {
            throw new IllegalArgumentException("Contact with ID " + contactID + " does not exist");
        }
        
        return contacts.get(contactID);
    }
    
    // Method to get a contact by ID (for testing purposes)
    public Contact getContactById(String contactID) {
        return getContact(contactID);
    }
}
