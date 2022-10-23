package Medicines;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Database_connection.CP;
import Frame.Frame_Create;
import Launchpage1.Launchpage1;

public class Pharmacy implements ActionListener{
   Frame_Create frame;
   JButton b1;
   JButton b2;
   JButton b3;
   JButton b4;
   JTextField t1;
   JTextField t2;
   JTextField t3;
   static int cost=0;
   public Pharmacy() {
	   JLabel l1=new JLabel();
	   JLabel l2=new JLabel();
	   JLabel l3=new JLabel();
	   t1=new JTextField();
	   t2=new JTextField();
	   t3=new JTextField();
	   b1=new JButton();
	   b2=new JButton();
	   b3=new JButton();
	   b4=new JButton();
	   Icon i=new ImageIcon(getClass().getResource("/Image/back.jpg"));
	   l1.setBounds(70,60,140,30);
	   l1.setText("Enter Patient's ID:");
	   t1.setBounds(220,60, 100,30);
	   l2.setBounds(70, 100,140,30);
	   t2.setBounds(220, 100, 100,30);
	   l2.setText("Enter Medicine's ID:");
	   l3.setBounds(50,140,160,30);
	   l3.setText("Enter Quantity in packets:");
	   t3.setBounds(220,140,100,30);
	   b1.setBounds(70,190,110,30);
	   b1.setText("ADD MORE");
	   b1.setFocusable(false);
	   b1.addActionListener(this);
	   b2.setBounds(190,190,130,30);
	   b2.setText("TOTAL COST");
	   b2.setFocusable(false);
	   b2.addActionListener(this);
	   b3.setBounds(240,0,140,30);
	   b3.setText("Medicine List");
	   b3.setFocusable(false);
	   b3.addActionListener(this);
	   b4.setBounds(0, 0, 40, 40);
	   b4.setIcon(i);
	   //b4.setBackground(Color.BLACK);
	   //b4.setForeground(Color.cyan);
	   b4.setBorderPainted(false);
	   b4.setFocusable(false);
	   b4.addActionListener(this);
	   frame=new Frame_Create();
	   frame.setSize(400,270);
	   frame.add(l1);
	   frame.add(t1);
	   frame.add(l2);
	   frame.add(t2);
	   frame.add(t3);
	   frame.add(l3);
	   frame.add(b1);
	   frame.add(b2);
	   frame.add(b3);
	   frame.add(b4);
	   frame.setVisible(true);
   }
   public static int getCost() {
	   return cost;
   }
   @Override
    public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	   if(e.getSource()==b1) {
		   String quan=t3.getText();
		   int q=Integer.parseInt(quan);
		   String pid=t1.getText();
		   String mid=t2.getText();
		   try {
			   Connection con=CP.createC();
			   String query="insert into Prescription(Patient_ID,Med_ID) values(?,?)";
			   PreparedStatement p=con.prepareStatement(query);
			   p.setString(1,pid);
			   p.setString(2,mid);
			   p.executeUpdate();
			   String q2="update Pharmacy set Quantity_per_packet=Quantity_per_packet-? where Med_ID=?";
			   PreparedStatement p2=con.prepareStatement(q2);
			   p2.setString(1,quan);
			   p2.setString(2,mid);
			   p2.executeUpdate();
			   String q1="select Cost_per_packet from Pharmacy where Med_ID=?";
			   PreparedStatement p1=con.prepareStatement(q1);
			   p1.setString(1,mid);
			   ResultSet rs=p1.executeQuery();
			   while(rs.next()) {
				   int c=rs.getInt("Cost_per_packet");
				   cost=cost+(c*q);
			   }
		   }catch(Exception r) {
			   r.printStackTrace();
		   }
		   Pharmacy p1=new Pharmacy();
		   frame.dispose();
	   }
	   else if(e.getSource()==b4) {
		   Launchpage1 l=new Launchpage1();
		   frame.dispose();
	   }
	   else if(e.getSource()==b3) {
		   New_Medicine m=new New_Medicine();
	   }
	   else if(e.getSource()==b2) {
		   String quan=t3.getText();
		   int q=Integer.parseInt(quan);
		   String pid=t1.getText();
		   String mid=t2.getText();
		   try {
			   Connection con=CP.createC();
			   String query="insert into Prescription(Patient_ID,Med_ID) values(?,?)";
			   PreparedStatement p=con.prepareStatement(query);
			   p.setString(1,pid);
			   p.setString(2,mid);
			   p.executeUpdate();
			   String q2="update Pharmacy set Quantity_per_packet=Quantity_per_packet-? where Med_ID=?";
			   PreparedStatement p2=con.prepareStatement(q2);
			   p2.setString(1,quan);
			   p2.setString(2,mid);
			   p2.executeUpdate();
			   String q1="select Cost_per_packet from Pharmacy where Med_ID=?";
			   PreparedStatement p1=con.prepareStatement(q1);
			   p1.setString(1,mid);
			   ResultSet rs=p1.executeQuery();
			   while(rs.next()) {
				   int c=rs.getInt("Cost_per_packet");
				   cost=cost+(c*q);
			   }
		   }catch(Exception r) {
			   r.printStackTrace();
		   }
		   int p=getCost();
		   String pay=Integer.toString(p);
		   System.out.println("You have to pay "+pay);
	   }
    }
   public static void main(String [] args) {
	   Pharmacy p=new Pharmacy();
   }
}
