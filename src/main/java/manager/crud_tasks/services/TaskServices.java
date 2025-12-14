package manager.crud_tasks.services;

import manager.crud_tasks.dto.TaskDto;
import manager.crud_tasks.dto.TaskResponse;

public interface TaskServices {
    TaskResponse getAllTasks(int pageNo, int pageSize);
    TaskDto getTaskById(Long id);
    TaskDto createTask(TaskDto taskDto);
    TaskDto updateTask(Long id, TaskDto taskDto);
    void deleteTask(Long id);
}
