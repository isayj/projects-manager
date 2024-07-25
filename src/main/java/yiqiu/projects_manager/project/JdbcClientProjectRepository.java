package yiqiu.projects_manager.project;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Repository
public class JdbcClientProjectRepository {

    private final JdbcClient jdbcClient;

    public JdbcClientProjectRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public List<Project> findAll() {
        return jdbcClient.sql("SELECT * FROM Project")
                .query(Project.class)
                .list();
    }

    public Optional<Project> findById(Integer id) {
        return jdbcClient.sql("SELECT id, name, description, created_on FROM Project WHERE id = ?")
                .param(id)
                .query(Project.class).optional();
    }

    public void create(Project project) {
        var created = jdbcClient.sql("INSERT INTO Project(id, name, description, created_on) VALUES (?,?,?,?)")
                .params(List.of(project.id(), project.name(), project.description(), project.createdOn()))
                .update();
        Assert.state(created == 1, "Failed to create project" + project.name());
    }

    public void update(Project project, Integer id) {
        var updated = jdbcClient.sql("UPDATE Project SET name = ?, description = ?, created_on = ? WHERE id = ?")
                .params(List.of(project.name(), project.description(), project.createdOn(), id))
                .update();
        Assert.state(updated == 1, "Failed to update project" + project.name());
    }

    public void delete(Integer id) {
        var deleted = jdbcClient.sql("DELETE FROM Project WHERE id = ?")
                .param(id)
                .update();
        Assert.state(deleted == 1, "Failed to delete project with id" + id);
    }

    public int count() {
        return jdbcClient.sql("SELECT * FROM Project").query().listOfRows().size();
    }

    public void saveAll(List<Project> projects) {
        projects.forEach(this::create);
    }

    public List<Project> filterProjectsByDate(String startDate, String endDate) {
        return jdbcClient.sql("SELECT * FROM Project WHERE created_on >= CAST(? AS DATE) AND created_on <= CAST(? AS DATE)")
                .param(startDate)
                .param(endDate)
                .query(Project.class)
                .list();
    }
}
