package manager.crud_tasks.controller;

import manager.crud_tasks.dto.TaskDto;
import manager.crud_tasks.dto.TaskResponse;
import manager.crud_tasks.services.TaskServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskServices taskServices;

    @Autowired
    public TaskController(TaskServices taskServices) {
        this.taskServices = taskServices;
    }

    @GetMapping
    public ResponseEntity<TaskResponse> getTasks(
            @RequestParam(value =  "pageNo", defaultValue = "0", required = false) Integer pageNo,
            @RequestParam(value =  "pageSize", defaultValue = "10", required = false) Integer pageSize
    ) {
        return new ResponseEntity<>(taskServices.getAllTasks(pageNo,pageSize), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable Long id) {
        return ResponseEntity.ok(taskServices.getTaskById(id));
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<TaskDto> createTask(@RequestBody TaskDto taskDto) {
        return new ResponseEntity<>(taskServices.createTask(taskDto), HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<TaskDto> updateTask(@RequestBody TaskDto taskDto,@PathVariable("id") Long taskId) {
        TaskDto response = taskServices.updateTask(taskId, taskDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Long id) {
        taskServices.deleteTask(id);
        return new ResponseEntity<>("Task deleted successfully", HttpStatus.OK);
    }
}

