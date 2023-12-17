import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ContactServiceTest {
    private ContactService service;
    private Contact contact;

    @Before
    public void setUp() {
        service = new ContactService();
        contact = new Contact("1234567890", "Jane", "Doe", "1234567890", "123 Main St");
    }

    @Test
    public void testAddContact() {
        service.addContact(contact);
        assertEquals(contact, service.getContact(contact.getContactId()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddDuplicateContact() {
        service.addContact(contact);
        service.addContact(contact); // Should throw exception
    }

    @Test
    public void testDeleteContact() {
        service.addContact(contact);
        service.deleteContact(contact.getContactId());
        assertNull(service.getContact(contact.getContactId()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeleteNonExistingContact() {
        service.deleteContact("nonExistingId");
    }

    @Test
    public void testUpdateContact() {
        service.addContact(contact);
        service.updateContact(contact.getContactId(), "John", "Smith", "0987654321", "456 Elm St");
        Contact updatedContact = service.getContact(contact.getContactId());
        assertNotNull(updatedContact);
        assertEquals("John", updatedContact.getFirstName());
        assertEquals("Smith", updatedContact.getLastName());
        assertEquals("0987654321", updatedContact.getPhone());
        assertEquals("456 Elm St", updatedContact.getAddress());
    }

}
