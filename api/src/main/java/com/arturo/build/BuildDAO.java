package com.arturo.build;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * Created by Arturo on 12/03/2017.
 */
public interface BuildDAO extends JpaRepository<Build, Long> {

}
