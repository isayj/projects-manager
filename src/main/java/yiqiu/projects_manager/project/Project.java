package yiqiu.projects_manager.project;

import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

import java.time.LocalDate;

public record Project(
    @Id
    Integer id,
    @NotEmpty
    String name,
    String description,
    LocalDate createdOn,
    @Version
    Integer version
) {
}
