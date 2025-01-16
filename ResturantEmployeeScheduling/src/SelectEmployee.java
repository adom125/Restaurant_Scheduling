import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class SelectEmployee extends JFrame implements ActionListener, KeyListener, ItemListener
{
    JPanel addPanel;

    public SelectEmployee()
    {
        addPanel = new JPanel();
        this.setSize(400,200);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout());
        this.setTitle("Add New Employee");
        this.setBackground(Color.WHITE);
        addPanel.setBorder(new EmptyBorder(new Insets(20, 30, 20,30)));
        addPanel.setLayout(new BoxLayout(addPanel, BoxLayout.Y_AXIS));
        ArrayList <StoredStaff> allStaff = StoredStaff.getList();
        for(int i = 0; i < allStaff.size(); i++)
        {
            JButton addButton = new JButton (allStaff.get(i).getConcatenatedName());
            addPanel.add(addButton);
        }
        this.add(addPanel);

    }
 
    public void keyReleased(KeyEvent e)
    {
     
    }
    
    public void keyTyped(KeyEvent e)
    {

    }

    public void keyPressed(KeyEvent e)
    {

    }
    public void actionPerformed(ActionEvent e)
    {
    }

    public void itemStateChanged(ItemEvent e) 
    {
    }
}
