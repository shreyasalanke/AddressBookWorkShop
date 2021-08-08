package combridgelabzaddressbook;


import org.junit.Assert;
import org.junit.Test;
import java.util.List;
public class AddressBookServiceTest
{
    @Test
    public void givenAddressBookContactsInDB_WhenRetrieved_ShouldMatchContactsCount() throws AddressBookException {
        AddressBookJDBC addressbookJDBC = new AddressBookJDBC();
        List<Contact> addressbook = addressbookJDBC.readAddressBookData(AddressBookJDBC.IOService.DB_IO);
        Assert.assertSame(3, addressbook);
    }
    @Test
    public void givenAddressBook_WhenUpdate_ShouldSyncWithDB() throws AddressBookException {
        AddressBookJDBC addressBookJDBC = new AddressBookJDBC();
        addressBookJDBC.updateRecord("Shreya", "NJP Layout");
        boolean result = addressBookJDBC.checkUpdatedRecordSyncWithDatabase("Shreya");
        Assert.assertTrue(result);
    }
}
