package com.springboot.beginner.maven;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity,Integer>{

}
