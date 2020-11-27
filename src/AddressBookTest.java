import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class AddressBookTest {

    @Test
    public void saveimport() throws IOException {
        AddressBook ab = new AddressBook();
        BuddyInfo b1 = new BuddyInfo("ab", "23 a street","2345");
        ab.addElement(b1);
        ab.save(ab);
        ab.imp(ab);
        assertEquals(b1.getDetail(),ab.lastElement().getDetail());

    }
    @Test
    public void saveimportXML() throws Exception {
        AddressBook ab = new AddressBook();
        BuddyInfo b1 = new BuddyInfo("cd","15 b street","6996");
        ab.addElement(b1);
        ab.exportToXmLFile(ab.toXML(ab));
        ab.importFromXmLFile(ab);
        assertEquals(b1.getDetail(),ab.lastElement().getDetail());
    }
}