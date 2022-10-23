package Medicines;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Frame.Frame_Create;
import Launchpage1.Launchpage1;

public class Authorisation_Admin implements ActionListener{
   Frame_Create frame;
   JTextField t1;
   JPasswordField p1;
   JButton b1;
   JButton b2;
   public Authorisation_Admin() {
	   JLabel l1=new JLabel();
	   t1=new JTextField();
	   b1=new JButton();
	   b2=new JButton();
	   Icon i=new ImageIcon(getClass().getResource("/Image/back.jpg"));
	   l1.setBounds(80,60,100,30);
	   l1.setText("Username:");
	   t1.setBounds(160,60,130,30);
	   JLabel l2=new JLabel();
	   p1=new JPasswordField();
	   l2.setBounds(80,110,100,30);
	   l2.setText("Password:");
	   p1.setBounds(160,110,130,30);
	   b1.setBounds(145, 170, 90, 30);
	   b1.setText("Submit");
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
	   frame.setSize(400,280);
	   frame.add(l1);
	   frame.add(t1);
	   frame.add(l2);
	   frame.add(p1);
	   frame.add(b1);
	   frame.add(b2);
	   frame.setVisible(true);
   }
   public static void main(String [] args) {
	   Authorisation_Admin a=new Authorisation_Admin();
   }
   @Override
   public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
        if(e.getSource()==b1) {
        	String s="Pharmacy";
        	String p="123456";
        	String usnm=t1.getText();
        	String psswr=String.valueOf(p1.getPassword());
        	if(usnm.equalsIgnoreCase(s) && psswr.equals(p)) {
        		Pharmacy pop=new Pharmacy();
        		frame.dispose();
        	}
        	else {
        		JOptionPane j=new JOptionPane();
        		j.showMessageDialog(null, "Username or Password is Wrong","Error" ,JOptionPane.ERROR_MESSAGE);        		
        	}
        }
        else if(e.getSource()==b2) {
        	Launchpage1 l=new Launchpage1();
        	frame.dispose();
        }
   }
}
