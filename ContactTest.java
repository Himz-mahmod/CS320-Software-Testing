
package contact;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    @Test
    void testValidContact() {
        Contact c = new Contact("1","John","Doe","1234567890","123 St");
        assertEquals("1", c.getContactId());
        assertEquals("John", c.getFirstName());
        assertEquals("Doe", c.getLastName());
        assertEquals("1234567890", c.getPhone());
        assertEquals("123 St", c.getAddress());
    }

    @Test void testNullId() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact(null,"John","Doe","1234567890","123 St"));
    }

    @Test void testLongId() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("12345678901","John","Doe","1234567890","123 St"));
    }

    @Test void testNullFirstName() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1",null,"Doe","1234567890","123 St"));
    }

    @Test void testLongFirstName() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1","12345678901","Doe","1234567890","123 St"));
    }

    @Test void testNullLastName() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1","John",null,"1234567890","123 St"));
    }

    @Test void testLongLastName() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1","John","12345678901","1234567890","123 St"));
    }

    @Test void testNullPhone() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1","John","Doe",null,"123 St"));
    }

    @Test void testInvalidPhone() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1","John","Doe","123","123 St"));
    }

    @Test void testNullAddress() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1","John","Doe","1234567890",null));
    }

    @Test void testLongAddress() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1","John","Doe","1234567890",
                        "1234567890123456789012345678901"));
    }

    @Test
    void testSetters() {
        Contact c = new Contact("1","John","Doe","1234567890","123 St");
        c.setFirstName("Mike");
        c.setLastName("Smith");
        c.setPhone("0987654321");
        c.setAddress("456 Ave");
        assertEquals("Mike", c.getFirstName());
        assertEquals("Smith", c.getLastName());
        assertEquals("0987654321", c.getPhone());
        assertEquals("456 Ave", c.getAddress());
    }
}
