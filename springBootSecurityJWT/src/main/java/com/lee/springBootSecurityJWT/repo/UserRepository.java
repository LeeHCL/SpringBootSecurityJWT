package com.lee.springBootSecurityJWT.repo;

import org.springframework.data.repository.CrudRepository;

import com.lee.springBootSecurityJWT.model.DAOUser;

public interface UserRepository extends CrudRepository<DAOUser, Long>{

}
