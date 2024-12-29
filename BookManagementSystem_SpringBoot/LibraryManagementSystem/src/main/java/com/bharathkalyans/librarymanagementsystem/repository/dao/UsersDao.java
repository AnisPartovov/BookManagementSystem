package com.bharathkalyans.librarymanagementsystem.repository.dao;

import com.bharathkalyans.librarymanagementsystem.entity.Users;
import com.bharathkalyans.librarymanagementsystem.repository.UserRepository;
import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsersDao {

    private UserRepository userRepository;

    @Autowired
    public UsersDao(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public Users validateUser(String username) {
        List<Users> userByUsername = userRepository.findUserByUsername(username);
        if (userByUsername != null && userByUsername.size() > 0) return userByUsername.get(0);
        return null;
    }

}
