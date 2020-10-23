public class BuddyInfo {

    private String name, address, phonenum;

    public BuddyInfo(String name, String address, String phonenum) {
        this.name = name;
        this.address = address;
        this.phonenum = phonenum;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public String getDetail(){
        return "Name: "+ getName() +"\n Address: "+getAddress()+" \n Phone number: "+getPhonenum();
    }


    @Override
    public String toString() {
        return getName();
    }
}

