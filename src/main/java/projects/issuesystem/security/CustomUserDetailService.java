package projects.issuesystem.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import projects.issuesystem.student.Student;
import projects.issuesystem.student.StudentService;



@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private StudentService studentService;

    @Override
    public Student loadUserByUsername(String username) throws UsernameNotFoundException {
        Student student = studentService.findStudentByUserName(username);
        if(student == null) {
            throw new UsernameNotFoundException(username);
        }
        return student;
    }
}
