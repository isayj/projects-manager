package yiqiu.projects_manager.project;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class ProjectRepository {
    private final List<Project> projects = new ArrayList<>();

    List<Project> findAll(){
        return projects;
    }

    void create(Project project){
        projects.add(project);
    }

    void update(Project project, Integer id){
        Optional<Project> existingProject = findById(id);
        existingProject.ifPresent(value -> projects.set(projects.indexOf(value), project));
    }

    void delete(Integer id){
        projects.removeIf(project -> project.id().equals(id));
    }

    @PostConstruct
    private void init(){
        projects.add(new Project(1, "Project 1", "Description 1", LocalDate.now()));
        projects.add(new Project(2, "Project 2", "Description 2", LocalDate.now()));
        projects.add(new Project(3, "Project 3", "Description 3", LocalDate.now()));
    }

    public Optional<Project> findById(Integer id) {
        return projects.stream().filter(project -> Objects.equals(project.id(), id)).findFirst();
    }
}
