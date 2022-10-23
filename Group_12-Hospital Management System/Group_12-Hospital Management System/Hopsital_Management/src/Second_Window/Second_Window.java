package Second_Window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import Adminsitration.Authorisation;
import Frame.Frame_Create;
import Front_Window.Front_page;
import Launchpage1.Launchpage1;

public class Second_Window implements ActionListener{
   Frame_Create frame;
   JButton b1;
   JButton b2;
   JButton b3;
   public Second_Window() {
	   b1=new JButton();
	   b2=new JButton();
	   b3=new JButton();
	   Icon i=new ImageIcon(getClass().getResource("/Image/back.jpg"));
	   b1.setBounds(130,40,130,40);
	   b1.setText("General");
	   b1.setFocusable(false);
	   b1.addActionListener(this);
	   b2.setBounds(130,95,130,40);
	   b2.setText("Adminstration");
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
	   frame.setSize(400,200);
	   frame.add(b1);
	   frame.add(b2);
	   frame.add(b3);
	   frame.setVisible(true);
   }
   @Override
   public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	 if(e.getSource()==b1) {
		 Launchpage1 p=new Launchpage1();
		 frame.dispose();
	 }
	 else if(e.getSource()==b3) {
		 Front_page f=new Front_page();
		 frame.dispose();
	 }
	 else if(e.getSource()==b2) {
		 Authorisation a=new Authorisation();
		 frame.dispose();
	 }
   }
   public static void main(String [] args) {
	   Second_Window w=new Second_Window();
   }
}
