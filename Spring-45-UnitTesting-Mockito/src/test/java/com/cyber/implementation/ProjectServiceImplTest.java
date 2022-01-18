package com.cyber.implementation;

import com.cyber.dto.ProjectDTO;
import com.cyber.entity.Project;
import com.cyber.enums.Status;
import com.cyber.mapper.MapperUtil;
import com.cyber.mapper.ProjectMapper;
import com.cyber.repository.ProjectRepository;
import com.cyber.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProjectServiceImplTest {

    @Mock
    ProjectRepository projectRepository;

    @Mock
    ProjectMapper projectMapper;

    @InjectMocks
    ProjectServiceImpl projectService;

    @Test
    void getByProjectCode() {
        Project project = new Project();
        ProjectDTO projectDTO = new ProjectDTO();

        when(projectRepository.findByProjectCode("PR01")).thenReturn(project);
        when(projectMapper.convertToDto(project)).thenReturn(projectDTO);

        ProjectDTO project_DTO = projectService.getByProjectCode("PR01");

        // below extra --

        //verify(projectRepository).findByProjectCode("PR01");
        //verify(projectMapper).convertToDto(project);
        verify(projectRepository).findByProjectCode(Mockito.anyString());
        verify(projectMapper).convertToDto(Mockito.any(Project.class));

        assertNotNull(project_DTO);
    }

    @Test
    void getByProjectCode_exception_test(){
        when(projectRepository.findByProjectCode("")).thenThrow(new RuntimeException("Project Not Found"));
        Throwable exception = assertThrows(RuntimeException.class, () -> projectService.getByProjectCode(""));

        verify(projectRepository).findByProjectCode(Mockito.anyString());
        assertEquals(exception.getMessage(),"Project Not Found");
    }

    @Test
    void saveTest(){
        Project project = new Project();
        ProjectDTO projectDTO = new ProjectDTO();

        when(projectMapper.convertToEntity(projectDTO)).thenReturn(project);
        when(projectRepository.save(project)).thenReturn(project);

        projectService.save(projectDTO);

        //verify projectRepository.save(project) executed
        verify(projectRepository).save(project);
    }







}