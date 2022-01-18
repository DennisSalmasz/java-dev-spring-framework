package com.cyber.mapper;

import com.cyber.dto.ProjectDTO;
import com.cyber.entity.Project;
import com.cyber.repository.ProjectRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProjectMapper {

    private ModelMapper modelMapper;
    private ProjectRepository projectRepository;

    public ProjectMapper(ModelMapper modelMapper, ProjectRepository projectRepository) {
        this.modelMapper = modelMapper;
        this.projectRepository = projectRepository;
    }

    public Project convertToEntity(ProjectDTO dto){
        return modelMapper.map(dto,Project.class);
    }

    public ProjectDTO convertToDto(Project entity){
        return modelMapper.map(entity,ProjectDTO.class);
    }
}
