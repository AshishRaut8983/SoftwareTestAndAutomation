import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {
    
    private ContactService contactService;
    
    @BeforeEach
    void setUp() {
        contactService = new ContactService();
        // Add a test contact
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
    }
    
    // Test adding contacts
    
    @Test
    void testAddContact() {
        // Add a new contact with a different ID
        Contact newContact = new Contact("0987654321", "Jane", "Smith", "9876543210", "456 Oak Ave");
        contactService.addContact(newContact);
        
        // Verify the contact was added by checking if we can retrieve it
        Contact retrievedContact = contactService.getContactById("0987654321");
        assertEquals("Jane", retrievedContact.getFirstName());
        assertEquals("Smith", retrievedContact.getLastName());
    }
    
    @Test
    void testAddDuplicateContactID() {
        // Try to add a contact with the same ID as an existing contact
        assertThrows(IllegalArgumentException.class, () -> {
            Contact duplicateContact = new Contact("1234567890", "Jane", "Smith", "9876543210", "456 Oak Ave");
            contactService.addContact(duplicateContact);
        });
    }
    
    // Test deleting contacts
    
    @Test
    void testDeleteContact() {
        // Delete the test contact
        contactService.deleteContact("1234567890");
        
        // Verify the contact was deleted
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.getContactById("1234567890");
        });
    }
    
    @Test
    void testDeleteNonExistentContact() {
        // Try to delete a contact that doesn't exist
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.deleteContact("nonexistent");
        });
    }
    
    // Test updating contacts
    
    @Test
    void testUpdateFirstName() {
        contactService.updateFirstName("1234567890", "Jane");
        Contact updatedContact = contactService.getContactById("1234567890");
        assertEquals("Jane", updatedContact.getFirstName());
    }
    
    @Test
    void testUpdateFirstNameForNonExistentContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateFirstName("nonexistent", "Jane");
        });
    }
    
    @Test
    void testUpdateLastName() {
        contactService.updateLastName("1234567890", "Smith");
        Contact updatedContact = contactService.getContactById("1234567890");
        assertEquals("Smith", updatedContact.getLastName());
    }
    
    @Test
    void testUpdateLastNameForNonExistentContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateLastName("nonexistent", "Smith");
        });
    }
    
    @Test
    void testUpdatePhone() {
        contactService.updatePhone("1234567890", "9876543210");
        Contact updatedContact = contactService.getContactById("1234567890");
        assertEquals("9876543210", updatedContact.getPhone());
    }
    
    @Test
    void testUpdatePhoneForNonExistentContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updatePhone("nonexistent", "9876543210");
        });
    }
    
    @Test
    void testUpdateAddress() {
        contactService.updateAddress("1234567890", "456 Oak Ave");
        Contact updatedContact = contactService.getContactById("1234567890");
        assertEquals("456 Oak Ave", updatedContact.getAddress());
    }
    
    @Test
    void testUpdateAddressForNonExistentContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateAddress("nonexistent", "456 Oak Ave");
        });
    }
    
    // Test invalid update values
    
    @Test
    void testUpdateFirstNameInvalid() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateFirstName("1234567890", "ThisNameIsTooLong");
        });
    }
    
    @Test
    void testUpdateLastNameInvalid() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateLastName("1234567890", "ThisNameIsTooLong");
        });
    }
    
    @Test
    void testUpdatePhoneInvalid() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updatePhone("1234567890", "123");
        });
    }
    
    @Test
    void testUpdateAddressInvalid() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateAddress("1234567890", 
                "This address is way too long and exceeds the thirty character limit that has been set");
        });
    }
}
