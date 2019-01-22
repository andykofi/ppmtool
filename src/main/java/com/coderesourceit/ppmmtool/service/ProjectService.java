package com.coderesourceit.ppmmtool.service;

import com.coderesourceit.ppmmtool.Exceptions.ProjectIdException;
import com.coderesourceit.ppmmtool.domain.Project;
import com.coderesourceit.ppmmtool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository  projectRepository;

    public Project savrOrUpdateProject(Project project) {

        try{
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);

        }catch (Exception e){

            throw new ProjectIdException("Project ID '" + project.getProjectIdentifier().toUpperCase()+"' already exist");
        }

    }

    public Project findProjectByIdentifier(String projectId) {
        return projectRepository.findByProjectIdentifier(projectId);
    }
}
