package Lab;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Database_connection.CP;
import Frame.Frame_Create;

public class Cancel_labappoint implements ActionListener{
    Frame_Create frame;
    JTextField t1;
    JButton b1;
    JButton b2;
    public Cancel_labappoint() {
    	JLabel l1=new JLabel();
    	Icon i=new ImageIcon(getClass().getResource("/Image/back.jpg"));
    	l1.setBounds(70,30,120,30);
    	l1.setText("Enter Patient ID:");
    	t1=new JTextField();
    	b1=new JButton();
    	b2=new JButton();
    	t1.setBounds(196, 30,120,30);
    	b1.setBounds(140,80,120,30);
    	b1.setText("Cancel it");
    	b1.setFocusable(false);
    	b1.addActionListener(this);
    	b2.setBounds(0,0,40, 40);
  	    b2.setIcon(i);
  	    //b3.setBackground(Color.BLACK);
  	    //b3.setForeground(Color.cyan);
  	    b2.setBorderPainted(false);
  	    b2.addActionListener(this);
  	    b2.setFocusable(false);
    	frame=new Frame_Create();
    	frame.setSize(400,170);
    	frame.add(l1);
    	frame.add(t1);
    	frame.add(b1);
    	frame.add(b2);
    	frame.setVisible(true);
    }
    public static void main(String [] args) {
    	Cancel_labappoint l=new Cancel_labappoint();
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b1) {
			String id=t1.getText();
			try {
				Connection con=CP.createC();
				String query="delete from lab_appoint where Patient_ID=?";
				PreparedStatement p=con.prepareCall(query);
				p.setString(1,id);
				p.executeUpdate();
			}catch(Exception r) {
				r.printStackTrace();
			}
		}
		else if(e.getSource()==b2) {
			Lab_Appointment a=new Lab_Appointment();
			a.Window();
			frame.dispose();
		}
	}
}
