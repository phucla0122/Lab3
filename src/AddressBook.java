import java.util.LinkedList;

public class AddressBook {
    public LinkedList<BuddyInfo> addressbook;

    public AddressBook() {
        addressbook = new LinkedList<BuddyInfo>();
    }

    /**
     * This method add a friend's informataion into the address book
     * @param buddy is the information of the friend
     */
    private void addBuddy(BuddyInfo buddy) {
        addressbook.add(buddy);
    }


    /**
     * This method remove the first friend's information in the address book
     */
    private BuddyInfo removeBuddy(){
       return addressbook.pop();
    }

    public static void main(String[] args) {
        BuddyInfo rob = new BuddyInfo("Robell", "Somewhere in greensboro", "613 - the rest saved in my phone");
        BuddyInfo pou = new BuddyInfo("Pouya", "5 mins away from me", " 613 - the rest saved in my phone");
        BuddyInfo josh = new BuddyInfo("Joshua", "Opposite to Walmart SK", " 613 - the rest saved in my phone");
        BuddyInfo temp, temp2, temp3, temp4;
        AddressBook addressBook = new AddressBook();
        addressBook.addBuddy(rob);
        addressBook.addBuddy(pou);
        temp = addressBook.removeBuddy();
        addressBook.addBuddy(rob);
        temp2 = addressBook.removeBuddy();
        temp3 = addressBook.removeBuddy();
        temp4 = addressBook.removeBuddy();
        System.out.println("Name: "+ temp.getName() + " Address: " + temp.getAddress() + " Phone#: " + temp.getPhonenum());
        System.out.println("Name: "+ temp2.getName() + " Address: " + temp2.getAddress() + " Phone#: " + temp2.getPhonenum());
        System.out.println("Name: "+ temp4.getName() + " Address: " + temp4.getAddress() + " Phone#: " + temp4.getPhonenum());

    }
}
