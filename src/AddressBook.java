import javax.swing.*;
import java.io.*;
import java.util.Scanner;
import javax.xml.parsers.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.*;


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
    public void imp(AddressBook adb) throws FileNotFoundException {
        File file = new File("Address.sav");
        Scanner sc = new Scanner(file);
        while(sc.hasNextLine()){
            String ln = sc.nextLine();
            BuddyInfo bud = null;
            adb.addElement(bud.Import(ln));
        }
    }
    public String toXML(AddressBook adB){
        String out = "<AddressBook>\n";
        for(int i=0;i<adB.size();i++){
            out += "\t<BuddyInfo>"+adB.get(i).toString()+"</BuddyInfo>\n";
        }
        out += "</AddressBook>";
        return out;
    }
    public void exportToXmLFile(String xml) throws IOException {
        FileWriter fw = new FileWriter("Address.xml");
        fw.write(xml);
        fw.close();
    }
    public void importFromXmLFile(AddressBook adb) throws Exception {
        File file = new File("Address.xml");
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser s = spf.newSAXParser();
        DefaultHandler dh = new DefaultHandler(){
            boolean budinfo = false;
            public void startElement(String u, String ln, String qName, Attributes a) throws SAXException{
                if(qName.equals("BuddyInfo")){
                    budinfo = true;
                }
            }
            public void characters(char[] ch, int start, int length) throws SAXException{
                BuddyInfo bud = null;
                if(budinfo) {
                    adb.addElement(bud.Import(new String(ch,start,length)));
                    budinfo = false;
                }
            }
        };
        s.parse(file,dh);
    }
}
