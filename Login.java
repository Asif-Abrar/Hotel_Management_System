import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements MouseListener, ActionListener
{
	private JLabel titleLabel, userLabel, passLabel;
	private JTextField userTF;
	private JPasswordField passPF;
	private JButton loginBtn, exitBtn;
	private JPanel panel;
	
	public Login()
	{
		super("Login");
		this.setSize(800,450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Color myColor = new Color(160, 240, 170);
		Font myFont = new Font("Cambria",Font.BOLD, 30);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		titleLabel = new JLabel("Login");
		titleLabel.setBounds(350, 50, 100, 50);
		titleLabel.setFont(myFont);
		titleLabel.setForeground(Color.BLUE);
		panel.add(titleLabel);
		
		userLabel = new JLabel("UserID: ");
		userLabel.setBounds(300, 150, 100, 30);
		panel.add(userLabel);
		
		userTF = new JTextField("Username");
		userTF.setBounds(400, 150, 150, 30);
		userTF.addMouseListener(this);
		userTF.setBackground(myColor);
		panel.add(userTF);
		
		passLabel = new JLabel("Password : ");
		passLabel.setBounds(300,200, 100, 30);
		panel.add(passLabel);
		
		passPF = new JPasswordField();
		passPF.setBounds(400, 200, 150, 30);
		passPF.setBackground(myColor);
		panel.add(passPF);
		
		loginBtn = new JButton("Login");
		loginBtn.setBounds(295, 250, 100, 30);
		loginBtn.setBackground(Color.GREEN);
		loginBtn.addMouseListener(this);
		loginBtn.addActionListener(this);
		panel.add(loginBtn);
		
		exitBtn = new JButton("Exit");
		exitBtn.setBounds(405, 250, 100, 30);
		exitBtn.setBackground(Color.RED);
		exitBtn.addMouseListener(this);
		exitBtn.addActionListener(this);
		panel.add(exitBtn);
		
		this.add(panel);
	}
	
	public void mousePressed(MouseEvent me){ }
	public void mouseReleased(MouseEvent me){ }
	public void mouseClicked(MouseEvent me)
	{
		if(me.getSource()== userTF)
		{
			userTF.setText("");
		}
		else{}
	}
	public void mouseEntered(MouseEvent me)
	{
		if(me.getSource()== loginBtn)
		{
			loginBtn.setBackground(Color.BLUE);
			loginBtn.setForeground(Color.WHITE);
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
		else if(me.getSource()== exitBtn)
		{
			exitBtn.setBackground(Color.RED);
			exitBtn.setForeground(Color.BLACK);
		}
		else{}
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String text = ae.getActionCommand();
		
		if(text.equals(loginBtn.getText()))
		{
			checkLogin();
		}
		else if(text.equals(exitBtn.getText()))
		{
			System.exit(0);
		}
		else{}
	}
	
	public void checkLogin()
	{
		String query = "SELECT `userId`, `password`, `status` FROM `login`;";     
        Connection con=null;
        Statement st = null;
		ResultSet rs = null;
		System.out.println(query);
        
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver loaded");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop1","root","");
			System.out.println("connection done");
			st = con.createStatement();
			System.out.println("statement created");
			rs = st.executeQuery(query);
			System.out.println("results received");
			
			boolean flag = false;			
			while(rs.next())
			{
                String userId = rs.getString("userId");
				String password = rs.getString("password");
				int status = rs.getInt("status");
				
				if(userId.equals(userTF.getText()) && password.equals(passPF.getText()))
				{
					flag=true;
					if(status==0)
					{
					   
						ManagerHome mh = new ManagerHome(userId);
						mh.setVisible(true);
						this.setVisible(false);
					}
					else if(status==1)
					{
						 EmployeeHome eh = new EmployeeHome(userId);
						eh.setVisible(true);
						this.setVisible(false);
						
					}
					else if(status==2)
					{
						CustomerHome ch = new CustomerHome(userId);
						ch.setVisible(true);
						this.setVisible(false);
					}
					else{}
				}
			}
			if(!flag)
			{
				JOptionPane.showMessageDialog(this,"Invalid ID or Password"); 
			}
		}
        catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
        }
        finally
		{
            try
			{
                if(rs!=null)
					rs.close();

                if(st!=null)
					st.close();

                if(con!=null)
					con.close();
            }
            catch(Exception ex){}
        }
	}
}
