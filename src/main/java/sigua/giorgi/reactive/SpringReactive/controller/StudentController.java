package sigua.giorgi.reactive.SpringReactive.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import sigua.giorgi.reactive.SpringReactive.model.Student;
import sigua.giorgi.reactive.SpringReactive.service.StudentService;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public Mono<Student> save(@RequestBody Student student) {
        return studentService.save(student);
    }

    @GetMapping
    public Flux<Student> findAll() {
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Student> findById(@PathVariable Integer id) {
        return studentService.fidnById(id);
    }

}
