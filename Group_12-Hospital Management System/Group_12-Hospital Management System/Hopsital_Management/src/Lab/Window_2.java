package Lab;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Database_connection.CP;
import Frame.Frame_Create;

public class Window_2  implements ActionListener{
    Frame_Create frame;
    JTextField t1;
    JButton b1;
    public Window_2() {
    	JLabel l1=new JLabel();
    	t1=new JTextField();
    	b1=new JButton();
    	l1.setBounds(70, 30, 140,30);
    	l1.setText("Enter Test Name:");
    	t1.setBounds(220,30,140,30);
    	b1.setBounds(140,90, 120,30);
    	b1.setText("Search");
    	b1.setFocusable(false);
    	b1.addActionListener(this);
    	frame=new Frame_Create();
    	frame.setLayout(null);
    	frame.setSize(400,190);
    	frame.add(l1);
    	frame.add(t1);
    	frame.add(b1);
    	frame.setVisible(true);
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b1) {
			String name=t1.getText();
            try {
            	Connection con=CP.createC();
            	String query="select * from test where Test_Name=?";
            	PreparedStatement p=con.prepareStatement(query);
            	p.setString(1,name);
            	ResultSet rs=p.executeQuery();
            	while(rs.next()) {
            		int id=rs.getInt("Test_ID");
                    System.out.println("Test ID: "+id);
                    System.out.println("---------------------------");
            	}
            }catch(Exception r) {
            	r.printStackTrace();
            }
            frame.dispose();
		}
	}
}
