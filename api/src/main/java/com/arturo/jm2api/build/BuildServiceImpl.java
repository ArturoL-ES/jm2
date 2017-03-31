package com.arturo.jm2api.build;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.NullHandler;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Arturo on 12/03/2017.
 */
@Service
public class BuildServiceImpl implements BuildService {

    @Autowired private BuildDAO buildDAO;

    @Override
    @Transactional(readOnly = true)
    public Page<Build> findBuilds(Build build, Pageable page) {
        ExampleMatcher matcher = ExampleMatcher
            .matchingAll()
            .withNullHandler(NullHandler.IGNORE);
        Page<Build> response = buildDAO.findAll(Example.of(build, matcher), page);
        return response;
    }

    @Override
    @Transactional(readOnly = true)
    public Build findBuild(Long id) {
        Build build = buildDAO.findOne(id);
        return build;
    }
    
    @Override
    @Transactional
    public Build updateBuild(Build build) {
        if (build.getId() == null) {
            // If build not exists, wrong method, is save.
            return null;
        }
        return buildDAO.save(build);
    }
    
    @Override
    @Transactional
    public Build saveBuild(Build build) {
        if (build.getId() != null && buildDAO.exists(build.getId())) {
            // If build exists, wrong method, is update.
            return null;
        }
        return buildDAO.save(build);
    }
}
