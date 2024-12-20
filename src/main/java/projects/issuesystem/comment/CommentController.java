package projects.issuesystem.comment;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import projects.issuesystem.issue.IssueService;
import projects.issuesystem.student.StudentService;

@RestController
public class CommentController {

    @Autowired
    private CommentService service;


    @PostMapping("/post/{id}/comment")
    public Comment addComment(@PathVariable int id, @RequestBody Comment comment) {
        return service.createComment(id, comment);
    }
}
