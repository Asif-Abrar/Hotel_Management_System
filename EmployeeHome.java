import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;

public class EmployeeHome extends JFrame implements MouseListener, ActionListener
{
	//private JLabel titleLabel;
	private JButton changePassBtn, showInfoBtn, manageCustomerBtn, logoutBtn, exitBtn;
	private JPanel panel;
	
	String userId;
	
	public EmployeeHome(String userId)
	{
		super("Employee Home");
		this.setSize(800,450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.userId = userId;
		
		panel = new JPanel();
		panel.setLayout(null);
		//panel.setBackground(Color.CYAN);
		
		manageCustomerBtn = new JButton("Manage Customer");
		manageCustomerBtn.setBounds(325, 150, 150, 30);
		manageCustomerBtn.setBackground(Color.GREEN);
		manageCustomerBtn.addMouseListener(this);
		manageCustomerBtn.addActionListener(this);
		panel.add(manageCustomerBtn);
		
		changePassBtn = new JButton("Change Password");
		changePassBtn.setBounds(165, 150, 150, 30);
		changePassBtn.setBackground(Color.GRAY);
		changePassBtn.addMouseListener(this);
		changePassBtn.addActionListener(this);
		panel.add(changePassBtn);
		
		showInfoBtn = new JButton("Own Info");
		showInfoBtn.setBounds(485, 150, 150, 30);
		showInfoBtn.setBackground(Color.RED);
		showInfoBtn.addMouseListener(this);
		showInfoBtn.addActionListener(this);
		panel.add(showInfoBtn);
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(650, 20, 100, 30);
		logoutBtn.setBackground(Color.YELLOW);
		logoutBtn.addMouseListener(this);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		exitBtn = new JButton("Exit");
		exitBtn.setBounds(350, 200, 100, 30);
		exitBtn.setBackground(Color.YELLOW);
		exitBtn.addMouseListener(this);
		exitBtn.addActionListener(this);
		panel.add(exitBtn);
		
		this.add(panel);
	}
	
	public void mousePressed(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}
	public void mouseClicked(MouseEvent me){}
	public void mouseEntered(MouseEvent me)
	{
		if(me.getSource()== changePassBtn)
		{
			changePassBtn.setBackground(Color.BLUE);
			changePassBtn.setForeground(Color.WHITE);
		}
		else if(me.getSource()== manageCustomerBtn)
		{
			manageCustomerBtn.setBackground(Color.BLUE);
			manageCustomerBtn.setForeground(Color.WHITE);
		}
		else if(me.getSource()== showInfoBtn)
		{
			showInfoBtn.setBackground(Color.BLUE);
			showInfoBtn.setForeground(Color.WHITE);
		}
		else if(me.getSource()== logoutBtn)
		{
			logoutBtn.setBackground(Color.BLUE);
			logoutBtn.setForeground(Color.WHITE);
		}
		else if(me.getSource()== exitBtn)
		{
			exitBtn.setBackground(Color.BLUE);
			exitBtn.setForeground(Color.WHITE);
		}
		else{}
	}
	public void mouseExited(MouseEvent me)
	{
		if(me.getSource()== changePassBtn)
		{
			changePassBtn.setBackground(Color.GRAY);
			changePassBtn.setForeground(Color.BLACK);
		}
		else if(me.getSource()== manageCustomerBtn)
		{
			manageCustomerBtn.setBackground(Color.GREEN);
			manageCustomerBtn.setForeground(Color.BLACK);
		}
		else if(me.getSource()== showInfoBtn)
		{
			showInfoBtn.setBackground(Color.RED);
			showInfoBtn.setForeground(Color.BLACK);
		}
		else if(me.getSource()== logoutBtn)
		{
			logoutBtn.setBackground(Color.YELLOW);
			logoutBtn.setForeground(Color.BLACK);
		}
		else if(me.getSource()== exitBtn)
		{
			exitBtn.setBackground(Color.YELLOW);
			exitBtn.setForeground(Color.BLACK);
		}
		else{}
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String text = ae.getActionCommand();
		
		if(text.equals(manageCustomerBtn.getText()))
		{
			ManageCustomer mc = new ManageCustomer(userId);
			mc.setVisible(true);
			this.setVisible(false);
		}
		
		else if(text.equals(showInfoBtn.getText()))
		{
			EmployeeOwnInfo si = new EmployeeOwnInfo(userId);
			si.setVisible(true);
			this.setVisible(false);
		}
		else if(text.equals(logoutBtn.getText()))
		{
			Login l = new Login();
			l.setVisible(true);
			this.setVisible(false);
		}
		else if(text.equals(exitBtn.getText()))
		{
			System.exit(0);
		}
		else if(text.equals(changePassBtn.getText()))
		{
			ChangePassword cp = new ChangePassword(userId);
			cp.setVisible(true);
			this.setVisible(false);
		}
		else{}
	}
}