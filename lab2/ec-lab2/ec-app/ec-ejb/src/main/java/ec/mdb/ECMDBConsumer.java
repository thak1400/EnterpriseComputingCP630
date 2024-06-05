package ec.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import ec.lab.SBStateless;

@MessageDriven(name = "testQueue", activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "queue/test"),
})
public class ECMDBConsumer implements MessageListener {
    @EJB
    SBStateless sbsl;

	public void onMessage(Message message) {
		try {
			String mstr = ((TextMessage) message).getText();
			System.out.println("MDB message consumer received MDB consumer : "+ mstr);
			System.out.println("MDB message consumer invokes prediction : "+ sbsl.getPrediction(90));
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
