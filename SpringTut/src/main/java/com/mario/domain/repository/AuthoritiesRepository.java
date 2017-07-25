package com.mario.domain.repository;

import com.mario.domain.model.auth.Authority;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mario on 09.12.16.
 */
@Repository
public interface AuthoritiesRepository
	extends CrudRepository<Authority, Authority.Role> {
}
