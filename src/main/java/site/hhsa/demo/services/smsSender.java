package site.hhsa.demo.services;
import com.twilio.Twilio;
import com.twilio.converter.Promoter;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.net.URI;
import java.math.BigDecimal;

public class smsSender {
    // Find your Account Sid and Token at twilio.com/console
    private Config config;

    public smsSender(String recieverNum, String txtMessage) {
        Twilio.init(config.getACCOUNT_SID() , config.getAUTH_TOKEN());
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("+"+recieverNum),
                new com.twilio.type.PhoneNumber(config.getPhn_num()),
                txtMessage)
                .create();

        System.out.println(message.getSid());
    }
}