package manager.crud_tasks.repository;

import manager.crud_tasks.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {
    Optional<Task> findByStatus(Enum status);
}
