import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class EmployeeFrame extends JFrame implements ActionListener
{
    private final String back = "Go Back <<";
    private final String add = "Add Employee";
    private JButton goBackButton;
    private JButton addButton;
    private static JPanel allPeople;
    private static GridBagConstraints gridCons;
    private JPanel mainPanel;
    private static EmployeeFrame empFrame;

    public EmployeeFrame()
    {
        empFrame = this;
        this.setTitle("View Team");
        JLabel titleLabel = new JLabel("Manage Workers");
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        //this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        Dimension dimObj = this.getMaximumSize();
        this.setSize(dimObj);
        allPeople = new JPanel();
        mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout());
        mainPanel.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));

        goBackButton = new JButton(back);
        goBackButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        //goBackButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        goBackButton.addActionListener(this);
        goBackButton.setBackground(new Color(117, 139, 253));
        goBackButton.setOpaque(true);
        goBackButton.setBorderPainted(false);
        goBackButton.setForeground(Color.WHITE);
        goBackButton.setFocusPainted(false);

        addButton = new JButton(add);
        addButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
       // addButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        addButton.addActionListener(this);
        addButton.setBackground(new Color(174, 184, 254));
        addButton.setOpaque(true);
        addButton.setBorderPainted(false);
        addButton.setForeground(Color.WHITE);
        addButton.setFocusPainted(false);

        
        mainPanel.add(goBackButton);
        mainPanel.add(addButton);
        mainPanel.add(titleLabel);
        mainPanel.setBackground(Color.WHITE);
        allPeople.setBackground(Color.WHITE);

        allPeople.setLayout(new GridBagLayout());
        gridCons = new GridBagConstraints();
        gridCons.gridwidth = GridBagConstraints.REMAINDER;
        gridCons.fill = GridBagConstraints.HORIZONTAL;
        gridCons.insets = new Insets(5, 0, 5, 0);
       // gridCons.anchor = GridBagConstraints.NORTH;
        this.add(mainPanel);

        JScrollPane scrollBar = new JScrollPane(allPeople);
        this.add(scrollBar);
    }

    public void actionPerformed (ActionEvent e)
	{
        String buttonPressed = e.getActionCommand();	
        if(buttonPressed.equals(back))
        {
            this.setVisible(false);
        }
        if(buttonPressed.equals(add))
        {
            //BoxLayout layout = new BoxLayout(allPeople, BoxLayout.Y_AXIS);
            //allPeople.setLayout(layout);
            NewEmployee newPerson = new NewEmployee();
            newPerson.setVisible(true);
           // allPeople.add(Box.createRigidArea(new Dimension(0, 15)));

            //add a new icon to create an employee profile
        }
        //Write code
    }


    public JPanel getPanel()
    {
        return mainPanel;
    }

    public static JPanel getAllEmployees()
    {
        return allPeople;
    }
    public static GridBagConstraints getGbc ()
    {
        return gridCons;
    }
    
    public static EmployeeFrame getExistingFrame ()
    {
        return empFrame;
    }
}