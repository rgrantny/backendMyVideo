package com.github.rgrantny.myvideo.service;

import com.github.rgrantny.myvideo.model.User;
import com.github.rgrantny.myvideo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository repository;

    @Autowired

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getAll() {
        return repository.findAll();
    }

    public User getById(Integer userId) {
        return repository.findById(userId).orElse(null);
    }

    public User create(User user) {
        User newUser = new User();
        newUser.setUserName(user.getUserName());
        newUser.setPassword(user.getPassword());
        return repository.save(newUser);
    }

    public User update(Integer userId, User user) {
        User foundUser = getById(userId);
        foundUser.setPassword(user.getPassword());
        foundUser.setUserName(user.getUserName());
        repository.save(foundUser);
        return foundUser;
    }

    public User login(User user) {
        User foundUser = repository.findByUserName(user.getUserName()).orElse(null);
        if (foundUser != null)
            if (foundUser.getPassword().equals(user.getPassword()))
                return foundUser;
        return null;
    }

    public User delete(Integer userId) {
        User deletedUser = getById((userId));
        repository.delete(deletedUser);
        return deletedUser;
    }
}
