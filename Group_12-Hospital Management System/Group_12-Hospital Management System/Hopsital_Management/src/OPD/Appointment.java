package OPD;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import Frame.Frame_Create;
import Launchpage1.Launchpage1;

public class Appointment implements ActionListener{
    Frame_Create frame; 
    JButton b1;
    JButton b2;
    JButton b3;
    JButton b4;
	public void Window(){
	   JLabel label=new JLabel();
	   label.setBounds(50, 50, 400, 250);
	   frame=new Frame_Create();
	   Icon i=new ImageIcon(getClass().getResource("/Image/back.jpg"));
	   b1=new JButton();
	   b1.setText("Set An Appointment");
	   b1.setBounds(82,10,250,40);
	   b1.setFocusable(false);
	   b1.addActionListener(this);
	   b2=new JButton();
	   b2.setText("Search The Appointment");
	   b2.setBounds(82, 60, 250, 40);
	   b2.setFocusable(false);
	   b2.addActionListener(this);
	   b3=new JButton();
	   b3.setText("Cancel The Appointment");
	   b3.setBounds(82, 110, 250, 40);
	   b3.setFocusable(false);
	   b3.addActionListener(this);
	   b4=new JButton();
	   b4.setIcon(i);
	   b4.setBounds(0, 0, 40, 40);
	   //b4.setBackground(Color.BLACK);
	   //b4.setForeground(Color.cyan);
	   b4.setBorderPainted(false);
	   b4.setFocusable(false);
	   b4.addActionListener(this);
	   label.add(b1);
	   label.add(b2);
	   label.add(b3);
	   frame.setSize(500, 300);
	   frame.add(label);
	   frame.add(b4);
	   frame.setVisible(true);
   }
   public static void main(String [] args) {
	   Appointment a=new Appointment();
	   a.Window();
	   
   }
   @Override
   public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	   if(e.getSource()==b1) {
	      	   Appoint_with_doctor a = new Appoint_with_doctor();
	      	   frame.dispose();
	   }
	   else if(e.getSource()==b4) {
		   Launchpage1 l=new Launchpage1();
	       frame.dispose();
	   }
	   else if(e.getSource()==b2) {
		  Search_ap w=new Search_ap();
		  frame.dispose();
	   }
	   else if(e.getSource()==b3) {
		   Cancel_ap s=new Cancel_ap();
		   frame.dispose();
	   }
   }
}
