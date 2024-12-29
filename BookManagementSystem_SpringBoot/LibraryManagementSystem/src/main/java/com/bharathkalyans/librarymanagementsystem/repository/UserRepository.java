package com.bharathkalyans.librarymanagementsystem.repository;

import com.bharathkalyans.librarymanagementsystem.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users, String> {

    @Query(value = "SELECT * FROM users u where u.username=:username", nativeQuery = true)
    List<Users> findUserByUsername(String username);

}
