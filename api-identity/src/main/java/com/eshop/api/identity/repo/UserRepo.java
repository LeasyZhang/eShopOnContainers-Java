package com.eshop.api.identity.repo;

import com.eshop.api.identity.model.SysUser;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<SysUser, Long> {
}
