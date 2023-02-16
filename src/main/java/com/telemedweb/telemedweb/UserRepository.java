package com.telemedweb.telemedweb;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByType (int type);
    User findByEmailAndPassword (String email, String password);
}