package sendMess;

import javax.jms.JMSException;
import javax.naming.NamingException;

import connectActive.ConnectionAc;

public class Test {
	public static void main(String[] args) {
		try {
			ConnectionAc.getInstance().connect();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Sender sender = new Sender();
		try {
			sender.sendMess("test 3");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
		//System.out.println("sdfsdf");
	//}
}
