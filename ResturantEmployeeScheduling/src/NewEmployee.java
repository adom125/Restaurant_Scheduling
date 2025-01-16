import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class NewEmployee extends JFrame implements ActionListener, KeyListener, ItemListener
{
    private final String saveTxt = "Save";
    private JTextField first;
    private JTextField last;
    private JTextField numField;
    //add a drop down menu
    private String firstName;
    private String lastName;
    private String title;
    private String phoneNumber;
    private JButton doneButton;
    private JPanel addPanel;
    private JComboBox<String> dropDown;

    //Store all the employees in the StoredEmployees class
    public NewEmployee()
    {
        addPanel = new JPanel();
        this.setSize(400,200);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout());
        this.setTitle("Add New Employee");
        this.setBackground(Color.WHITE);
        addPanel.setBorder(new EmptyBorder(new Insets(20, 30, 20,30)));
        addPanel.setLayout(new BoxLayout(addPanel, BoxLayout.Y_AXIS));

        /*
         * Creates the text fields where the admin can enter employee information
         */
        JPanel enterInfo = new JPanel();
        enterInfo.setLayout(new BoxLayout(enterInfo, BoxLayout.X_AXIS));
        JLabel prompt = new JLabel("Please Enter Employee Information: ");
        prompt.setAlignmentX(Component.CENTER_ALIGNMENT);
        enterInfo.add(prompt);

        JPanel firstPanel = new JPanel();
        firstPanel.setLayout(new BoxLayout(firstPanel, BoxLayout.X_AXIS));
        JLabel  firstLabel = new JLabel("First Name: ");
        firstLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        first = new JTextField();
        first.setAlignmentX(Component.CENTER_ALIGNMENT);
        first.setColumns(15);
        firstPanel.add(firstLabel);
        firstPanel.add(first);

        JPanel lastPanel = new JPanel();
        lastPanel.setLayout(new BoxLayout(lastPanel, BoxLayout.X_AXIS));
        JLabel  lastLabel = new JLabel("Last Name: ");
        lastLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        last = new JTextField();
        last.setAlignmentX(Component.CENTER_ALIGNMENT);
        last.setColumns(15);
        lastPanel.add(lastLabel);
        lastPanel.add(last);

        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.X_AXIS));
        JLabel  titleLabel = new JLabel("Title: ");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        String[] roles = { "Hostess", "Server", "Busser", "Line Cook",
        "Bartender", "Runner", "Dishwasher", "Chef", "Delivery Driver", "Other" };
        dropDown = new JComboBox<String>(roles);
       // dropDown.setMaximumSize(dropDown.getPreferredSize()); 
        dropDown.setAlignmentX(Component.CENTER_ALIGNMENT);
        title = (String) dropDown.getSelectedItem();
        dropDown.addItemListener(this);
        titlePanel.add(titleLabel);
        titlePanel.add(dropDown);

        JPanel numPanel = new JPanel();
        numPanel.setLayout(new BoxLayout(numPanel, BoxLayout.X_AXIS));
        JLabel  numLabel = new JLabel("Contact: ");
        numLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        numField = new JTextField(10);
        numField.addKeyListener(this);
        numPanel.add(numLabel);
        numPanel.add(numField);

        JPanel donePanel = new JPanel();
        doneButton = new JButton (saveTxt);
        doneButton.addActionListener(this);
        donePanel.setLayout(new BoxLayout(donePanel, BoxLayout.X_AXIS));
        donePanel.add(doneButton);

        addPanel.add(enterInfo);
        addPanel.add(firstPanel);
        addPanel.add(lastPanel);
        addPanel.add(titlePanel);
        addPanel.add(numPanel);
        addPanel.add(donePanel);

        this.add(addPanel);
    }

    public void keyReleased(KeyEvent e)
    {
        if (numField.getText().length() > 10)
        {
            numField.setText((numField.getText()).substring(0,(numField.getText()).length()-1));
            JOptionPane.showMessageDialog(this,"Please Enter a 10 Digit Phone Number.");
        }
        firstName = first.getText();
        lastName = last.getText();
        phoneNumber = numField.getText();
    }
    
    public void keyTyped(KeyEvent e)
    {

    }

    public void keyPressed(KeyEvent e)
    {

    }
    public void actionPerformed(ActionEvent e)
    {
        String buttonPressed = e.getActionCommand();	

        if(buttonPressed.equals(saveTxt))
        {

            if(firstName != null && lastName != null && phoneNumber != null)
            {
                this.setVisible(false);
                JButton personButton = new JButton(getShortenedName());
                personButton.setAlignmentX(Component.CENTER_ALIGNMENT);
                personButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
                personButton.setBackground(new Color(241, 242, 246));
                personButton.setOpaque(true);
                personButton.setBorderPainted(false);
                personButton.setFocusPainted(false);
               
                EmployeeFrame.getAllEmployees().setFont(new Font("Tahoma", Font.PLAIN, 60));
                EmployeeFrame.getAllEmployees().add(personButton, EmployeeFrame.getGbc());


                StoredStaff newMember = new StoredStaff(firstName, lastName, title, phoneNumber);
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Please Fill All Fields.");
            }

        }
    }

    public String getShortenedName()
    {
        return firstName + " " + lastName.substring(0,1) + ".";
    }

    public void itemStateChanged(ItemEvent e) 
    {
        String selected = (String) dropDown.getSelectedItem();
        title = selected;
    }


}
