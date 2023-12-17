import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ContactTest {
    private Contact contact;

    @Before
    public void setUp() {
        contact = new Contact("1234567890", "Jane", "Doe", "1234567890", "123 Main St");
    }

    @Test
    public void testContactCreation() {
        assertNotNull(contact);
        assertEquals("1234567890", contact.getContactId());
        assertEquals("Jane", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidContactId() {
        new Contact("12345678901", "Jane", "Doe", "1234567890", "123 Main St");
    }


    @Test
    public void testUpdateFirstName() {
        contact.setFirstName("John");
        assertEquals("John", contact.getFirstName());
    }


}
