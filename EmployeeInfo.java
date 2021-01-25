import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.table.*;


public class EmployeeInfo extends JFrame
{
	private JTable myTable;
	private JScrollPane tableScrollPane;
	private JPanel panel;
	
	
	public EmployeeInfo()
	{
		super("Employee Info ");
		this.setSize(800,450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		DefaultTableModel model = new DefaultTableModel(new String[]{"userId", "employeeName", "phoneNumber", "role", "salary"}, 0);
	 
        String query = "SELECT * FROM `employee`;";      
        Connection con=null;//for connection
        Statement st = null;//for query execution
		ResultSet rs = null;//to get row by row result from DB
		System.out.println(query);
        try
		{
			Class.forName("com.mysql.jdbc.Driver");//load driver
			System.out.println("driver loaded");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop1","root","");
			System.out.println("connection done");//connection with database established
			st = con.createStatement();//create statement
			System.out.println("statement created");
			rs = st.executeQuery(query);//getting result
			System.out.println("results received");
					
			while(rs.next())
			{
                String userId = rs.getString("userId");
                String ename = rs.getString("employeeName");
				String phnNumber = rs.getString("phoneNumber");
				String role = rs.getString("role");
				double salary = rs.getDouble("salary");
				System.out.println("User: " +userId);
				System.out.println("Password: " +ename);
				System.out.println("AccountNumber: " +phnNumber);
				System.out.println("AccountHolderName: " +role);
				System.out.println("Balance: " +salary);
				model.addRow(new Object[]{userId, ename, phnNumber, role, salary});
				
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
    


		/*String [][]row = {{"ABCD", "DEFG", "IJKL"},
					     {"XYZ", "UVW", "MNO"},
						 {"ABCD", "DEFG", "IJKL"},
					     {"XYZ", "UVW", "MNO"},
						 {"ABCD", "DEFG", "IJKL"},
					     {"XYZ", "UVW", "MNO"},
						 {"ABCD", "DEFG", "IJKL"},
					     {"XYZ", "UVW", "MNO"}};
						 */
		//String []col = {"Col1", "Col2", "Col3"};
		
		myTable = new JTable();
		myTable.setMode(model);
		panel.add(myTable);
		
		
		tableScrollPane = new JScrollPane(myTable);
		tableScrollPane.setBounds(50,50,300,100);
		panel.add(tableScrollPane);
		
		this.add(panel);
	}
	
	public static void main(String args[])
	{
		EmployeeInfo td = new EmployeeInfo();
		td.setVisible(true);
	}
}