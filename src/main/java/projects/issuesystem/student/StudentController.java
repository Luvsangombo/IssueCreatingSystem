package projects.issuesystem.student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Autowired
    private StudentService studentService;

    @PostMapping(path="/register")
    public Student register(@RequestBody Student student) {
        return studentService.registerStudent(student);
    }

    @PostMapping(path="/login")
    public String login(@RequestBody Student student) {
        Authentication auth = authenticationProvider.authenticate(
                new UsernamePasswordAuthenticationToken(
                        student,
                        student.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(auth);
        return student.getUsername();
    }
}
