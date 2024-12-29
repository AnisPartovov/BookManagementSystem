package com.bharathkalyans.librarymanagementsystem.service;

import com.bharathkalyans.librarymanagementsystem.entity.Users;

public interface LoginService {

    public Users validateUser(String username);

}
