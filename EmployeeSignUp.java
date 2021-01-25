import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;
import java.sql.*;

public class EmployeeSignUp extends JFrame implements MouseListener, ActionListener
{
	private JLabel titleLabel, nameLabel, emailLabel, phoneLabel, addressLabel, userLabel, passLabel, salaryLabel, roleLabel;
	private JTextField nameTF, emailTF, phoneTF1, phoneTF2, addressTF, userTF, salaryTF;
	private JPasswordField passPF;
	private JButton signUpBtn, backBtn, exitBtn;
	private JComboBox roleCombo;
	private JPanel panel;
	
	String userId;
	
	public EmployeeSignUp(String userId)
	{
		super("Employee SignUp");
		this.setSize(800,450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.userId = userId;
		
		Color myColor = new Color(160, 240, 170);
		Font myFont = new Font("Cambria",Font.BOLD, 20);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		titleLabel = new JLabel("Employee SignUp");
		titleLabel.setBounds(325, 50, 200, 30);
		titleLabel.setFont(myFont);
		titleLabel.setForeground(Color.BLUE);
		panel.add(titleLabel);
		
		nameLabel = new JLabel("Name: ");
		nameLabel.setBounds(100, 100, 100, 30);
		panel.add(nameLabel);
		
		nameTF = new JTextField();
		nameTF.setBounds(200, 100, 150, 30);
		nameTF.setBackground(myColor);
		panel.add(nameTF);
		
		roleLabel = new JLabel("Role : ");
		roleLabel.setBounds(450, 100, 100, 30);
		panel.add(roleLabel);
		
		String roleItems[] = new String[]{"Manager", "General"};
		roleCombo = new JComboBox(roleItems);
		roleCombo.setBounds(550, 100, 150, 30);
		panel.add(roleCombo);
		
		phoneLabel = new JLabel("Phone: ");
		phoneLabel.setBounds(100, 150, 100, 30);
		panel.add(phoneLabel);
		
		phoneTF1 = new JTextField("+880");
		phoneTF1.setBounds(200, 150, 35, 30);
		phoneTF1.setEnabled(false);
		panel.add(phoneTF1);
		
		phoneTF2 = new JTextField();
		phoneTF2.setBounds(235, 150, 115, 30);
		phoneTF2.setBackground(myColor);
		panel.add(phoneTF2);
		
		salaryLabel = new JLabel("Salary: ");
		salaryLabel.setBounds(450, 150, 100, 30);
		panel.add(salaryLabel);
		
		salaryTF = new JTextField();
		salaryTF.setBounds(550, 150, 150, 30);
		salaryTF.setBackground(myColor);
		panel.add(salaryTF);
		
		userLabel = new JLabel("UserID: ");
		userLabel.setBounds(100, 200, 100, 30);
		panel.add(userLabel);
		
		userTF = new JTextField();
		userTF.setBounds(200, 200, 150, 30);
		userTF.setBackground(myColor);
		panel.add(userTF);
		
		passLabel = new JLabel("Password : ");
		passLabel.setBounds(450,200, 100, 30);
		panel.add(passLabel);
		
		passPF = new JPasswordField();
		passPF.setBounds(550, 200, 150, 30);
		passPF.setBackground(myColor);
		panel.add(passPF);
		
		signUpBtn = new JButton("SignUp");
		signUpBtn.setBounds(350, 300, 100, 30);
		signUpBtn.setBackground(Color.GREEN);
		signUpBtn.addMouseListener(this);
		signUpBtn.addActionListener(this);
		panel.add(signUpBtn);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(240, 300, 100, 30);
		backBtn.setBackground(Color.GRAY);
		backBtn.addMouseListener(this);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		exitBtn = new JButton("Exit");
		exitBtn.setBounds(460, 300, 100, 30);
		exitBtn.setBackground(Color.RED);
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
		if(me.getSource()== signUpBtn)
		{
			signUpBtn.setBackground(Color.BLUE);
			signUpBtn.setForeground(Color.WHITE);
		}
		else if(me.getSource()== exitBtn)
		{
			exitBtn.setBackground(Color.BLUE);
			exitBtn.setForeground(Color.WHITE);
		}
		else if(me.getSource()== backBtn)
		{
			backBtn.setBackground(Color.BLUE);
			backBtn.setForeground(Color.WHITE);
		}
		else{}
	}
	public void mouseExited(MouseEvent me)
	{
		if(me.getSource()== signUpBtn)
		{
			signUpBtn.setBackground(Color.GREEN);
			signUpBtn.setForeground(Color.BLACK);
		}
		else if(me.getSource()== exitBtn)
		{
			exitBtn.setBackground(Color.RED);
			exitBtn.setForeground(Color.BLACK);
		}
		else if(me.getSource()== backBtn)
		{
			backBtn.setBackground(Color.GRAY);
			backBtn.setForeground(Color.BLACK);
		}
		else{}
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String text = ae.getActionCommand();
		
		if(text.equals(signUpBtn.getText()))
		{
			insertIntoDB();
		}
		else if(text.equals(exitBtn.getText()))
		{
			System.exit(0);
		}
		else if(text.equals(backBtn.getText()))
		{
			ManageEmployee me = new ManageEmployee(userId);
			me.setVisible(true);
			this.setVisible(false);
		}
		else{}
	}
	public void insertIntoDB()
	{
		String newId = userTF.getText();
		String newPass = passPF.getText();
		String eName = nameTF.getText();
		String phnNo = phoneTF1.getText()+phoneTF2.getText();
		String role = roleCombo.getSelectedItem().toString();
		double salary = Double.parseDouble(salaryTF.getText());
		int status = 0;
		
		
		String query1 = "INSERT INTO employee VALUES ('"+newId+"','"+eName+"','"+ phnNo+"','"+role+"',"+salary+");";
		String query2 = "INSERT INTO login VALUES ('"+newId+"','"+newPass+"',"+status+");";
		System.out.println(query1);
		System.out.println(query2);
        
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop1", "root", "");
			Statement stm = con.createStatement();
			stm.execute(query1);
			stm.execute(query2);
			stm.close();
			con.close();
			JOptionPane.showMessageDialog(this, "Success !!!");
		}
        catch(Exception ex)
		{
			JOptionPane.showMessageDialog(this, "Oops !!!");
        }
    }	
}
