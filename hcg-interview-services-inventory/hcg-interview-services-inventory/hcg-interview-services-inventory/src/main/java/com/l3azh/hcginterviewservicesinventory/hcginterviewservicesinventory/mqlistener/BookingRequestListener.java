package com.l3azh.hcginterviewservicesinventory.hcginterviewservicesinventory.mqlistener;

import jakarta.jms.JMSException;
import jakarta.jms.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class BookingRequestListener {

    @JmsListener(destination = "update_req.queue")
    public void updateDataRoomAvailabilityListener(final Message message) throws JMSException {
        /**
         * Perform Update action
         */
        log.info(message.getBody(String.class));
    }
}
