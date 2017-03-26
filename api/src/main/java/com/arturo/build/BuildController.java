package com.arturo.build;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Arturo on 12/03/2017.
 */
@RestController
@RequestMapping("/builds")
public class BuildController {

    @Autowired private BuildService buildService;

    @RequestMapping("")
    public Page<Build> builds() {
        Page<Build> builds = buildService.findBuilds();
        return builds;
    }

    @RequestMapping("/{id}")
    public Build build(@PathVariable Long id) {
        Build build = buildService.findBuild(id);
        return build;
    }

}
