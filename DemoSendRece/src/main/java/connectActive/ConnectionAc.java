package connectActive;

import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.BasicConfigurator;

public class ConnectionAc {
	public static Connection con = null;
	public static Destination destination;
	public static ConnectionAc Instance = new ConnectionAc();
	public static ConnectionAc getInstance () {
		return Instance;
	}
	
	public void connect() throws NamingException, JMSException {
		BasicConfigurator.configure();
		//config environment for JNDI
		Properties settings=new Properties();
		settings.setProperty(Context.INITIAL_CONTEXT_FACTORY, 
		"org.apache.activemq.jndi.ActiveMQInitialContextFactory");
		settings.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616");
		//create context
		Context ctx=new InitialContext(settings);
		//lookup JMS connection factory
		ConnectionFactory factory=
		(ConnectionFactory)ctx.lookup("ConnectionFactory");
		//lookup destination. (If not exist-->ActiveMQ create once)
		 destination=
		(Destination) ctx.lookup("dynamicQueues/thanthidet");
		//get connection using credential
		 con=factory.createConnection("admin","admin");
		 con.start();
	}
	public static Connection getConnection() {
		return con;
	}
	public static Destination getDestination() {
		return  destination;
	}
}
