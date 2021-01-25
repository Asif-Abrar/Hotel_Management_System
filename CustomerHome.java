import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;

public class CustomerHome extends JFrame implements MouseListener, ActionListener
{
	//private JLabel titleLabel;
	private JButton changePassBtn, showInfoBtn, searchBtn, logoutBtn, exitBtn;
	private JPanel panel;
	
	String userId;
	
	public CustomerHome(String userId)
	{
		super("Customer Home");
		this.setSize(800,450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.userId = userId;
		
		panel = new JPanel();
		panel.setLayout(null);
		//panel.setBackground(Color.CYAN);
		
		searchBtn = new JButton("Search");
		searchBtn.setBounds(325, 150, 150, 30);
		searchBtn.setBackground(Color.GREEN);
		searchBtn.addMouseListener(this);
		searchBtn.addActionListener(this);
		panel.add(searchBtn);
		
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
		else if(me.getSource()== searchBtn)
		{
			searchBtn.setBackground(Color.BLUE);
			searchBtn.setForeground(Color.WHITE);
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
		else if(me.getSource()== searchBtn)
		{
			searchBtn.setBackground(Color.GREEN);
			searchBtn.setForeground(Color.BLACK);
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
		
		if(text.equals(changePassBtn.getText()))
		{
			ChangePassword cp = new ChangePassword(userId);
			cp.setVisible(true);
			this.setVisible(false);
		}
		else if(text.equals(searchBtn.getText()))
		{
			//Search s = new Search();
			//s.setVisible(true);
			//this.setVisible(false);
		}
		else if(text.equals(showInfoBtn.getText()))
		{
			CustomerOwnInfo si = new CustomerOwnInfo(userId);
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
		else{}
	}
}