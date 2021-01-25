import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;

public class ManageCustomer extends JFrame implements MouseListener, ActionListener
{
	private JButton addCustomerBtn, showCustomerInfoBtn, logoutBtn, backBtn, exitBtn;
	private JPanel panel;
	
	String userId;
	
	public ManageCustomer(String userId)
	{
		super("Manage Customer");
		this.setSize(800,450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.userId = userId;
		
		panel = new JPanel();
		panel.setLayout(null);
		
		addCustomerBtn = new JButton("Add Customer");
		addCustomerBtn.setBounds(245, 150, 150, 30);
		addCustomerBtn.setBackground(Color.GREEN);
		addCustomerBtn.addMouseListener(this);
		addCustomerBtn.addActionListener(this);
		panel.add(addCustomerBtn);
		
		showCustomerInfoBtn = new JButton("Customer Info");
		showCustomerInfoBtn.setBounds(405, 150, 150, 30);
		showCustomerInfoBtn.setBackground(Color.GRAY);
		showCustomerInfoBtn.addMouseListener(this);
		showCustomerInfoBtn.addActionListener(this);
		panel.add(showCustomerInfoBtn);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(295, 200, 100, 30);
		backBtn.setBackground(Color.RED);
		backBtn.addMouseListener(this);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(650, 20, 100, 30);
		logoutBtn.setBackground(Color.YELLOW);
		logoutBtn.addMouseListener(this);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		exitBtn = new JButton("Exit");
		exitBtn.setBounds(405, 200, 100, 30);
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
		if(me.getSource()== addCustomerBtn)
		{
			addCustomerBtn.setBackground(Color.BLUE);
			addCustomerBtn.setForeground(Color.WHITE);
		}
		else if(me.getSource()== showCustomerInfoBtn)
		{
			showCustomerInfoBtn.setBackground(Color.BLUE);
			showCustomerInfoBtn.setForeground(Color.WHITE);
		}
		else if(me.getSource()== backBtn)
		{
			backBtn.setBackground(Color.BLUE);
			backBtn.setForeground(Color.WHITE);
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
		if(me.getSource()== addCustomerBtn)
		{
			addCustomerBtn.setBackground(Color.GREEN);
			addCustomerBtn.setForeground(Color.BLACK);
		}
		else if(me.getSource()== showCustomerInfoBtn)
		{
			showCustomerInfoBtn.setBackground(Color.GRAY);
			showCustomerInfoBtn.setForeground(Color.BLACK);
		}
		else if(me.getSource()== backBtn)
		{
			backBtn.setBackground(Color.RED);
			backBtn.setForeground(Color.BLACK);
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
		
		if(text.equals(addCustomerBtn.getText()))
		{
			CustomerSignUp csu = new CustomerSignUp(userId);
			csu.setVisible(true);
			this.setVisible(false);
		}
		else if(text.equals(showCustomerInfoBtn.getText()))
		{
			//CustomerInfo ci = new CustomerInfo();
			//ci.setVisible(true);
			//this.setVisible(false);
		}
		else if(text.equals(backBtn.getText()))
		{
			EmployeeHome eh = new EmployeeHome(userId);
			eh.setVisible(true);
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
		else{}
	}
}