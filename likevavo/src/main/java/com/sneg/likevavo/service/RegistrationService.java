package com.sneg.likevavo.service;

import javax.transaction.Transactional;


import com.sneg.likevavo.entities.User;


public interface RegistrationService {
    @Transactional
    public void register(User user);
}
