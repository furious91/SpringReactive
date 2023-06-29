package sigua.giorgi.reactive.SpringReactive.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import sigua.giorgi.reactive.SpringReactive.model.Student;
import sigua.giorgi.reactive.SpringReactive.repo.StudentRepository;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Mono<Student> save(Student student) {
        return studentRepository.save(student);
    }

    public Flux<Student> findAll() {
        return studentRepository.findAll().delayElements(Duration.ofSeconds(1));
    }

    public Mono<Student> fidnById(Integer id) {
        return studentRepository.findById(id);
    }

}
