package manager.crud_tasks.services;

import manager.crud_tasks.dto.TaskDto;

public interface TaskServices {
    TaskDto getAllTasks();
    TaskDto createTask(TaskDto taskDto);
    TaskDto updateTask(Long id, TaskDto taskDto);
    void deleteTask(Long id);
}
