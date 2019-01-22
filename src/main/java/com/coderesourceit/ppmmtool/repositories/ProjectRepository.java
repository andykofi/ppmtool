package com.coderesourceit.ppmmtool.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.coderesourceit.ppmmtool.domain.Project;

@Repository
public interface ProjectRepository  extends CrudRepository< Project, Long> {

    Project findByProjectIdentifier(String  projectId);

    //@Override
    //Iterable<Project> findAllById(Iterable<Long> Iterable);
}
