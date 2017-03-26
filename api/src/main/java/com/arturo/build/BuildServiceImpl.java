package com.arturo.build;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Arturo on 12/03/2017.
 */
@Service
@Transactional
public class BuildServiceImpl implements BuildService {

    @Autowired private BuildDAO buildDAO;

    @Override
    public Page<Build> findBuilds() {
        PageRequest pageRequest = new PageRequest(1, 20);
        Page<Build> page = buildDAO.findAll(pageRequest);
        return page;
    }

    @Override
    public Build findBuild(Long id) {
        Build build = buildDAO.findOne(id);
        return build;
    }
}
