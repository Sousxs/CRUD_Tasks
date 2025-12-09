package manager.crud_tasks.controller;

import lombok.RequiredArgsConstructor;
import manager.crud_tasks.dto.TaskDto;
import manager.crud_tasks.services.TaskServices;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskServices taskServices;

    @GetMapping("/all")
    public TaskDto getAllTasks() {
        return taskServices.getAllTasks();
    }
    @PostMapping("/create")
    public TaskDto createTask() {
        return taskServices.createTask(null);
    }
    @PutMapping("/update/{id}")
    public TaskDto updateTask(@PathVariable Long id) {
        return taskServices.updateTask(id, null);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskServices.deleteTask(id);
    }
}

