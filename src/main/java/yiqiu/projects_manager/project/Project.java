package yiqiu.projects_manager.project;

import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;

public record Project(Integer id,
                      @NotEmpty
                      String name,
                      String description,
                      LocalDate createdOn) {
}
