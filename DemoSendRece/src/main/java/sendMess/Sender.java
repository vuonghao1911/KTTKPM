package sendMess;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;

import connectActive.ConnectionAc;

public class Sender {
	public void sendMess(String mess) throws Exception {
		ConnectionAc.getInstance();
		Connection con = ConnectionAc.getConnection();
		Session session=con.createSession(
				/*transaction*/false,
				/*ACK*/Session.AUTO_ACKNOWLEDGE
				);
				//create producer
				MessageProducer producer = session.createProducer(ConnectionAc.getDestination());
				//create text message
				Message msg=session.createTextMessage(mess);
				producer.send(msg);
				session.close();con.close();
				System.out.println("Finished..."); 
	}
}
