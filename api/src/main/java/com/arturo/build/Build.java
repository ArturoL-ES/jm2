package com.arturo.build;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Arturo on 12/03/2017.
 */
@Entity
public class Build {

    @Id
    private Long id;

    public Build() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
