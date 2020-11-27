import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class AddressBookFrame extends JFrame {

    public AddressBookFrame(){
        super("Lab 5");
        AddressBook adB = new AddressBook();
        JList<BuddyInfo> jList = new JList<>(adB);
        JMenuBar jMenuBar = new JMenuBar();
        JMenu addressBook = new JMenu("Address Book");
        JMenu buddyInfo = new JMenu("Buddy Info");
        JMenu menu = new JMenu("Menu");
        JMenuItem addBuddyInfo = new JMenuItem("Add Buddy");
        JMenuItem removeBuddyInfo = new JMenuItem("Remove Buddy");
        JMenuItem newAddressBook = new JMenuItem("New Address Book");
        JMenuItem displayInfo = new JMenuItem("Display Buddy Info");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem imp = new JMenuItem("Import");
        JMenuItem saveAsXML = new JMenuItem("Save as XML");
        JMenuItem importXML = new JMenuItem("Import XML");
        importXML.addActionListener(e->{
            try {
                adB.importFromXmLFile(adB);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        saveAsXML.addActionListener(e->{
            String XML = adB.toXML(adB);
            try {
                adB.exportToXmLFile(XML);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        imp.addActionListener(e->{
            try {
                adB.imp(adB);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        });
        save.addActionListener(e->{
            try {
                adB.save(adB);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
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
        jMenuBar.add(menu);
        jMenuBar.add(addressBook);
        jMenuBar.add(buddyInfo);
        jMenuBar.setVisible(true);
        menu.add(save);
        menu.add(saveAsXML);
        menu.add(imp);
        menu.add(importXML);
        addressBook.add(newAddressBook);
        addressBook.add(displayInfo);
        buddyInfo.add(addBuddyInfo);
        buddyInfo.add(removeBuddyInfo);
        this.setJMenuBar(jMenuBar);
        this.setSize(500, 500);
        this.setVisible(true);
    }
    public static void main(String[] args){
        new AddressBookFrame();
    }
}
