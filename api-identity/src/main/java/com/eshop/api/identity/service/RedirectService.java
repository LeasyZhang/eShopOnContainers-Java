package com.eshop.api.identity.service;

import org.springframework.stereotype.Service;

@Service
public class RedirectService implements IRedirectService{
    @Override
    public String extractRedirectUriFromReturnUrl(String url) {
        return null;
    }
}
