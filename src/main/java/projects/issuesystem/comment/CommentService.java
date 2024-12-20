package projects.issuesystem.comment;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projects.issuesystem.issue.Issue;
import projects.issuesystem.issue.IssueService;
import projects.issuesystem.student.Student;
import projects.issuesystem.student.StudentService;

@Service("CommentService")
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private IssueService issueService;

    @Autowired
    private StudentService studentService;

    public Comment createComment(int id, Comment comment) {
        Student student = studentService.getCurrentUser();
        Issue issue = issueService.getIssueById(id);
        comment.setAuthor(student);
        issue.addComment(comment);
        return commentRepository.save(comment);
    }
}
