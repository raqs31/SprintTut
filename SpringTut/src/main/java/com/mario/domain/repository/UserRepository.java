package com.mario.domain.repository;

import com.mario.domain.model.auth.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by raqsW on 2016-08-18.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
		User findOneByUserNameOrEmailAllIgnoreCase(String userName, String email);

}
