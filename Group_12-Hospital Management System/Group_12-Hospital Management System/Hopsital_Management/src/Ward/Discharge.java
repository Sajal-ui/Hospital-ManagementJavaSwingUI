package Ward;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Database_connection.CP;
import Frame.Frame_Create;
import Lab.Lab_Appointment;

public class Discharge implements ActionListener{
    Frame_Create frame;
    JTextField t1;
    JTextField t2;
    JButton b1;
    JButton b2;
    public Discharge() {
    	JLabel l=new JLabel();
    	JLabel l1=new JLabel();
    	t1=new JTextField();
    	t2=new JTextField();
    	b1=new JButton();
    	b2=new JButton();
    	Icon i=new ImageIcon(getClass().getResource("/Image/back.jpg"));
    	l.setBounds(70,30,110,30);
    	l.setText("Enter Patient ID:");
    	t1.setBounds(190,30,120,30);
    	l1.setBounds(70, 70, 110, 30);
    	l1.setText("Date of Departure:");
    	t2.setBounds(190,70,120,30);
    	b1.setBounds(130,120,120,30);
        b1.setText("Discharge");
    	b1.setFocusable(false);
    	b1.addActionListener(this);
    	b2.setBounds(0,0,40, 40);
  	    b2.setIcon(i);
  	   //b4.setBackground(Color.BLACK);
  	   //b4.setForeground(Color.cyan);
  	    b2.setBorderPainted(false);
  	    b2.addActionListener(this);
  	    b2.setFocusable(false);
    	frame=new Frame_Create();
    	frame.setLayout(null);
    	frame.setSize(400,200);
    	frame.add(l);
    	frame.add(t1);
    	frame.add(b1);
    	frame.add(l1);
    	frame.add(t2);
    	frame.add(b2);
    	frame.setVisible(true);
    }
    public static void main(String [] args) {
    	Discharge d=new Discharge();
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b1) {
			String id=t1.getText();
			String dod=t2.getText();
			int noofdays = 0;
			int t_cost=0;
			try {
				int cost=0;
				Connection con=CP.createC();
				String q1="select D_O_Adm,Room_No from Patient where P_ID=?";
				   PreparedStatement p1=con.prepareStatement(q1);
				   p1.setString(1,id);
				   ResultSet rs=p1.executeQuery();
				   while(rs.next()) {
					   String d1=rs.getString("D_O_Adm");
					   String r_no=rs.getString("Room_No");
					   String q2="select Cost from wards where Room_no=?";
					   PreparedStatement p2=con.prepareStatement(q2);
					   p2.setString(1,r_no);
					   ResultSet r=p2.executeQuery();
					   while(r.next()) {
						   cost=r.getInt("Cost");
					   }
					   LocalDate dt=LocalDate.parse(d1);
					   LocalDate dt2=LocalDate.parse(dod);
					   noofdays=(int) ChronoUnit.DAYS.between(dt,dt2);
					   t_cost=noofdays*cost;
				   }
				String query="update Patient set Room_No=NULL,D_O_Adm=NULL where P_ID=?";
				PreparedStatement p=con.prepareStatement(query);
	            p.setString(1,id);
	            String pay=Integer.toString(t_cost);
	            p.execute();
	            System.out.println("You have to pay Rs."+ pay);
			}catch(Exception r) {
				r.printStackTrace();
			}
		}
	else if(e.getSource()==b2) {
	   Ward_Given w=new Ward_Given();
	   w.Window();
	   frame.dispose();
	}
  }		
}
