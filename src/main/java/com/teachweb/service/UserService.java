package com.teachweb.service;

import com.teachweb.model.User;

public interface UserService {

    boolean register(User user);

    boolean loginCheck(User user);

    boolean exist(User user);

    void updatePassword(User user);

}
