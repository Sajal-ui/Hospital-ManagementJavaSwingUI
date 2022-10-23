package Front_Window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import Frame.Frame_Create;
import Launchpage1.Launchpage1;
import Second_Window.Second_Window;

public class Front_page implements ActionListener{
    Frame_Create frame;
    JButton b1;
    JButton b2;
    public Front_page() {
    	JLabel l1=new JLabel();
    	Icon i=new ImageIcon(getClass().getResource("/Image/H.jpg"));
    	l1.setBounds(50,30,300,170);
    	l1.setIcon(i);
    	l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setVerticalAlignment(JLabel.CENTER);
    	b1=new JButton();
    	b2=new JButton();
    	b1.setBounds(138,210,120,30);
    	b1.setText("Enter");
    	b1.addActionListener(this);
    	b1.setFocusable(false);
    	b2.setBounds(138, 250, 120, 30);
    	b2.setText("Exit");
    	b2.addActionListener(this);
    	b2.setFocusable(false);
    	frame=new Frame_Create();
    	frame.setSize(400,340);
    	frame.add(l1);
    	frame.add(b1);
    	frame.add(b2);
    	frame.setVisible(true);
    }
    public static void main(String [] args) {
    	Front_page f=new Front_page();
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b1) {
			Second_Window w=new Second_Window();
			frame.dispose();
		}
		else if(e.getSource()==b2) {
			System.exit(0);
		}
	}
}
