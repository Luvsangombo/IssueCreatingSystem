package projects.issuesystem.vote;


import jakarta.persistence.*;
import projects.issuesystem.issue.Issue;
import projects.issuesystem.student.Student;


@Entity
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public Vote() {
    }

    @ManyToOne
    Student student;

    @ManyToOne()
    Issue issue;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
