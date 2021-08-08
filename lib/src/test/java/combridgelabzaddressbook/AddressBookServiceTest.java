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
    @Test
    public void givenAddressBook_WhenRetrieved_ShouldMatchCountInGivenRange() throws AddressBookException {
        AddressBookJDBC addressBookJDBC = new AddressBookJDBC();
        List<Contact> addressBookData = addressBookJDBC.readAddressBookData(AddressBookJDBC.IOService.DB_IO, "2018-05-14", "2020-09-02");
        Assert.assertEquals(0, addressBookData.size());
    }
    @Test
    public void givenAddressBook_WhenRetrieved_ShouldReturnCountOfCity() throws AddressBookException {
        AddressBookJDBC addressBookJDBC = new AddressBookJDBC();
        Assert.assertEquals(2, addressBookJDBC.readAddressBookData("count", "shivamogga"));
    }
    @Test
    public void givenAddressBookDetails_WhenAdded_ShouldSyncWithDB() throws AddressBookException {
        AddressBookJDBC addressBookJDBC = new AddressBookJDBC();
        addressBookJDBC.readAddressBookData(AddressBookJDBC.IOService.DB_IO);
        addressBookJDBC.addNewContact("Sharan", "Gowdar", "SMGS", "Shivamogga", "Karnataka", "511223", "9909947866", "sharan8@gmail.com","Friend", "2020-04-09");
        boolean result = addressBookJDBC.checkUpdatedRecordSyncWithDatabase("Sharan");
        Assert.assertTrue(result);
    }
}