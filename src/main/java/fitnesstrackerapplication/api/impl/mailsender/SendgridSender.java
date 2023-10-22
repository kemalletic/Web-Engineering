package fitnesstrackerapplication.api.impl.mailsender;


import fitnesstrackerapplication.core.api.mailsender.MailSender;
import fitnesstrackerapplication.core.model.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
// Method 2 for injection: condition based on application properties
// @ConditionalOnProperty(name = "configuration.mailsender.default", havingValue = "sendgrid")
public class SendgridSender implements MailSender {

    @Override
    public String send(List<User> users, String message) {
        for (User user: users) {
            System.out.println("Message sent to: " + user.getEmail());
        }
        return "Message: " + message + " | Sent via Sendgrid.";
    }
}