package com.eshop.api.identity.service;

import com.eshop.api.identity.model.SysUser;
import com.eshop.api.identity.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LoginService implements ILoginService<SysUser> {

    private final UserRepo userRepo;

    @Override
    public Boolean ValidateCredentials(SysUser user, String password) {
        return null;
    }

    @Override
    public SysUser FindByUsername(String username) {
        return userRepo.findSysUserByName(username)
                .map(user -> user)
                .orElseGet(() -> new SysUser());
    }

    @Override
    public SysUser SignIn(SysUser user) {
        return userRepo.save(user);
    }
}
