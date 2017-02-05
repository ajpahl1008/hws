package com.pahlsoft.hws.orchestration.ejb;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.text.SimpleDateFormat;
import java.util.Date;

@MessageDriven(name="HouseWeatherEventMDB")
public class HouseWeatherEventMDB implements MessageListener {

      public static Logger logger = LogManager.getLogger(HouseWeatherEventMDB.class);
      public void onMessage(Message message) {
    	TextMessage txtMsg = (TextMessage) message;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
      	Date date = new Date();
      	String currentDate = sdf.format(date);
         try {
               logger.info("Processing HWS Event: " + txtMsg.getJMSCorrelationID());
               logger.info("Time of Event: " + txtMsg.getJMSTimestamp());
               logger.info("Time Event is Processed: " + currentDate);
               logger.info("Event Text: " + txtMsg.getText());
         } catch (JMSException e) {
               e.printStackTrace();
             }
         }

}