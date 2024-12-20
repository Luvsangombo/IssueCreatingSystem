package projects.issuesystem.issue;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import projects.issuesystem.student.StudentService;

import java.util.List;

@RestController
public class IssueController {


    @Autowired
    private IssueService service;

    @Autowired
    private StudentService studentService;

    @GetMapping(path = "/issues")
    public List<Issue> getIssues() {
        return service.getAllApprovedIssues();
    }


    @PostMapping(path = "/issues")
    public Issue createIssue(@RequestBody Issue issue) {
        return service.createIssue(studentService.getCurrentUser(),issue);
    }
}
