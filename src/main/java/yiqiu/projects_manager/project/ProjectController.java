package yiqiu.projects_manager.project;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
    private final ProjectRepository projectRepository;

    public ProjectController(ProjectRepository projectRepository){
        this.projectRepository = projectRepository;
    }

    @GetMapping("")
    List<Project> findAll(){
        return projectRepository.findAll();
    }

    @GetMapping("/{id}")
    Project findById(@PathVariable Integer id){
        Optional<Project> project = projectRepository.findById(id);
        if(project.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return project.get();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void create(@Valid @RequestBody Project project){
        projectRepository.create(project);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("{id}")
    void update(@Valid @RequestBody Project project, @PathVariable Integer id){
        projectRepository.update(project, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    void delete(@PathVariable Integer id) {
        projectRepository.delete(id);
    }
}
