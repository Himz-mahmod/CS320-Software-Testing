
package contact;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {

    @Test
    void testAddContact() {
        ContactService service = new ContactService();
        service.addContact("1","John","Doe","1234567890","123 St");
    }

    @Test
    void testDuplicateId() {
        ContactService service = new ContactService();
        service.addContact("1","John","Doe","1234567890","123 St");
        assertThrows(IllegalArgumentException.class,
                () -> service.addContact("1","Jane","Smith","1234567890","456 St"));
    }

    @Test
    void testDeleteValid() {
        ContactService service = new ContactService();
        service.addContact("1","John","Doe","1234567890","123 St");
        service.deleteContact("1");
        assertThrows(IllegalArgumentException.class,
                () -> service.deleteContact("1"));
    }

    @Test
    void testDeleteInvalid() {
        ContactService service = new ContactService();
        assertThrows(IllegalArgumentException.class,
                () -> service.deleteContact("99"));
    }

    @Test
    void testUpdateValid() {
        ContactService service = new ContactService();
        service.addContact("1","John","Doe","1234567890","123 St");
        service.updateFirstName("1","Mike");
        service.updateLastName("1","Smith");
        service.updatePhone("1","0987654321");
        service.updateAddress("1","456 Ave");
    }

    @Test
    void testUpdateInvalidId() {
        ContactService service = new ContactService();
        assertThrows(IllegalArgumentException.class,
                () -> service.updateFirstName("99","Mike"));
    }
}
