import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class StoredStaff
{
    private  String first;
    private  String last;
    private String title;
    private String phoneNum; //parseInt
    private static ArrayList <StoredStaff> allPeople = new ArrayList<StoredStaff>();

    public StoredStaff(String firstName, String lastName, String inTitle, String number)
    {
        first = firstName; 
        last = lastName;
        title = inTitle;
        phoneNum = number;
        allPeople.add(this);
        //get name by doing allPeople.get(i).getFirstName();
    }
    public static ArrayList <StoredStaff> getList()
    {
        return allPeople;
    }

    public String getConcatenatedName()
    {
        return first + " " + last.substring(0,1);
    }
    public String getTitle()
    {
        return title;
    }
}
