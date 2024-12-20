package projects.issuesystem.student;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import projects.issuesystem.issue.Issue;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity()
@JsonIgnoreProperties({ "accountNonExpired", "accountNonLocked", "credentialsNonExpired", "enabled"})
public class Student implements UserDetails {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String fullName;


    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(unique = true)
    private String username;
    private String studentCode;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;


    public Student() {}
    public Student(String fullName, String username, String studentId, String password) {
        this.fullName = fullName;
        this.username = username;
        this.studentCode = studentId;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentId) {
        this.studentCode = studentId;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}

