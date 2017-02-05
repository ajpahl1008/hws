package com.pahlsoft.hws.orchestration.ejb;

import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.text.SimpleDateFormat;
import java.util.Date;

@MessageDriven(name="HouseWeatherEventMDB")
public class HouseWeatherEventMDB implements MessageListener {

     public void onMessage(Message message) {
    	TextMessage txtMsg = (TextMessage) message;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
      	Date date = new Date();
      	String todaysDate = sdf.format(date);
         try {
                 System.out.println("Processing HWS Event: " + txtMsg.getJMSCorrelationID() + " " + todaysDate);
             } catch (JMSException e) {
                 e.printStackTrace();
             }
         }

}