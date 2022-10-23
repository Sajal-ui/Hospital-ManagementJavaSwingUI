package OPD;

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
import Ward.Ward_Given;

public class Search_ap implements ActionListener{
	JTextField t1;
	JButton b1;
	JButton b2;
	Frame_Create frame;
    public Search_ap() {
    	JLabel l1=new JLabel();
    	t1=new JTextField();
    	b1=new JButton();
    	Icon i=new ImageIcon(getClass().getResource("/Image/back.jpg"));
    	l1.setBounds(60,40,140,30);
    	l1.setText("Enter the Patient_Name:");
    	t1.setBounds(230,40,120,30);
    	b1.setBounds(140,90,100,30);
    	b1.setText("Search");
    	b1.setFocusable(false);
    	b1.addActionListener(this);
    	b2=new JButton();
 	    b2.setBounds(0,0,40, 40);
 	    b2.setIcon(i);
 	   //b4.setBackground(Color.BLACK);
 	   //b4.setForeground(Color.cyan);
 	    b2.setBorderPainted(false);
 	    b2.addActionListener(this);
 	    b2.setFocusable(false);
    	frame=new Frame_Create();
    	frame.setLayout(null);
    	frame.setSize(400,180);
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
			String s=t1.getText();
			try {
				Connection con=CP.createC();
				String query="select P_ID,Address,D_O_A from Patient where P_Name=?";
				PreparedStatement p=con.prepareStatement(query);
				p.setString(1,s);
				ResultSet rs=p.executeQuery();
				while(rs.next()) {
					String id=rs.getString("P_ID");
					String doa=rs.getString("D_O_A");
					String address=rs.getString("Address");
					System.out.println("Patient_ID:: "+id);
					System.out.println("Patient_Name:: "+s);
					System.out.println("Address:: "+address);
					System.out.println("D_O_A:: "+doa);
			    }
			}catch(Exception r) {
				r.printStackTrace();
			}
		}
		else if(e.getSource()==b2) {
			Appointment a=new Appointment();
			a.Window();
			frame.dispose();
		}
	}
	public static void main(String [] args) {
	   Search_ap a=new Search_ap();	
	}
    
}
