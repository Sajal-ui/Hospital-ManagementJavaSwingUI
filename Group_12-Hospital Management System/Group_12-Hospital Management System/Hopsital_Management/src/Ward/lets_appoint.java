package Ward;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Database_connection.CP;
import Frame.Frame_Create;

public class lets_appoint implements ActionListener{
    Frame_Create frame;
	JTextField t1;
	JButton b1;
	JButton b2;
	JButton b3;
	JTextField t2;
	JTextField t3;
	public lets_appoint() {
		   frame=new Frame_Create();
	  	   JLabel l1=new JLabel();
	  	   t1=new JTextField();
	  	   t2=new JTextField();
	  	   b1=new JButton();
	  	   b2=new JButton();
	  	   b3=new JButton();
	  	   t3=new JTextField();
	  	   Icon i=new ImageIcon(getClass().getResource("/Image/back.jpg"));
	  	   JLabel l2=new JLabel();
	  	   JLabel l3=new JLabel();
	  	   l1.setBounds(90, 50, 140, 30);
	  	   l1.setText("Enter Patient ID:");
	  	   l2.setBounds(90,90,140,30);
	  	   l2.setText("Enter Room No.:");
	  	   //l3.setBounds(90, 130, 140, 30);
	  	   //l3.setText("Enter Bed No.:");
	  	   t1.setBounds(240, 50, 100,30);
	  	   t2.setBounds(240, 90, 100, 30);
	  	   //t3.setBounds(240, 130, 100, 30);
	  	   b1.setBounds(150, 140,140 ,30);
	  	   b1.setText("Done");
	  	   b1.setFocusable(false);
	  	   b1.addActionListener(this);
	  	   b2.setBounds(0, 0, 40,40);
		   b2.setIcon(i);
		   //b2.setBackground(Color.BLACK);
		   //b2.setForeground(Color.cyan);
		   b2.setFocusable(false);
		   b2.setBorderPainted(false);
		   b2.addActionListener(this);
		   b3.setBounds(240, 0, 140, 30);
		   b3.setText("Check Availability");
		   b3.setFocusable(false);
		   b3.addActionListener(this);
	  	   frame.setSize(400,220);
	  	   frame.add(l1);
	  	   frame.add(t1);
	  	   frame.add(l2);
	  	   frame.add(t2);
	  	   //frame.add(l3);
	  	   //frame.add(t3);
	  	   frame.add(b1);
	  	   frame.add(b2);
	  	   frame.add(b3);
	  	   frame.setVisible(true);
   }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b1) {
			String id=t1.getText();
			String r_no=t2.getText();
			try {
				Connection con=CP.createC();
				String query="update Patient set Room_No=?,D_O_Adm=CURRENT_DATE() where P_ID=?";
				PreparedStatement p=con.prepareStatement(query);
				p.setString(1,r_no);
				p.setString(2,id);
				p.executeUpdate();
				String q2="update wards set no_of_beds_available=no_of_beds_available - 1 where Room_no=?";
				PreparedStatement t=con.prepareStatement(q2);
				t.setString(1,r_no);
				t.executeUpdate();
			}catch(Exception r) {
				r.printStackTrace();
			}
		}
		else if(e.getSource()==b3) {
			
			try {
				Connection con=CP.createC();
				Statement st=con.createStatement();
				String query="select * from wards";
			    ResultSet rs=st.executeQuery(query);
			    while(rs.next()) {
			    	int r_no=rs.getInt("Room_no");
			    	String no_beds=rs.getString("no_of_beds_available");
			    	System.out.println("Room_no :- "+r_no);
			    	System.out.println("No_of_Beds_Available :- "+no_beds);
			    	System.out.println("-------------------------------");
			    }
			}catch(Exception r) {
				r.printStackTrace();
			}
		}
		else if(e.getSource()==b2) {
			Ward_Given w=new Ward_Given();
			w.Window();
			frame.dispose();
		}
	}
	public static void main(String [] args) {
		lets_appoint l=new lets_appoint();
	}
}
