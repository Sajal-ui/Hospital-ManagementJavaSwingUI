package Ward;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import Frame.Frame_Create;
import Launchpage1.Launchpage1;

public class Ward_Given implements ActionListener{
   Frame_Create frame;
   JButton b1;
   JButton b2;
   JButton b3;
   JButton b4; 
   public void Window() {
	   JLabel label=new JLabel();
	   label.setBounds(50, 50, 400, 250);
	   b1=new JButton();
	   Icon i=new ImageIcon(getClass().getResource("/Image/back.jpg"));
	   b1.setBounds(82, 16, 250, 40);
	   b1.setText("Appoint a Ward");
	   b1.setFocusable(false);
	   b1.addActionListener(this);
	   b2=new JButton();
	   b2.setBounds(82, 66, 250, 40);
	   b2.setText("Search for Patient");
	   b2.setFocusable(false);
	   b2.addActionListener(this);
	   b3=new JButton();
	   b3.setBounds(82, 116, 250, 40);
	   b3.setText("Discharge the Patient");
	   b3.setFocusable(false);
	   b3.addActionListener(this);
	   b4=new JButton();
	   b4.setBounds(0,0,40, 40);
	   b4.setIcon(i);
	   //b4.setBackground(Color.BLACK);
	   //b4.setForeground(Color.cyan);
	   b4.setBorderPainted(false);
	   b4.addActionListener(this);
	   b4.setFocusable(false);
	   label.add(b1);
	   label.add(b2);
	   label.add(b3);
	   frame=new Frame_Create();
	   frame.setLayout(null);
	   frame.setSize(500,300);
	   frame.setVisible(true);
	   frame.add(b4);
	   frame.add(label);
   }
   public static void main(String [] args) {
	   Ward_Given w=new Ward_Given();
	   w.Window();
   }
   @Override
   public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	   if(e.getSource()==b1) {
		   lets_appoint p=new lets_appoint();
	       frame.dispose();
	   }
	   else if(e.getSource()==b2) {
		   Search s=new Search();
		   frame.dispose();
	   }
	   else if(e.getSource()==b3) {
		   Discharge d=new Discharge();
		   frame.dispose();
	   }
	   else if(e.getSource()==b4) {
		   Launchpage1 l=new Launchpage1();
		   frame.dispose();   
	   }
   }
}
