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

public class Assign_D implements ActionListener{
   Frame_Create frame;
   JTextField t1;
   JTextField t2;
   JButton b1;
   JButton b2;
   JButton b3;
   public Assign_D() {
	  JLabel l1=new JLabel();
	  l1.setBounds(80,40,120,30);
	  l1.setText("Enter Staff ID");
	  t1=new JTextField();
	  t1.setBounds(210,40,120,30);
	  JLabel l2=new JLabel();
	  Icon i=new ImageIcon(getClass().getResource("/Image/back.jpg"));
	  l2.setBounds(80,80,150,30);
	  l2.setText("Enter Assinged Room");
	  t2=new JTextField();
	  t2.setBounds(210,80,150,30);
	  b1=new JButton();
	  b2=new JButton();
	  b3=new JButton();
	  b3.setBounds(230,0,150,30);
	  b3.setText("Staff List");
	  b3.setFocusable(false);
	  b3.addActionListener(this);
	  b1.setBounds(140,120,130,30);
	  b1.setText("Assign");
	  b1.setFocusable(false);
      b1.addActionListener(this);
      b2.setIcon(i);
  	  b2.setFocusable(false);
  	   //b5.setForeground(Color.cyan);
  	  b2.setBounds(0, 0, 40, 40);
  	  b2.setBorderPainted(false);
  	   //b5.setBackground(Color.BLACK);
  	  b2.addActionListener(this);
      frame=new Frame_Create();
      frame.setSize(400,200);
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
	   String s1=t1.getText();
	   String s2=t2.getText();
	   if(e.getSource()==b1) {
		 try { 
		   Connection con=CP.createC();
		   String query="update Staff set Assigned_Ward=? where Staff_ID=?";
		   PreparedStatement p=con.prepareStatement(query);
		   p.setString(1,s1);
		   p.setString(2,s2);
		   p.executeUpdate();
	      } catch(Exception r) {
	    	  r.printStackTrace();
	      }
       }
	   else if(e.getSource()==b2) {
		   Admin h=new Admin();
		   frame.dispose();
	   }
	   else if(e.getSource()==b3) {
	       try {
	    	   Connection con=CP.createC();
	    	   String q1="select Staff_ID,Staff_Name,Prof from Staff";
	    	   PreparedStatement p=con.prepareStatement(q1);
	    	   ResultSet rs=p.executeQuery();	       
	    	   while(rs.next()) {
	    		   String id=rs.getString("Staff_ID");
	    		   String name=rs.getString("Staff_Name");
	    		   String pro=rs.getString("Prof");
	    		   System.out.println("Staff-ID:: "+id);
	    		   System.out.println("Staff-Name:: "+name);
	    		   System.out.println("Profession:: "+pro);
	    		   System.out.println("------------------------------------");
	    	    }
	       }catch(Exception r) {
	    	   r.printStackTrace();
	       }
	   }
   }	   
   public static void main(String args[]) {
	   Assign_D a=new Assign_D();
   }
}
