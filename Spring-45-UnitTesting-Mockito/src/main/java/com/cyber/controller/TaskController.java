package com.cyber.controller;

import com.cyber.dto.TaskDTO;
import com.cyber.enums.Status;
import com.cyber.service.ProjectService;
import com.cyber.service.TaskService;
import com.cyber.service.UserService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/task")
public class TaskController {

    ProjectService projectService;
    UserService userService;
    TaskService taskService;

    public TaskController(@Lazy  ProjectService projectService, UserService userService, TaskService taskService) {
        this.projectService = projectService;
        this.userService = userService;
        this.taskService = taskService;
    }

    @GetMapping("/create")
    public String createTask(Model model){
        model.addAttribute("task", new TaskDTO());
        model.addAttribute("projects",projectService.listAllProjects());
        model.addAttribute("employees",userService.listAllByRole("employee"));
        model.addAttribute("tasks",taskService.listAllTasks());
        return "/task/create";
    }

    @PostMapping("/create")
    public String addTask(TaskDTO task, Model model) {
        taskService.save(task);
        return "redirect:/task/create";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable("id") Long id){
        taskService.delete(id);
        return "redirect:/task/create";
    }

    @GetMapping("/update/{id}")
    public String editTask(@PathVariable("id") Long id, Model model) {
        model.addAttribute("task", taskService.findById(id));
        model.addAttribute("projects", projectService.listAllProjects());
        model.addAttribute("employees", userService.listAllByRole("employee"));
        model.addAttribute("tasks", taskService.listAllTasks());
        return "/task/update";
    }

    @PostMapping("/update/{id}")
    public String updateTask(@PathVariable("id") Long id,TaskDTO task,Model model) {
        taskService.update(task);
        return "redirect:/task/create";
    }

    @GetMapping("employee")
    public String edit(Model model){
        List<TaskDTO> tasks = taskService.listAllTasksByStatusIsNot(Status.COMPLETE);
        model.addAttribute("tasks",tasks);
        return "task/employee-tasks";
    }

    @GetMapping("employee/edit/{id}")
    public String employee_update(@PathVariable("id") Long id, Model model){

        TaskDTO task = taskService.findById(id);
        List<TaskDTO> tasks = taskService.listAllTasksByStatusIsNot(Status.COMPLETE);

        model.addAttribute("task",task);
        model.addAttribute("users",userService.listAllByRole("employee"));
        model.addAttribute("projects",projectService.listAllProjects());
        model.addAttribute("tasks",tasks);
        model.addAttribute("statuses",Status.values());

        return "task/employee-update";
    }

    @PostMapping("/employee/update/{id}")
    public String employee_update(@PathVariable("id") Long id, TaskDTO taskDTO){
        taskService.updateStatus(taskDTO);
        return "redirect:/task/employee";
    }

    @GetMapping("/employee/archive")
    public String employee_archive(Model model){
        List<TaskDTO> tasks = taskService.listAllTasksByStatus(Status.COMPLETE);
        model.addAttribute("tasks",tasks);
        return "task/employee-archive";
    }



}
