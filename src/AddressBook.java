import javax.swing.*;
import java.io.*;
import java.util.LinkedList;

public class AddressBook extends DefaultListModel<BuddyInfo> {
    public DefaultListModel<BuddyInfo> addressbook;

    public AddressBook() {
        addressbook = new DefaultListModel<>();
    }
    public void save(AddressBook adb) throws IOException {
        FileWriter fw = new FileWriter("Address.sav");
        for(int i=0;i<adb.size();i++){
            fw.write(adb.get(i).toString()+"\n");
        }
        fw.close();
    }
}
