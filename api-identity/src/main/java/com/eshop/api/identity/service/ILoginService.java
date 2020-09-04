package com.eshop.api.identity.service;

public interface ILoginService<T> {

    Boolean ValidateCredentials(T user, String password);

    T FindByUsername(String user);

    T SignIn(T user);
}
