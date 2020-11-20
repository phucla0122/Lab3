import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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
    public static BuddyInfo Import(String str){
        String [] info = str.split("#");
        return new BuddyInfo(info[0],info[1],info[2]);
    }

    @Override
    public String toString() {
        return getName()+"#"+getAddress()+"#"+getPhonenum();
    }
}

