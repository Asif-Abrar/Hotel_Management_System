import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;

public class ManageEmployee extends JFrame implements MouseListener, ActionListener
{
	private JButton addEmployeeBtn, showEmployeeInfoBtn, logoutBtn, backBtn, exitBtn;
	private JPanel panel;
	
	String userId;
	
	public ManageEmployee(String userId)
	{
		super("Manage Employee");
		this.setSize(800,450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.userId = userId;
		
		panel = new JPanel();
		panel.setLayout(null);
		
		addEmployeeBtn = new JButton("Add Employee");
		addEmployeeBtn.setBounds(245, 150, 150, 30);
		addEmployeeBtn.setBackground(Color.GREEN);
		addEmployeeBtn.addMouseListener(this);
		addEmployeeBtn.addActionListener(this);
		panel.add(addEmployeeBtn);
		
		showEmployeeInfoBtn = new JButton("Employee Info");
		showEmployeeInfoBtn.setBounds(405, 150, 150, 30);
		showEmployeeInfoBtn.setBackground(Color.GRAY);
		showEmployeeInfoBtn.addMouseListener(this);
		showEmployeeInfoBtn.addActionListener(this);
		panel.add(showEmployeeInfoBtn);
		
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
		if(me.getSource()== addEmployeeBtn)
		{
			addEmployeeBtn.setBackground(Color.BLUE);
			addEmployeeBtn.setForeground(Color.WHITE);
		}
		else if(me.getSource()== showEmployeeInfoBtn)
		{
			showEmployeeInfoBtn.setBackground(Color.BLUE);
			showEmployeeInfoBtn.setForeground(Color.WHITE);
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
		if(me.getSource()== addEmployeeBtn)
		{
			addEmployeeBtn.setBackground(Color.GREEN);
			addEmployeeBtn.setForeground(Color.BLACK);
		}
		else if(me.getSource()== showEmployeeInfoBtn)
		{
			showEmployeeInfoBtn.setBackground(Color.GRAY);
			showEmployeeInfoBtn.setForeground(Color.BLACK);
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
		
		if(text.equals(addEmployeeBtn.getText()))
		{
			EmployeeSignUp esu = new EmployeeSignUp(userId);
			esu.setVisible(true);
			this.setVisible(false);
		}
		else if(text.equals(showEmployeeInfoBtn.getText()))
		{
			//table
		}
		else if(text.equals(backBtn.getText()))
		{
			ManagerHome mh = new ManagerHome(userId);
			mh.setVisible(true);
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