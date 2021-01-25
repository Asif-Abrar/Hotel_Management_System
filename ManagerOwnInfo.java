import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class ManagerOwnInfo extends JFrame implements ActionListener
{
	JLabel userLabel, eNameLabel, phoneLabel, roleLabel, salaryLabel;
	JTextField userTF, phoneTF1, phoneTF2, eNameTF, roleTF, salaryTF;
	JButton  loadBtn,backBtn, logoutBtn;
	JPanel panel;
	
	String userId;
	
	public ManagerOwnInfo(String userId)
	{
		super("Manager OwnInfo");
		
		this.setSize(800, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.userId = userId;
		
		panel = new JPanel();
		panel.setLayout(null);
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(600, 50, 100, 30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		
		
		userLabel = new JLabel("User ID : ");
		userLabel.setBounds(250, 150, 120, 30);
		panel.add(userLabel);
		
		userTF = new JTextField();
		userTF.setBounds(400, 150, 120, 30);
		panel.add(userTF);
		
		loadBtn = new JButton("Load");
		loadBtn.setBounds(550, 150, 150, 30);
		loadBtn.addActionListener(this);
		panel.add(loadBtn);
		
		eNameLabel = new JLabel("Employee Name : ");
		eNameLabel.setBounds(250, 200, 120, 30);
		panel.add(eNameLabel);
		
		eNameTF = new JTextField();
		eNameTF.setBounds(400, 200, 120, 30);
		panel.add(eNameTF);
		
		phoneLabel = new JLabel("Phone No. : ");
		phoneLabel.setBounds(250, 250, 120, 30);
		panel.add(phoneLabel);
		
		phoneTF1 = new JTextField();
		phoneTF1.setBounds(400, 250, 35, 30);
		phoneTF1.setEnabled(false);
		panel.add(phoneTF1);
		
		phoneTF2 = new JTextField();
		phoneTF2.setBounds(435, 250, 85, 30);
		panel.add(phoneTF2);
		
		roleLabel = new JLabel("Role : ");
		roleLabel.setBounds(250, 300, 120, 30);
		panel.add(roleLabel);
		
		roleTF = new JTextField();
		roleTF.setBounds(400, 300, 120, 30);
		panel.add(roleTF);
		
		salaryLabel = new JLabel("Salary : ");
		salaryLabel.setBounds(250, 350, 120, 30);
		panel.add(salaryLabel);
		
		salaryTF = new JTextField();
		salaryTF.setBounds(400, 350, 120, 30);
		panel.add(salaryTF);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(500, 400, 120, 30);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String text = ae.getActionCommand();
		
		if(text.equals(backBtn.getText()))
		{
			ManagerHome me = new ManagerHome(userId);
			me.setVisible(true);
			this.setVisible(false);
		}
		
		else if(text.equals(logoutBtn.getText()))
		{
			Login lg = new Login();
			lg.setVisible(true);
			this.setVisible(false);
		}
		else if(text.equals(loadBtn.getText()))
		{
			loadFromDB();			
		}
		
		else{}
	}
	
	public void loadFromDB()
	{
		String loadId = userTF.getText();
		String query = "SELECT `employeeName`, `phoneNumber`, `role`, `salary` FROM `employee` WHERE `userId`='"+loadId+"';";     
        Connection con=null;
        Statement st = null;
		ResultSet rs = null;
		System.out.println(query);
        try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop1","root","");
			st = con.createStatement();
			rs = st.executeQuery(query);
			
			boolean flag = false;
			String eName = null;
			String phnNo = null;
			String role = null;
			double salary = 0.0;			
			while(rs.next())
			{
                eName = rs.getString("employeeName");
				phnNo = rs.getString("phoneNumber");
				role = rs.getString("role");
				salary = rs.getDouble("salary");
				flag=true;
				
				eNameTF.setText(eName);
				phoneTF1.setText("+880");
				phoneTF2.setText(phnNo.substring(4,14));
				roleTF.setText(role);
				salaryTF.setText(""+salary);
				userTF.setEnabled(false);
				
			}
			if(!flag)
			{
				eNameTF.setText("");
				phoneTF1.setText("");
				phoneTF2.setText("");
				roleTF.setText("");
				salaryTF.setText("");
				JOptionPane.showMessageDialog(this,"Invalid ID"); 
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