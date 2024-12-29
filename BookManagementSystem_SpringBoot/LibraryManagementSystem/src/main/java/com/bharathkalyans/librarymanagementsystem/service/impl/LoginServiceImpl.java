package com.bharathkalyans.librarymanagementsystem.service.impl;

import com.bharathkalyans.librarymanagementsystem.entity.Users;
import com.bharathkalyans.librarymanagementsystem.repository.dao.UsersDao;
import com.bharathkalyans.librarymanagementsystem.service.LoginService;
import org.springframework.stereotype.Service;


@Service
public class LoginServiceImpl implements LoginService {


    UsersDao usersDao;

    public LoginServiceImpl(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    @Override
    public Users validateUser(String username) {
        Users user = usersDao.validateUser(username);
        if (user != null) return user;
        return null;
    }
}
