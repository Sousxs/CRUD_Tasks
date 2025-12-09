package manager.crud_tasks.services.impl;

import manager.crud_tasks.dto.TaskDto;
import manager.crud_tasks.repository.TaskRepository;
import manager.crud_tasks.services.TaskServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServicesImpl implements TaskServices {
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public TaskDto getAllTasks() {
        return null;
    }

    @Override
    public TaskDto createTask(TaskDto taskDto) {
        return null;
    }

    @Override
    public TaskDto updateTask(Long id, TaskDto taskDto) {
        return null;
    }

    @Override
    public void deleteTask(Long id) {

    }
}
