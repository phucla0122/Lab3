import javax.swing.*;
import java.util.LinkedList;

public class AddressBook extends DefaultListModel<BuddyInfo> {
    public DefaultListModel<BuddyInfo> addressbook;

    public AddressBook() {
        addressbook = new DefaultListModel<>();
    }

}
