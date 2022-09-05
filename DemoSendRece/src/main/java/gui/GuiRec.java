package gui;

import java.awt.FlowLayout;
import java.awt.TextArea;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.NamingException;
import javax.swing.JFrame;

import connectActive.ConnectionAc;
import javax.jms.Connection;
import javax.jms.Destination;
public class GuiRec extends JFrame {
	Connection con = null;
	Destination destination;
	TextArea txtMess;
	public GuiRec() throws Exception {
		try {
			ConnectionAc.getInstance().connect();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 txtMess = new TextArea();
		//txtMess.setText("was listend on queue....");
		con = ConnectionAc.getConnection();
		destination = ConnectionAc.getDestination();
		Session session=con.createSession(
				/*transaction*/false,
				/*ACK*/Session.CLIENT_ACKNOWLEDGE
				);
				//tạo consumer
				MessageConsumer receiver = session.createConsumer(destination);
				//blocked-method for receiving message - sync
				//receiver.receive();
				//Cho receiver lắng nghe trên queue, chừng có message thì notify - async
				System.out.println("Tý was listened on queue...");
				
				receiver.setMessageListener(new MessageListener() {
					
					//có message đến queue, phương thức này được thực thi
					public void onMessage(Message msg) {//msg là message nhận được
					try {
					if(msg instanceof TextMessage){
					TextMessage tm=(TextMessage)msg;
					String txt=tm.getText();
					System.out.println("Nhận được "+txt); 
					txtMess.setText("\n"+txt);
					msg.acknowledge();//gửi tín hiệu ack
					}
					else if(msg instanceof ObjectMessage){
					ObjectMessage om=(ObjectMessage)msg;
					System.out.println(om);
					}
					//others message type....
					} catch (Exception e) {
					e.printStackTrace();
					}
					}
					});
				
				
				
		setSize(500, 300);
		setLayout(new FlowLayout());
		
		
		this.add(txtMess);
		
	}
	public static void main(String[] args) throws Exception {
		new GuiRec().setVisible(true);
	}
}
					
