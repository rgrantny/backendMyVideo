package com.github.rgrantny.myvideo.repository;

import com.github.rgrantny.myvideo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(nativeQuery = true, value = "SELECT user_id from user WHERE user_name = ?1")
    Optional<User> findByUserName(String userName);
}
