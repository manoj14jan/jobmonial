package com.genuinehire.repository;

import com.genuinehire.domain.JobSeeker;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public interface AdminRepository extends CrudRepository<JobSeeker,Long> {

    @Query("SELECT u FROM JobSeeker u where u.firstName=:name")
    List<JobSeeker> findAllUsersByUsername(@Param("name") String name);
    
    @Query("SELECT u FROM JobSeeker u where u.profileTitle=:profileTitle")
    List<JobSeeker> findAllUsersByprofileTitle(@Param("profileTitle") String profileTitle);


    @Query("SELECT u FROM JobSeeker u where u.profileTitle=:profileTitle and u.firstName=:name")
    List<JobSeeker> findAllUsersByprofileTitleAndName(@Param("profileTitle") String profileTitle,@Param("name") String name);
    
    @Query("UPDATE user set is_enabled=0 where id=:user_id")
    void block(@Param("user_id") Long user_id);

}
