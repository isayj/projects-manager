package yiqiu.projects_manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

//	@Bean
//	CommandLineRunner runner(ProjectRepository projectRepository) {
//		return args -> {
//			Project project = new Project(1, "Project 1", "Description 1", LocalDate.now());
//			projectRepository.create(project);
//		};
//	}
}
