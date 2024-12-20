package projects.issuesystem.vote;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projects.issuesystem.issue.Issue;
import projects.issuesystem.issue.IssueService;
import projects.issuesystem.student.Student;
import projects.issuesystem.student.StudentService;

@Service
public class VoteService {
    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private IssueService issueService;

    @Autowired
    private StudentService studentService;

    public void save(int id) {
        Student student = studentService.getCurrentUser();
        Issue issue = issueService.getIssueById(id);
        Vote vote = new Vote();
        vote.setStudent(student);
        issue.setVote(vote);
        voteRepository.save(vote);
    }
}
