package Medicines;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import Database_connection.CP;
import Frame.Frame_Create;

public class New_Medicine implements ActionListener{
   Frame_Create frame;
   JTextField t1;
   JButton b1;
   JButton b2;
   public New_Medicine() {
	   JLabel l1=new JLabel();
	   t1=new JTextField();
	   b1=new JButton();
	   b2=new JButton();
	   Icon i=new ImageIcon(getClass().getResource("/Image/back.jpg"));
	   l1.setBounds(10,60,130,30);
	   l1.setText("Enter Medicine Name");
	   t1.setBounds(150, 60,160,30);
	   frame=new Frame_Create();
	   b1.setBounds(70,120,180,30);
	   b1.setText("Search For Medicine");
	   b1.setFocusable(false);
	   b1.addActionListener(this);
	   b2.setBounds(0,0,40,40);
	   b2.setIcon(i);
	   //b2.setBackground(Color.BLACK);
	   //b2.setForeground(Color.cyan);
	   b2.setBorderPainted(false);
	   b2.setFocusable(false);
	   b2.addActionListener(this);
	   frame.setLayout(null);
	   frame.setSize(340,230);
	   frame.add(l1);
	   frame.add(t1);
	   frame.add(b1);
	   frame.add(b2);
	   frame.setVisible(true);
	   frame.setFocusable(true);
   }
   public static void main(String [] args) {
	  New_Medicine n= new New_Medicine();   
   }
   @Override
   public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	   if(e.getSource()==b1) {
		   String med=t1.getText();
		   try 
		   {
			 Connection con=CP.createC();
			 String query="select * from Pharmacy where Med_Name=?";
			 PreparedStatement p=con.prepareStatement(query);
			 p.setString(1,med);
			 ResultSet rs=p.executeQuery();
			 while(rs.next()) 
			 {
			    int id=rs.getInt("Med_ID");
			    String name=rs.getString("Med_Name");
			    int quantity=rs.getInt("Quantity_per_packet");
			    if(quantity>0) {
			    	System.out.println("Med_ID :- "+id);
			        System.out.println("Med_Name :- "+name);
			        System.out.println("----------------------------------");
			    }
			    else {
			    	System.out.println("The Medicine is not in Quantity");
			    }
			 }
		   }catch(Exception rt) {
			   rt.printStackTrace();
		   }
       frame.dispose();
	   }
     }
}
  
