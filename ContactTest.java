import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactTest {
    
    private Contact contact;
    
    @BeforeEach
    void setUp() {
        // Valid contact object for testing
        contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
    }
    
    // Test Contact ID requirements
    
    @Test
    void testValidContactID() {
        assertEquals("1234567890", contact.getContactID());
    }
    
    @Test
    void testContactIDTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St");
        });
    }
    
    @Test
    void testContactIDNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Doe", "1234567890", "123 Main St");
        });
    }
    
    // Test firstName requirements
    
    @Test
    void testValidFirstName() {
        assertEquals("John", contact.getFirstName());
    }
    
    @Test
    void testFirstNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "JohnJacobJingleheimer", "Doe", "1234567890", "123 Main St");
        });
    }
    
    @Test
    void testFirstNameNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", null, "Doe", "1234567890", "123 Main St");
        });
    }
    
    @Test
    void testUpdateFirstName() {
        contact.setFirstName("Jane");
        assertEquals("Jane", contact.getFirstName());
    }
    
    // Test lastName requirements
    
    @Test
    void testValidLastName() {
        assertEquals("Doe", contact.getLastName());
    }
    
    @Test
    void testLastNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "John", "DoeJohnsonSmith", "1234567890", "123 Main St");
        });
    }
    
    @Test
    void testLastNameNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "John", null, "1234567890", "123 Main St");
        });
    }
    
    @Test
    void testUpdateLastName() {
        contact.setLastName("Smith");
        assertEquals("Smith", contact.getLastName());
    }
    
    // Test phone requirements
    
    @Test
    void testValidPhone() {
        assertEquals("1234567890", contact.getPhone());
    }
    
    @Test
    void testPhoneTooShort() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "John", "Doe", "123456789", "123 Main St");
        });
    }
    
    @Test
    void testPhoneTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "John", "Doe", "12345678901", "123 Main St");
        });
    }
    
    @Test
    void testPhoneNonDigits() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "John", "Doe", "123-456-789", "123 Main St");
        });
    }
    
    @Test
    void testPhoneNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "John", "Doe", null, "123 Main St");
        });
    }
    
    @Test
    void testUpdatePhone() {
        contact.setPhone("9876543210");
        assertEquals("9876543210", contact.getPhone());
    }
    
    // Test address requirements
    
    @Test
    void testValidAddress() {
        assertEquals("123 Main St", contact.getAddress());
    }
    
    @Test
    void testAddressTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "John", "Doe", "1234567890", 
                "123 Main St, Apt 4B, Springfield, IL, 62701, United States of America");
        });
    }
    
    @Test
    void testAddressNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "John", "Doe", "1234567890", null);
        });
    }
    
    @Test
    void testUpdateAddress() {
        contact.setAddress("456 Oak Ave");
        assertEquals("456 Oak Ave", contact.getAddress());
    }
}
