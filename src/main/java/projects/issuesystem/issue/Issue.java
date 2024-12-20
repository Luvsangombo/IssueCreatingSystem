package projects.issuesystem.issue;


import jakarta.persistence.*;
import projects.issuesystem.comment.Comment;
import projects.issuesystem.student.Student;
import projects.issuesystem.vote.Vote;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Entity
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    @Column(length = 1000)
    private String description;
    private Status status = Status.APPROVED;;
    private Category category;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JoinColumn(name="issue_id")
    private List<Comment> comments =new ArrayList<Comment>();

    @OneToMany(orphanRemoval = true, mappedBy = "issue")
    private List<Vote> votes = new ArrayList<>();

    @ManyToOne
    private Student assignee;

    public Issue() {
    }

    public Issue(String title, String description, Category category, Student assignee) {
        this.title = title;
        this.description = description;
        this.category = category;
    }


    public void setAssignee(Student assignee) {
        this.assignee = assignee;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Student getAssignee() {
        return assignee;
    }

    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


    public List<Comment> getComments() {
        return comments;
    }

    public void addComment(Comment comment) {
        this.comments.add(comment);
    }

    public int getVote() {

        return this.votes.size();
    }

    public void setVote(Vote vote) {
        this.votes.add(vote);
    }

    public HashMap<String, String> toHashMap() {
        HashMap<String, String>  hash = new HashMap<String, String>();
        hash.put("id", Integer.toString(id));
        hash.put("title", title);
        hash.put("description", description);
        hash.put("status", status.toString());
        hash.put("category", category.toString());
        return hash;
    }

}
