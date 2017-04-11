package com.arturo.jm2api.build;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Arturo on 12/03/2017.
 */
@RestController
@RequestMapping("/builds")
public class BuildController {

    @Autowired private BuildService buildService;
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Page<Build> list(
            @ModelAttribute Build build,
            @PageableDefault(value = 10, page = 0) Pageable page) {
        return buildService.findBuilds(build, page);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Build get(@PathVariable Long id) {
        return buildService.findBuild(id);
    }
    
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public Build update(@ModelAttribute Build build) {
        return buildService.updateBuild(build);
    }
    
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Build save(@ModelAttribute Build build) {
        return buildService.saveBuild(build);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
    	buildService.deleteBuild(id);
    }

}
