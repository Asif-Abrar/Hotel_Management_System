import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;
import java.sql.*;
public class Search extends JFrame implements MouseListener, ActionListener
{
	private JLabel titleLabel, roomLabel, quantityLabel, totalPriceLabel, priceLabel;
	private JButton confirmBtn, logoutBtn, backBtn, exitBtn;
	private JComboBox roomCombo, quantityCombo;
	private JPanel panel;
	
	public Search()
	{
		super("Search");
		this.setSize(800,450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Color myColor = new Color(160, 240, 170);
		Font myFont = new Font("Cambria", Font.BOLD, 20);
		
		panel = new JPanel();
		panel.setLayout(null);
		//panel.setBackground(Color.CYAN);
		
		titleLabel = new JLabel("Search Room");
		titleLabel.setBounds(325, 50, 150, 30);
		titleLabel.setFont(myFont);
		titleLabel.setForeground(Color.BLUE);
		//titleLabel.setOpaque(true);
		panel.add(titleLabel);
		
		roomLabel = new JLabel("Room ");
		roomLabel.setBounds(300, 100, 100, 30);
		panel.add(roomLabel);
		
		quantityLabel = new JLabel("Quantity ");
		quantityLabel.setBounds(300, 150, 100, 30);
		panel.add(quantityLabel);
		
		totalPriceLabel = new JLabel("Total Price : ");
		totalPriceLabel.setBounds(300, 200, 100, 30);
		panel.add(totalPriceLabel);
		
		priceLabel = new JLabel("0");
		priceLabel.setBounds(400, 200, 100, 30);
		panel.add(priceLabel);
		
		String roomItems[] = new String[]{"Single (5,000Tk)", "Duplex (8,000Tk)", "Triplex (10,000Tk)"};
		roomCombo = new JComboBox(roomItems);
		roomCombo.setBounds(400, 100, 150, 30);
		panel.add(roomCombo);
		
		String quantityItems[] = new String[]{"1", "2", "3", "4", "5"};
		quantityCombo = new JComboBox(quantityItems);
		quantityCombo.setBounds(400, 150, 150, 30);
		panel.add(quantityCombo);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(240, 250, 100, 30);
		backBtn.setBackground(Color.GRAY);
		backBtn.addMouseListener(this);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		confirmBtn = new JButton("Confirm");
		confirmBtn.setBounds(350, 250, 100, 30);
		confirmBtn.setBackground(Color.GREEN);
		confirmBtn.addMouseListener(this);
		confirmBtn.addActionListener(this);
		panel.add(confirmBtn);
		
		exitBtn = new JButton("Exit");
		exitBtn.setBounds(460, 250, 100, 30);
		exitBtn.setBackground(Color.RED);
		exitBtn.addMouseListener(this);
		exitBtn.addActionListener(this);
		panel.add(exitBtn);
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(650, 20, 100, 30);
		logoutBtn.setBackground(Color.YELLOW);
		logoutBtn.addMouseListener(this);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		this.add(panel);
	}
	
	public void mousePressed(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}
	public void mouseClicked(MouseEvent me){}
	public void mouseEntered(MouseEvent me)
	{
		if(me.getSource()== backBtn)
		{
			backBtn.setBackground(Color.BLUE);
			backBtn.setForeground(Color.WHITE);
		}
		else if(me.getSource()== confirmBtn)
		{
			confirmBtn.setBackground(Color.BLUE);
			confirmBtn.setForeground(Color.WHITE);
		}
		else if(me.getSource()== exitBtn)
		{
			exitBtn.setBackground(Color.BLUE);
			exitBtn.setForeground(Color.WHITE);
		}
		else if(me.getSource()== logoutBtn)
		{
			logoutBtn.setBackground(Color.BLUE);
			logoutBtn.setForeground(Color.WHITE);
		}
		else{}
	}
	public void mouseExited(MouseEvent me)
	{
		if(me.getSource()== backBtn)
		{
			backBtn.setBackground(Color.GRAY);
			backBtn.setForeground(Color.BLACK);
		}
		else if(me.getSource()== confirmBtn)
		{
			confirmBtn.setBackground(Color.GREEN);
			confirmBtn.setForeground(Color.BLACK);
		}
		else if(me.getSource()== exitBtn)
		{
			exitBtn.setBackground(Color.RED);
			exitBtn.setForeground(Color.BLACK);
		}
		else if(me.getSource()== logoutBtn)
		{
			logoutBtn.setBackground(Color.YELLOW);
			logoutBtn.setForeground(Color.BLACK);
		}
		else{}
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String text = ae.getActionCommand();
		
		if(text.equals(backBtn.getText()))
		{
			
		}
		else if(text.equals(confirmBtn.getText()))
		{
			String s1 = roomCombo.getSelectedItem().toString();
			String s2 = quantityCombo.getSelectedItem().toString();
			
			//AnotherGUI ag = new AnotherGUI(un, p, r, c, s);
			//ag.setVisible(true);
			//this.setVisible(false);
		}
		else if(text.equals(logoutBtn.getText()))
		{
			
		}
		else if(text.equals(exitBtn.getText()))
		{
			System.exit(0);
		}
		else{}
	}
	
	public static void main(String []args)
	{
		Search s = new Search();
		s.setVisible(true);
	}
}