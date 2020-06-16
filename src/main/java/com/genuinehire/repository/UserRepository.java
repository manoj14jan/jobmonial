package com.genuinehire.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.genuinehire.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    public User findByUsername(String username);

}