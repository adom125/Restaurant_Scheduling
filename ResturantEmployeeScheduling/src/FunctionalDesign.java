import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/*This will be the main panel that organizes the interface for the 
 * scheduling system
 */
public class FunctionalDesign extends JPanel implements ActionListener
{
    private final String employeeTxt = "View Team";
    private final String schedudleTxt = "  Schedule  ";
    private static boolean frameExists;
    private String welcomeMessage;
    private JPanel messagePanel;
    private JPanel thePanel;
    private JPanel imagePanel;
    private JButton viewButton;
    private JButton scheduleButton;

    public FunctionalDesign()
    {
        thePanel = new JPanel();
        BoxLayout layout = new BoxLayout(thePanel, BoxLayout.Y_AXIS);
        thePanel.setLayout(layout);
        thePanel.setBorder(new EmptyBorder(new Insets(250, 200, 10, 200)));

        viewButton = new JButton(employeeTxt);
        viewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        scheduleButton = new JButton(schedudleTxt);
        scheduleButton.setFont(new Font("Tahoma", Font.PLAIN, 20));

        viewButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        viewButton.setBackground(new Color(39, 24, 126));
        viewButton.setOpaque(true);
        viewButton.setBorderPainted(false);
        viewButton.setForeground(Color.WHITE);
        viewButton.setFocusPainted(false);

        scheduleButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        scheduleButton.setBackground(new Color(174, 184, 254));
        scheduleButton.setOpaque(true);
        scheduleButton.setBorderPainted(false);
        scheduleButton.setForeground(Color.WHITE);
        scheduleButton.setFocusPainted(false);

        viewButton.addActionListener(this);
        scheduleButton.addActionListener(this);

        thePanel.add(Box.createRigidArea(new Dimension(0, 30)));
        thePanel.add(viewButton);
        thePanel.add(Box.createRigidArea(new Dimension(0, 30)));
        thePanel.add(scheduleButton);
        thePanel.setBackground(Color.WHITE);
        //three buttons
        //"View Employee's"
        //  - "Add New Employee"
        //"Schedule"
        //monthly and weekly
        //Set the resturant hours 
    }

    public FunctionalDesign(String inMessage)
    {
        welcomeMessage = inMessage;
        messagePanel = new JPanel();
        messagePanel.setBorder(new EmptyBorder(new Insets(200, 200, 300, 200)));
        JLabel theLabel = new JLabel(inMessage, JLabel.CENTER);
        theLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        theLabel.setForeground(Color.WHITE);
        messagePanel.setBackground(new Color(117, 139, 253));

        JLabel quoteLabel = new JLabel("A better way to schedule for your restaurant", JLabel.LEFT);
        quoteLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        quoteLabel.setForeground(Color.WHITE);
        
        JLabel imageLabel = new JLabel("");
        Image insertImage = new ImageIcon(this.getClass().getResource("CustomLogo.png")).getImage();
        Image resizedImage = insertImage.getScaledInstance(310, 310, java.awt.Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(resizedImage));
        // imageLabel.setBounds(100, 20,100,500);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        messagePanel.add(theLabel);
        messagePanel.add(imageLabel);
        messagePanel.add(quoteLabel);
    }
   
    public void actionPerformed (ActionEvent e)
	{
        String buttonPressed = e.getActionCommand();	
        if(buttonPressed.equals(employeeTxt))
        {
            if(frameExists == false)
            {
                EmployeeFrame viewFrame = new EmployeeFrame();
                frameExists = true;
                viewFrame.setLayout(new BorderLayout());
                viewFrame.add(viewFrame.getPanel(), BorderLayout.NORTH);
                viewFrame.add(viewFrame.getAllEmployees(), BorderLayout.CENTER);
                viewFrame.setVisible(true);
            }
            else
            {
                /*
                 * This makes the employees already added accesible and viewable once the user
                 * hits the "Go Back" button, the employees added in the EmployeeFrame are saved.
                 */
                EmployeeFrame.getExistingFrame().setVisible(true);
            }
            
            /*
             * Opens a new page that the user can view all employees and 
             * upon hitting the "View Team" button.
             */
        }
        if(buttonPressed.equals(schedudleTxt))
        {
            ScheduleFrame schedFrame = new ScheduleFrame();
            schedFrame.setVisible(true);
            
        }
        //Write Code Here
    }
    public JPanel getButtonsPanel()
    {
        return thePanel;
    }
    public String getNameButton()
    {
    	return employeeTxt;
    }
    public JButton getButton()
    {
    	return viewButton;
    }

    public JPanel getWelcomeMessage() 
    {
        return messagePanel;
    }

    public Component getImagePanel() 
    {
        return imagePanel;
    }
}
