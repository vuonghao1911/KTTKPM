package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.jms.JMSException;
import javax.naming.NamingException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import connectActive.ConnectionAc;
import sendMess.Sender;

public class GuiSender extends JFrame implements ActionListener {
	JTextField txtMess;
	private JButton btnSend;
	public GuiSender() {
		
		try {
			ConnectionAc.getInstance().connect();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setSize(400, 200);
		setLayout(new FlowLayout());
		txtMess = new JTextField(30);
		this.add(txtMess);
		
		btnSend = new JButton("Send");
		this.add(btnSend);
		btnSend.addActionListener(this);
		
	}
	
	
	public static void main(String[] args) {
		new GuiSender().setVisible(true);
	}


	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o==btnSend) {
			Sender sender = new Sender();
			try {
				sender.sendMess(txtMess.getText());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			txtMess.setText("");
		}
		
	}
	
}
