package yiqiu.projects_manager.project;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

@Component
public class ProjectJsonDataLoader implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(ProjectJsonDataLoader.class);
    private final JdbcClientProjectRepository projectRepository;
    private final ObjectMapper objectMapper;

    public ProjectJsonDataLoader(JdbcClientProjectRepository projectRepository, ObjectMapper objectMapper) {
        this.projectRepository = projectRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws Exception{
        if (projectRepository.count() == 0) {
            try (InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream("data/projects.json")) {
                Projects allProjects = objectMapper.readValue(resourceAsStream, Projects.class);
                projectRepository.saveAll(allProjects.projects());
                log.info("Loaded {} projects from JSON", allProjects.projects().size());
            } catch (IOException e) {
                throw new RuntimeException("Failed to read JSON data", e);
            }
        } else {
            log.info("Not loading Projects from JSON data because the collection contains data.");
        }
    }
}
