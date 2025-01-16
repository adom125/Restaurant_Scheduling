import java.util.Calendar;
import java.util.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ScheduleFrame  extends JFrame implements ActionListener
{
    private JPanel sun;
    private JPanel mon;
    private JPanel tue;
    private JPanel wed;
    private JPanel thu;
    private JPanel fri;
    private JPanel sat;
    private final String back = "Go Back <<";
    private final String prompt = "Assign Shift";
    private final String promptI = "Remove Shift";
    private final String promptII = "Change Shift";



    public ScheduleFrame()
    {
        this.setTitle("Schedule");
        Dimension dimObj = this.getMaximumSize();
        this.setSize(dimObj);
        this.setLayout(new BorderLayout());
        JLabel scheduLabel = new JLabel("Weekly Schedule", SwingConstants.CENTER);
        LocalDate curDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/d/uuuu");
        String date = curDate.format(formatter);
        JLabel dateLabel = new JLabel(date + " " + curDate.getDayOfWeek());
        scheduLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        JPanel scheduPanel = new JPanel();
        scheduPanel.setLayout(new FlowLayout());
        JButton goBackButton = new JButton(back);
        goBackButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        goBackButton.addActionListener(this);
        goBackButton.setBackground(new Color(117, 139, 253));
        goBackButton.setOpaque(true);
        goBackButton.setBorderPainted(false);
        goBackButton.setForeground(Color.WHITE);
        goBackButton.setFocusPainted(false);
        scheduPanel.add(goBackButton);
        scheduPanel.add(scheduLabel);
        scheduPanel.add(dateLabel);
        this.add(scheduPanel, BorderLayout.NORTH);

        /*
         * Creates a panel for each day of the week where you can assign 
         * workers to shifts
         */
        Date theDate = new Date();

        int [] theDates = assignDates(theDate);

        sun = new JPanel();
        JLabel sunday = new JLabel("SUN " );
        JLabel sunDate = new JLabel(theDates[0] + "");
        //sunDate.setFont(new Font("Tahoma", Font.PLAIN, 25));
        sun.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        sun.add(sunday);
        sun.add(sunDate);

        mon = new JPanel();
        JLabel monday = new JLabel("MON " + theDates[1]);
        mon.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        mon.add(monday);

        tue = new JPanel();
        JLabel tuesday = new JLabel("TUE " + theDates[2]);
        tue.add(tuesday);
        tue.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        wed = new JPanel();
        JLabel wednesday = new JLabel("WED " + theDates[3]);
        wed.add(wednesday);
        wed.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        thu = new JPanel();
        JLabel thursday = new JLabel("THU " + theDates[4]);
        thu.add(thursday);
        thu.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        fri = new JPanel();
        JLabel friday = new JLabel("FRI " + theDates[5]);
        fri.add(friday);
        fri.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        sat = new JPanel();
        JLabel saturday = new JLabel("SAT " + theDates[6]);
        sat.add(saturday);
        sat.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JPanel weekPanel = new JPanel(new GridLayout(0,7));
        weekPanel.setBorder(new EmptyBorder(new Insets(20, 30, 20,30)));

        JPanel assignPanel = new JPanel();
        assignPanel.setLayout(new BoxLayout(assignPanel, BoxLayout.Y_AXIS));

       // JLabel teamLabel = new JLabel("TEAM");       
       // teamLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        //assignPanel.add(teamLabel);
        JButton assignShift = new JButton (prompt);
        assignShift.setFont(new Font("Tahoma", Font.PLAIN, 15));
        assignShift.addActionListener(this);
        assignShift.setBackground(new Color(117, 139, 253));
        assignShift.setOpaque(true);
        assignShift.setBorderPainted(false);
        assignShift.setForeground(Color.WHITE);
        assignShift.setFocusPainted(false);
        assignPanel.add(assignShift);


        JButton removeShift = new JButton (promptI);
        removeShift.setFont(new Font("Tahoma", Font.PLAIN, 15));
        removeShift.addActionListener(this);
        removeShift.setBackground(new Color(117, 139, 253));
        removeShift.setOpaque(true);
        removeShift.setBorderPainted(false);
        removeShift.setForeground(Color.WHITE);
        removeShift.setFocusPainted(false);
        assignPanel.add(removeShift);

        JButton changeShift = new JButton (promptII);
     /* 
        for(int i = 0; i < StoredStaff.getList().size(); i++)
        {
            JLabel addName = new JLabel (StoredStaff.getList().get(i).getConcatenatedName()); //larger text
            addName.setFont(new Font("Tahoma", Font.BOLD, 18));
            JLabel addTitle = new JLabel (StoredStaff.getList().get(i).getTitle()); //smaller text
            addTitle.setFont(new Font("Tahoma", Font.PLAIN, 15));
            JLabel space = new JLabel();
            assignPanel.add(addName);
            assignPanel.add(addTitle);
            assignPanel.add(space);
        }*/
        /* */
        //have an assign shift, change shift, remove shift
        weekPanel.add(sun);
        weekPanel.add(mon);
        weekPanel.add(tue);
        weekPanel.add(wed);
        weekPanel.add(thu);
        weekPanel.add(fri);
        weekPanel.add(sat);

        this.add(weekPanel, BorderLayout.CENTER);
        this.add(assignPanel, BorderLayout.WEST);
        //have a check isLeapYear()

        //if day equals SUNDAY/SUN Switch the numbers of the schedule
    }

    private int [] assignDates(Date theDate) 
    {
        int i = Calendar.getInstance().getFirstDayOfWeek();
        Calendar calObj = Calendar.getInstance();
        calObj.setTime(theDate);
        calObj.set(Calendar.DAY_OF_WEEK, i);
        int[] getWeek = new int[7];
        for (int j = 0; j < 7; j++) 
        {
            Date obj = calObj.getTime();
            int valueOfDay = calObj.get(Calendar.DAY_OF_MONTH);
            getWeek[j] = valueOfDay;
            calObj.add(Calendar.DAY_OF_MONTH, 1);
        }

        return getWeek;
    }

    public void actionPerformed(ActionEvent e) 
    {
        String buttonPressed = e.getActionCommand();	
        if(buttonPressed.equals(back))
        {
            this.setVisible(false);
        }
        if(buttonPressed.equals(prompt))
        {
            //find a way to set all the employees visible
            //if theres no employees put a conditon "Error: No employees in system."
            if(StoredStaff.getList().size() == 0)
            {
                JOptionPane.showMessageDialog(this,"Error: No employees in system.");
            }
            else
            {
                SelectEmployee person = new SelectEmployee();
                person.setVisible(true);    
            }

        }
        // TODO Auto-generated method stub
    }
    
}
