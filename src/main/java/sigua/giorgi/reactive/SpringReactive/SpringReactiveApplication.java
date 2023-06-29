package sigua.giorgi.reactive.SpringReactive;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import sigua.giorgi.reactive.SpringReactive.model.Student;
import sigua.giorgi.reactive.SpringReactive.service.StudentService;

import java.util.List;

@SpringBootApplication
public class SpringReactiveApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringReactiveApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentService studentService) {
		return args -> {
			Flux<Student> studentsFlux = studentService.findAll();
			List<Student> students = studentsFlux.collectList().block();
			// students.forEach(System.out::println);
			if (students.size() == 0) {
				for (int i=0; i<100; i++) {
					studentService.save(
							Student.builder()
									.firstname("Giorgi " + i)
									.lastname("Sigua " + i)
									.age(i)
									.build()
					).subscribe();
				}
			}
		};
	}

}
