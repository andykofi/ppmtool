package com.coderesourceit.ppmmtool.web;

import com.coderesourceit.ppmmtool.domain.Project;
import com.coderesourceit.ppmmtool.service.MapValidationErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.coderesourceit.ppmmtool.service.ProjectService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    MapValidationErrorService mapValidationErrorService;

    @PostMapping("")
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result){

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
         if(errorMap!=null) return errorMap;

        Project proj = projectService.savrOrUpdateProject(project);
        return new ResponseEntity<Project>(proj, HttpStatus.CREATED);
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<Project> getprojectById(@PathVariable  String projectId) {
        Project project = projectService.findProjectByIdentifier(projectId);

        return  new ResponseEntity <Project>(project, HttpStatus.OK);

        }
    }
