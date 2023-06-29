package sigua.giorgi.reactive.SpringReactive.repo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import sigua.giorgi.reactive.SpringReactive.model.Student;

public interface StudentRepository extends ReactiveCrudRepository<Student, Integer> {

    Flux<Student> findAllByFirstnameIgnoreCase(String firstname);
    Flux<Student> updateStudentByFirstname(String firstName);

}
