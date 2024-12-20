package projects.issuesystem.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import projects.issuesystem.issue.Issue;

import java.util.HashMap;


@Component
public class Producer {
    @Autowired
    private JmsTemplate jmsTemplate;

    @Value(value = "${issue_approval_request_queue}")
    String queue_name;

    public void sendIssue(HashMap<String, ?> issue) {
        jmsTemplate.convertAndSend(queue_name, issue);
    }
}
