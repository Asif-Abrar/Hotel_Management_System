import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;


public class Home extends JFrame implements MouseListener, ActionListener
{
	private JLabel titleLabel, imgLabel;
	private ImageIcon img;
	private JButton signUpBtn, loginBtn, exitBtn;
	private JPanel panel;
	
	public Home()
	{
		super("Hotel Management System");
		this.setSize(800,450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Color myColor = new Color(160, 240, 170);
		Font myFont = new Font("Cambria", Font.ITALIC + Font.BOLD, 30);	
		
		panel = new JPanel();
		panel.setLayout(null);
		//panel.setBackground(Color.CYAN);
		
		titleLabel = new JLabel("Welcome to Green Hotel");
		titleLabel.setBounds(180, 100, 400, 50);
		titleLabel.setFont(myFont);
		
		titleLabel.setForeground(Color.BLUE);
		panel.add(titleLabel);
		
		signUpBtn = new JButton("Sign Up");
		signUpBtn.setBounds(550, 20, 100, 30);
		signUpBtn.setBackground(Color.GREEN);
		signUpBtn.addMouseListener(this);
		signUpBtn.addActionListener(this);
		panel.add(signUpBtn);
		
		loginBtn = new JButton("Login");
		loginBtn.setBounds(650, 20, 100, 30);
		loginBtn.setBackground(Color.RED);
		loginBtn.addMouseListener(this);
		loginBtn.addActionListener(this);
		panel.add(loginBtn);
		
		exitBtn = new JButton("Exit");
		exitBtn.setBounds(650, 300, 100, 30);
		exitBtn.setBackground(Color.YELLOW);
		exitBtn.addMouseListener(this);
		exitBtn.addActionListener(this);
		panel.add(exitBtn);
		
		/*img = new ImageIcon("oop1.jpg");
		imgLabel = new JLabel(img);
		imgLabel.setBounds(280,0, 250, 140);
		panel.add(imgLabel);*/
		
		this.add(panel);
	}
	
	public void mousePressed(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}
	public void mouseClicked(MouseEvent me){}
	public void mouseEntered(MouseEvent me)
	{
		if(me.getSource()== loginBtn)
		{
			loginBtn.setBackground(Color.BLUE);
			loginBtn.setForeground(Color.WHITE);
		}
		else if(me.getSource()== signUpBtn)
		{
			signUpBtn.setBackground(Color.BLUE);
			signUpBtn.setForeground(Color.WHITE);
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
		if(me.getSource()== loginBtn)
		{
			loginBtn.setBackground(Color.GREEN);
			loginBtn.setForeground(Color.BLACK);
		}
		else if(me.getSource()== signUpBtn)
		{
			signUpBtn.setBackground(Color.RED);
			signUpBtn.setForeground(Color.BLACK);
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
		if(ae.getSource() == loginBtn)
		{
			Login l = new Login();
			l.setVisible(true);
			this.setVisible(false);
		}
		else if(ae.getSource() == signUpBtn)
		{
			SignUp su = new SignUp();
			su.setVisible(true);
			this.setVisible(false);
		}
		else if(ae.getSource() == exitBtn)
		{
			System.exit(0);
		}
		else{}
	}
}