import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

public class AddAllJPanel extends JPanel implements ActionListener, KeyListener, FocusListener
{
    private String pressedButton;
	private JButton theButton;

    public AddAllJPanel(String inNameButton, JButton inButton) 
	{	             
		pressedButton = inNameButton;
		theButton = inButton;
        theButton.addActionListener(this);
        this.setBackground(Color.WHITE);
    }

    public void actionPerformed (ActionEvent e)
	{
        //Write Code Here
    }
    public void keyReleased(KeyEvent e) 
	{
        //Write Code Here
    }
    public void keyPressed(KeyEvent e) 
	{
        //Write Code Here
    }
    public void focusGained(FocusEvent e) 
	{ 
        //Write Code Here
    }

    public void focusLost(FocusEvent e) 
    {
        //Write Code Here
    }

    public void keyTyped(KeyEvent e) 
    {
        //Write Code Here
    }
}
