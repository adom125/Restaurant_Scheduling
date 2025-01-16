import java.awt.*;
import javax.swing.*;
public class Driver
{
    private static JFrame frameObj;
    public Driver()
    { 
	  frameObj = new JFrame();
      frameObj.setTitle("Resturant Employee Scheduling System");
      Dimension dimObj = frameObj.getMaximumSize();
      FunctionalDesign designObj = new FunctionalDesign();
      FunctionalDesign labelObj = new FunctionalDesign("Welcome Back!");
      AddAllJPanel panelObj = new AddAllJPanel(designObj.getNameButton(), designObj.getButton());
      frameObj.setSize(dimObj);
      frameObj.setLayout(new GridLayout(1, 2));

      /*
       * Organizes the Welcome Message and the different options the 
       * user can naviagte through
       */
      frameObj.add(labelObj.getWelcomeMessage());
      frameObj.add(designObj.getButtonsPanel()); 
      frameObj.setVisible(true);
    }
    public static void main(String[] args) 
	{
        /* In order to create the GUI we create a JFrame object which
            is done in this line by calling the constructor to instantiate
            the JFrame object.
         */
	  	Driver run = new Driver();
	}

}