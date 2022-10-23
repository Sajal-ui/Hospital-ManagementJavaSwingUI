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
public class Deletion implements ActionListener{
  Frame_Create frame;
  JTextField t1;
  JButton b1;
  JButton b2;
  public Deletion() {
	  JLabel l1=new JLabel();
	  t1=new JTextField();
	  b1=new JButton();
	  b2=new JButton();
	  Icon i=new ImageIcon(getClass().getResource("/Image/back.jpg"));
	  l1.setBounds(70,30,140,30);
	  l1.setText("Enter Date(yyyy/mm/dd)::");
	  t1.setBounds(220,30,120,30);
	  b1.setBounds(140,80,120,30);
	  b1.setText("Delete");
	  b1.setFocusable(false);
	  b1.addActionListener(this);
	  b2.setBounds(0, 0, 40, 40);
	  b2.setIcon(i);
	 //b2.setBackground(Color.BLACK);
	 //b2.setForeground(Color.cyan);
	  b2.setBorderPainted(false);
	  b2.setFocusable(false);
	  b2.addActionListener(this);
	  frame=new Frame_Create();
	  frame.setSize(400,160);
	  frame.add(l1);
	  frame.add(t1);
	  frame.add(b1);
	  frame.add(b2);
	  frame.setVisible(true);
  }
  @Override
  public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource()==b1) {
		String d=t1.getText();
		try {
			Connection con=CP.createC();
			String q1="select P_ID from Patient where D_O_A<? and Room_No is NULL and D_O_Adm is NULL";
			PreparedStatement p=con.prepareStatement(q1);
			p.setString(1,d);
			ResultSet rs=p.executeQuery();
			while(rs.next()) {
				String id=rs.getString("P_ID");
				String q2="delete from Prescription where P_ID=?";
				PreparedStatement p1=con.prepareStatement(q1);
				p1.setString(1,id);
				p1.executeUpdate();
				String q3="delete from lab_appoint where P_ID=?";
				PreparedStatement p2=con.prepareStatement(q3);
				p2.setString(2,id);
				p2.executeUpdate();
				String query="delete from Patient where P_ID=?";
				PreparedStatement p3=con.prepareStatement(query);
				p3.setString(1,id);
				p3.executeUpdate();
			}
		}catch(Exception r) {
			r.printStackTrace();
		}
	}
	else if(e.getSource()==b2) {
		Admin a=new Admin();
		frame.dispose();
	}
  }
  public static void main(String [] args) {
	Deletion d=new Deletion();  
  }
}
