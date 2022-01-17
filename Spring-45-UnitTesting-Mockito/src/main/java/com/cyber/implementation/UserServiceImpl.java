package com.cyber.implementation;

import com.cyber.dto.ProjectDTO;
import com.cyber.dto.TaskDTO;
import com.cyber.dto.UserDTO;
import com.cyber.entity.User;
import com.cyber.exception.TicketNGProjectException;
import com.cyber.mapper.MapperUtil;
import com.cyber.repository.UserRepository;
import com.cyber.service.ProjectService;
import com.cyber.service.TaskService;
import com.cyber.service.UserService;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;
    private ProjectService projectService;
    private TaskService taskService;
    private MapperUtil mapperUtil;

    public UserServiceImpl(@Lazy UserRepository userRepository, @Lazy ProjectService projectService, TaskService taskService, MapperUtil mapperUtil) {
        this.userRepository = userRepository;
        this.projectService = projectService;
        this.taskService = taskService;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public List<UserDTO> listAllUsers() {
        List<User> list = userRepository.findAll(Sort.by("firstName"));
        return list.stream().map(obj -> {return mapperUtil.convert(obj,new UserDTO());}).collect(Collectors.toList());
    }

    @Override
    public UserDTO findByUserName(String username) {

        User user = userRepository.findByUserName(username);
        return mapperUtil.convert(user,new UserDTO());
    }

    @Override
    public void save(UserDTO dto) {
        User obj = mapperUtil.convert(dto,new User());
        userRepository.save(obj);
    }

    @Override
    public UserDTO update(UserDTO dto) {

        //find current user - that has id
        User user = userRepository.findByUserName(dto.getUserName());
        //map user dto into entity object
        User convertedUser = mapperUtil.convert(dto,new User());
        //set id to the converted object
        convertedUser.setId(user.getId());
        //save updated user
        userRepository.save(convertedUser);

        return  findByUserName(dto.getUserName());
    }

    @Override
    public void delete(String username) throws TicketNGProjectException {
        User user = userRepository.findByUserName(username);

        //check if user is deleted in DB to avoid the crash of the app !!
        if(user == null){
            throw new TicketNGProjectException("User does not exist !!");
        }

        //check if user can be deleted
        if(!checkIfUserCanBeDeleted(user)){
            throw new TicketNGProjectException("User cannot be deleted. It is linked by a project or a task !!");
        }

        //since username is unique, if I delete it, it will be set true with the following code in DB -- so, I cannot create with same username
        user.setUserName(user.getUserName() + "-" + user.getId());

        user.setIsDeleted(true); //now, related row in DB will not be deleted !!
        userRepository.save(user);
    }

    @Override
    public void deleteByUserName(String username) {
        userRepository.deleteByUserName(username);
    }

    @Override
    public List<UserDTO> listAllByRole(String role) {
        List<User> users = userRepository.findAllByRoleDescriptionIgnoreCase(role);
        return users.stream().map(obj -> {return mapperUtil.convert(obj,new UserDTO());}).collect(Collectors.toList());
    }

    @Override
    public Boolean checkIfUserCanBeDeleted(User user) {

        switch (user.getRole().getDescription()){
            case "Manager":
                List<ProjectDTO> projectList = projectService.readAllByAssignedManager(user);
                return projectList.size() == 0;
            case "Employee":
                List<TaskDTO> taskList = taskService.readAllByEmployee(user);
                return taskList.size() == 0;
            default:
                return true;
        }
    }
}
