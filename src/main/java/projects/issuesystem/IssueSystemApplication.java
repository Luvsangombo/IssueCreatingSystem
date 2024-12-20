package projects.issuesystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class IssueSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(IssueSystemApplication.class, args);
    }

}
