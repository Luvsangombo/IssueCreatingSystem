package projects.issuesystem.issue;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projects.issuesystem.messaging.Consumer;
import projects.issuesystem.messaging.Producer;
import projects.issuesystem.student.Student;

import java.util.List;
import java.util.Optional;

@Service
public class IssueService {

    @Autowired
    private IssueRepository repository;

    @Autowired
    private Producer producer;

    public List<Issue> getAllApprovedIssues() {
        return repository.findAllByStatus(Status.APPROVED);
    }

    public Issue createIssue(Student student, Issue issue) {
        issue.setAssignee(student);
        Issue newIssue = repository.save(issue);
        producer.sendIssue(newIssue.toHashMap());
        return newIssue;
    }

    public Issue getIssueById(int id) {
        Optional<Issue> issue = repository.findById(id);
        return issue.orElse(null);
    }

}
