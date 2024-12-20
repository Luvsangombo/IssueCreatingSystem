package projects.issuesystem.comment;


import jakarta.persistence.*;
import projects.issuesystem.issue.Issue;
import projects.issuesystem.student.Student;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String content;
    @OneToOne
    private Student author;


    public Comment() {}
    public Comment(String content, Student author) {
        this.content = content;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Student getAuthor() {
        return author;
    }

    public void setAuthor(Student author) {
        this.author = author;
    }
}
