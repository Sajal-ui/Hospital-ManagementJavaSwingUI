package Adminsitration;

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

public class Request implements ActionListener{
    Frame_Create frame;
	JTextField t1;
	JTextField t2;
	JButton b1;
	JButton b2;
	JButton b3;
	public Request() {
      JLabel l1=new JLabel();
      Icon i=new ImageIcon(getClass().getResource("/Image/back.jpg"));
      t1=new JTextField();
      l1.setBounds(70,50,130,30);
      l1.setText("Request::");
      t1.setBounds(210,50,120,30);
      JLabel l2=new JLabel();
      t2=new JTextField();
      l2.setBounds(70, 90,130,30);
      l2.setText("Request For::");
      t2.setBounds(210,90,120,30);
      b1=new JButton();
      b1.setBounds(120,130,120,30);
      b1.setText("Complete IT");
      b1.setFocusable(false);
      b1.addActionListener(this);
      b2=new JButton();
      b3=new JButton();
      b2.setBounds(250,0,130,40);
      b2.setText("Requests");
      b2.setFocusable(false);
      b2.addActionListener(this);
      b3.setIcon(i);
  	  b3.setFocusable(false);
  	   //b5.setForeground(Color.cyan);
  	  b3.setBounds(0, 0, 40, 40);
  	  b3.setBorderPainted(false);
  	   //b5.setBackground(Color.BLACK);
  	  b3.addActionListener(this);
      frame=new Frame_Create();
      frame.setSize(400,230);
      frame.add(l1);
      frame.add(t1);
      frame.add(l2);
      frame.add(t2);
      frame.add(b1);
      frame.add(b2);
      frame.add(b3);
      frame.setVisible(true);
   }

   @Override
   public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	  if(e.getSource()==b2) 
	  {
		  try {
	    	  Connection con=CP.createC();
	    	  String query="select Needed,Needed_to,Quantity,D_o_request from Request";
	    	  PreparedStatement p=con.prepareStatement(query);
	    	  ResultSet rs=p.executeQuery();
	    	  while(rs.next()) {
	    		  String n1=rs.getString("Needed");
	    		  String n2=rs.getString("Needed_to");
	    		  String n3=rs.getString("Quantity");
	    		  String n4=rs.getString("D_o_request");
	    		  System.out.println("Needed:: "+n1);
	    		  System.out.println("Needed_to:: "+n2);
	    		  System.out.println("Quantity:: "+n3);
	    		  System.out.println("D_o_request:: "+n4);
	    		  System.out.println("--------------------------------------------");
	    	  }
	      }catch(Exception r) {
	    	  r.printStackTrace();	  
	      }
	  }
	  else if(e.getSource()==b1) {
		  String s1=t1.getText();
		  String s2=t2.getText();
		  try {
			 Connection con=CP.createC();
			 String query="delete from Request where Needed=? and Needed_to=?";
			 PreparedStatement p=con.prepareStatement(query);
			 p.setString(1,s1);
			 p.setString(2,s2);
			 p.executeUpdate();
		  }catch(Exception r) {
			  r.printStackTrace();
		  }
	  }
	  else if(e.getSource()==b3) {
		  Admin a=new Admin();
		  frame.dispose();
	  }
   }
}
