package com.eshop.api.identity.repo;

import com.eshop.api.identity.model.SysUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends CrudRepository<SysUser, Long> {

    Optional<SysUser> findSysUserByName(String userName);
}
