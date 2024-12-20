package projects.issuesystem.student;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("StudentRepository")
public interface StudentRepository extends JpaRepository<Student,Integer> {
    Optional<Student> findStudentByUsername(String username);

}
