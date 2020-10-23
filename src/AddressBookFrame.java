import javax.swing.*;

public class AddressBookFrame extends JFrame {

    public AddressBookFrame() {
        super("Lab 5");
        AddressBook adB = new AddressBook();
        JList<BuddyInfo> jList = new JList<>(adB);
        //adB.addElement(new BuddyInfo("Rob","123","4666"));
        JMenuBar jMenuBar = new JMenuBar();
        JMenu addressBook = new JMenu("Address Book");
        JMenu buddyInfo = new JMenu("Buddy Info");
        JMenuItem addBuddyInfo = new JMenuItem("Add Buddy");
        JMenuItem removeBuddyInfo = new JMenuItem("Remove Buddy");
        JMenuItem newAddressBook = new JMenuItem("New Address Book");
        JMenuItem displayInfo = new JMenuItem("Display Buddy Info");
        addBuddyInfo.addActionListener(e -> {
            String name, address, phone;
            name = JOptionPane.showInputDialog("Enter contact's mame: ", null);
            address = JOptionPane.showInputDialog("Enter contact's address: ", null);
            phone = JOptionPane.showInputDialog("Enter contact's phone number: ", null);
            adB.addElement(new BuddyInfo(name,address,phone));
        });
        removeBuddyInfo.addActionListener(e -> {
            if(jList.getSelectedValue()==null){
                JOptionPane.showMessageDialog(this,"You have not specify which info you want to delete.");
            }else {
                adB.removeElement(jList.getSelectedValue());
            }
        });
        newAddressBook.addActionListener(e -> {
            adB.clear();
        });
        displayInfo.addActionListener(e -> {
            if(jList.getSelectedValue()==null){
                JOptionPane.showMessageDialog(this,"You have not specify which info you want to display.");
            }else {
                String detail = adB.get(jList.getSelectedIndex()).getDetail();
                JOptionPane.showMessageDialog(this, detail);
            }
        });
        jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(jList);
        jMenuBar.add(addressBook);
        jMenuBar.add(buddyInfo);
        jMenuBar.setVisible(true);
        addressBook.add(newAddressBook);
        addressBook.add(displayInfo);
        buddyInfo.add(addBuddyInfo);
        buddyInfo.add(removeBuddyInfo);
        this.setJMenuBar(jMenuBar);
        this.setSize(500, 500);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new AddressBookFrame();
    }
}
