package com.coderesourceit.ppmtool.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class ProjectNotFoundExceptionResponse extends RuntimeException{

    private String ProjectNotFound;

        public ProjectNotFoundExceptionResponse(String ProjectNotFound) {
            ProjectNotFound = ProjectNotFound;
        }

    public String getProjectNotFound() {
        return ProjectNotFound;
    }

    public void setProjectNotFound(String projectNotFound) {
        ProjectNotFound = projectNotFound;
    }
}
