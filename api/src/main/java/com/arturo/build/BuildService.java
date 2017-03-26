package com.arturo.build;

import org.springframework.data.domain.Page;

/**
 * Created by Arturo on 12/03/2017.
 */
public interface BuildService {

    public Page<Build> findBuilds();

    public Build findBuild(Long id);

}
