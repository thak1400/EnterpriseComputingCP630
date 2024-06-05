package ec.stats.jms;

import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.NamingException;

public class StatsJMSProducer {

	public static void main(String[] args) throws NamingException, JMSException {
		if (args.length != 2 || !args[0].equals("-message")) {
			System.out.println("Usage: java StatsJMSProducer -message <message>");
			return;
		}
		Connection connection = null;

		try {
			System.out.println("Create JNDI Context");
			Context context = ContextUtil.getInitialContext();
			ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup("jms/RemoteConnectionFactory");
			connection = connectionFactory.createConnection("quickstartUser", "quickstartPwd1!");

			System.out.println("Create session");
			Session session = connection.createSession(false, QueueSession.AUTO_ACKNOWLEDGE);
			Destination queue = (Destination) context.lookup("jms/queue/test");

			System.out.println("Start connection");
			connection.start();

			System.out.println("Create producer");
			MessageProducer producer = session.createProducer(queue);

			System.out.println("Create a message");
			String txtMsg = args[1];
			Message msg = session.createTextMessage(txtMsg);
			System.out.println("message = " + txtMsg);

			System.out.println("Send message");
			producer.send(msg);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (connection != null) {
				System.out.println("close the connection");
				connection.close();
			}
		}
		System.out.println("producer done");
	}
}
