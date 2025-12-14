package manager.crud_tasks.services.impl;

import manager.crud_tasks.dto.TaskDto;
import manager.crud_tasks.dto.TaskResponse;
import manager.crud_tasks.exceptions.TaskNotFoundException;
import manager.crud_tasks.model.Task;
import manager.crud_tasks.repository.TaskRepository;
import manager.crud_tasks.services.TaskServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServicesImpl implements TaskServices {
    private TaskRepository taskRepository;

    @Autowired
    public TaskServicesImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public TaskDto getTaskById(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("Task not found"));
        return mapToDto(task);
    }

    @Override
    public TaskResponse getAllTasks(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Task> tasks = taskRepository.findAll(pageable);
        List<Task> listTasks = tasks.getContent();
        List<TaskDto> content = listTasks.stream().map(task -> mapToDto(task)).collect(Collectors.toList());

        TaskResponse taskResponse = new TaskResponse();
        taskResponse.setContent(content);
        taskResponse.setPageNo(tasks.getNumber());
        taskResponse.setPageSize(tasks.getSize());
        taskResponse.setTotalElements(tasks.getTotalElements());
        taskResponse.setTotalPages(tasks.getTotalPages());
        taskResponse.setLast(tasks.isLast());
        return taskResponse;
    }

    @Override
    public TaskDto createTask(TaskDto taskDto) {
        Task task = new Task();

        task.setTitulo(taskDto.getTitulo());
        task.setDescricao(taskDto.getDescricao());
        task.setStatus(taskDto.getStatus());

        Task newTask = taskRepository.save(task);

        TaskDto taskResponse = new TaskDto();
        taskResponse.setId(newTask.getId());
        taskResponse.setTitulo(newTask.getTitulo());
        taskResponse.setDescricao(newTask.getDescricao());
        taskResponse.setStatus(newTask.getStatus());
        return taskResponse;
    }

    @Override
    public TaskDto updateTask(Long id, TaskDto taskDto) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("Task not found"));

        task.setTitulo(taskDto.getTitulo());
        task.setDescricao(taskDto.getDescricao());
        task.setStatus(taskDto.getStatus());

        Task updatedTask = taskRepository.save(task);
        return mapToDto(updatedTask);
    }

    @Override
    public void deleteTask(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("Task not found"));
        taskRepository.delete(task);
    }

    private TaskDto mapToDto(Task task) {
        TaskDto taskDto = new TaskDto();
        taskDto.setId(task.getId());
        taskDto.setTitulo(task.getTitulo());
        taskDto.setDescricao(task.getDescricao());
        taskDto.setStatus(task.getStatus());
        return taskDto;
    }
    private Task mapToEntity(TaskDto taskDto) {
        Task task = new Task();
        task.setId(taskDto.getId());
        task.setTitulo(taskDto.getTitulo());
        task.setDescricao(taskDto.getDescricao());
        task.setStatus(taskDto.getStatus());
        return task;
    }
}
