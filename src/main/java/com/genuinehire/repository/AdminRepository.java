package com.genuinehire.repository;

import com.genuinehire.domain.JobSeeker;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public interface AdminRepository extends CrudRepository<JobSeeker,Long> {



    @Query("SELECT u FROM JobSeeker u where u.firstName=:name")
    List<JobSeeker> findAllUsers(@Param("name") String name);
}
