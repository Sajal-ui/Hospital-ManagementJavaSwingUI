package Lab;

import java.awt.Color;
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

public class create_an_appoint implements ActionListener{
    Frame_Create frame;
    JTextField t1;
    JTextField t2;
    JTextField t3;
    JButton b1;
    JButton b2;
    JButton b3;
    JButton b4;
    static int cost=0;
    public create_an_appoint() {
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
    	l1.setBounds(60, 70, 140, 30);
    	l1.setText("Enter Patient's ID:");
    	t1.setBounds(210, 70, 120, 30);
    	l2.setBounds(60, 120, 140, 30);
    	l2.setText("Enter Test ID:");
    	t2.setBounds(210, 120, 120, 30);
    	b1.setBounds(80,170,120,30);
    	b1.setText("Add More Test");
    	b1.setFocusable(false);
    	b1.addActionListener(this);
    	b4.setBounds(220,170,100,30);
    	b4.setText("Total Cost");
    	b4.setFocusable(false);
    	b4.addActionListener(this);
    	b2.setBounds(240, 0, 130, 40);
    	b2.setText("Check for TestID");
    	b2.setFocusable(false);
    	b2.addActionListener(this);
    	b3.setBounds(0,0,40, 40);
  	    b3.setIcon(i);
  	    //b3.setBackground(Color.BLACK);
  	    //b3.setForeground(Color.cyan);
  	    b3.setBorderPainted(false);
  	    b3.addActionListener(this);
  	    b3.setFocusable(false);
    	frame=new Frame_Create();
    	frame.setLayout(null);
    	frame.setSize(400,250);
    	frame.add(l1);
    	frame.add(t1);
    	frame.add(l2);
    	frame.add(t2);
    	frame.add(b1);
    	frame.add(b2);
    	frame.add(b3);
    	frame.add(b4);
    	frame.setVisible(true);
    }
    public static void main(String [] args) {
    	create_an_appoint a=new create_an_appoint();
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b3) {
			Lab_Appointment l=new Lab_Appointment();
			frame.dispose();
			l.Window();
		}
		else if(e.getSource()==b1) {
			String p_id=t1.getText();
			String t_id=t2.getText();
			try {
				Connection con=CP.createC();
				String query="insert into Lab_appoint(Patient_ID,Test_ID) values(?,?)";
                PreparedStatement p=con.prepareStatement(query);
                p.setString(1,p_id);
                p.setString(2,t_id);
                p.executeUpdate();
                String q2="select Cost from test where Test_ID=?";
                PreparedStatement p1=con.prepareStatement(q2);
                p1.setString(1,t_id);
                ResultSet rs=p1.executeQuery();
                while(rs.next()) {
                	int c=rs.getInt("Cost");
                	String pay=Integer.toString(cost);
                	cost=c+cost;
               }
			}catch(Exception r) {
				r.printStackTrace();
			}
			create_an_appoint a=new create_an_appoint();
			frame.dispose();
		}
		else if(e.getSource()==b4) {
			String p_id=t1.getText();
			String t_id=t2.getText();
			try {
				Connection con=CP.createC();
				String query="insert into Lab_appoint(Patient_ID,Test_ID,D_O_A) values(?,?,CURRENT_DATE())";
                PreparedStatement p=con.prepareStatement(query);
                p.setString(1,p_id);
                p.setString(2,t_id);
                p.executeUpdate();
                String q2="select Cost from test where Test_ID=?";
                PreparedStatement p1=con.prepareStatement(q2);
                p1.setString(1,t_id);
                ResultSet rs=p1.executeQuery();
                while(rs.next()) {
                	int c=rs.getInt("Cost");
                	String pay=Integer.toString(cost);
                	cost=c+cost;
               }
			}catch(Exception r) {
				r.printStackTrace();
			}
			String pay=Integer.toString(cost);
			System.out.println("You have to pay Rs."+pay);
		}
		else if(e.getSource()==b2) {
			Window_2 w=new Window_2();
		}
	}
}
