package OPD;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Database_connection.CP;
import Frame.Frame_Create;

public class Appoint_with_doctor implements ActionListener{
   Frame_Create frame;
   JTextField t;
   JTextField t1;
   JTextField t2;
   JTextField t3;
   JTextField t4;
   JTextField t5;
   JTextField t6;
   JTextField t7;
   JButton b1;
   JComboBox comboBox;
   JButton b;
   public Appoint_with_doctor() {
	   String[] G= {"M","F"};
	   JLabel label1=new JLabel();
	   t=new JTextField();
	   JLabel label2=new JLabel();
	   t1=new JTextField();
	   JLabel label3=new JLabel();
	   t2=new JTextField();
	   JLabel label4=new JLabel();
	   comboBox=new JComboBox(G);
	   JLabel label5=new JLabel();
	   t3=new JTextField();
	   JLabel label6=new JLabel();
	   t4=new JTextField();
	   JLabel label7=new JLabel();
	   t5=new JTextField();
	   JLabel label8=new JLabel();
	   t6=new JTextField();
	   JLabel label9=new JLabel();
	   t7=new JTextField();
	   b1=new JButton();
	   Icon i=new ImageIcon(getClass().getResource("/Image/back.jpg"));
	   t.setBounds(250,50,130,30);
	   label1.setBounds(50,50,200,30);
	   label1.setText("Enter the Patient's Name");
	   t1.setBounds(250,90,130,30);
	   label2.setBounds(50,90,200,30);
	   label2.setText("Enter the Patient's Age");
	   t2.setBounds(250,130,130,30);
	   label3.setBounds(50,130,130,30);
	   label3.setText("Enter the Address");
	   comboBox.setBounds(250,170,40,30);
	   label4.setBounds(50,170,130,30);
	   label4.setText("Enter the Gender");
	   t3.setBounds(280, 210,130,30);
	   label5.setBounds(50,210,220,30);
	   label5.setText("Enter the Chaperone's name");
	   t4.setBounds(280,250,130,30);
	   label6.setBounds(50,250,220,30);
	   label6.setText("Enter the Chaperone's Mobno.");
	   t5.setBounds(250, 290, 130, 30);
	   label7.setBounds(50,290,180,30);
	   label7.setText("Enter the Doctor's ID");
	   t6.setBounds(270,330,130,30);
	   label8.setBounds(50,330,200,30);
	   label8.setText("Enter the Appointment No.");
	   t7.setBounds(280, 370, 130,30);
	   label9.setBounds(50,370,220,30);
	   label9.setText("Enter the Cost of Appointment");
	   b=new JButton();
	   b.setBounds(210,420,100,40);
	   b.setText("Submit");
	   b.setFocusable(false);
	   b.addActionListener(this);
	   b1.setBounds(0,0,40,40);
	   b1.setIcon(i);
	   //b1.setBackground(Color.BLACK);
	   //b1.setForeground(Color.cyan);
	   b1.setFocusable(false);
	   b1.setBorderPainted(false);
	   b1.addActionListener(this);
	   frame=new Frame_Create();
	   frame.setSize(500,550);
	   frame.add(label1);
	   frame.add(t);
	   frame.add(label2);
	   frame.add(t1);
	   frame.add(label3);
	   frame.add(t2);
	   frame.add(label4);
	   frame.add(comboBox);
	   frame.add(label5);
	   frame.add(t3);
	   frame.add(label6);
	   frame.add(t4);
	   frame.add(label7);
	   frame.add(t5);
	   frame.add(label8);
	   frame.add(t6);
	   frame.add(label9);
	   frame.add(t7);
	   frame.add(b);
	   frame.add(b1);
	   frame.setVisible(true);
   }
   public static void main(String [] args) {
	   Appoint_with_doctor afd=new Appoint_with_doctor(); 
   }
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	   if(e.getSource()==b) {
		  String name=t.getText();
		  String age=t1.getText();
		  String address=t2.getText();
		  String gender=(String) comboBox.getSelectedItem();
		  String Chap_name=t3.getText();
		  String Chap_mobno=t4.getText();
		  String Doc_ID=t5.getText();
		  String Appoin_No=t6.getText();
		  String cost=t7.getText();
		  try{
			  Connection con=CP.createC();
			  String query="insert into Patient(P_name,Age,Gender,Address,Chaperone_name,Mob_no,Doc_ID,Cost,Appo_ID,D_O_A)values(?,?,?,?,?,?,?,?,?,CURRENT_DATE())";
			  PreparedStatement p=con.prepareStatement(query);
			  p.setString(1,name);
			  p.setString(2,age);
			  p.setString(3,gender);
			  p.setString(4,address);
			  p.setString(5,Chap_name);
			  p.setString(6,Chap_mobno);
			  p.setString(7,Doc_ID);
			  p.setString(8,cost);
			  p.setString(9,Appoin_No);
			  p.executeUpdate();
		  }catch(Exception st) {
			  st.printStackTrace();
		  }
		  System.out.println("You have to pay "+cost);
	   }
	   else if(e.getSource()==b1) {
		  Appointment a=new Appointment();
		  a.Window();
		  frame.dispose();
	   }
   }
}
