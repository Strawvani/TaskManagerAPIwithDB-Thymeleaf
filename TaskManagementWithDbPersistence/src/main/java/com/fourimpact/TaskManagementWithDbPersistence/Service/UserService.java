package com.fourimpact.TaskManagementWithDbPersistence.Service;

import com.fourimpact.TaskManagementWithDbPersistence.Exception.ResourceNotFoundException;
import com.fourimpact.TaskManagementWithDbPersistence.Model.User;
import com.fourimpact.TaskManagementWithDbPersistence.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user){

        if (user.getUsername() == null || user.getUsername().isEmpty()){
            throw new IllegalArgumentException("Username cannot be empty");
        }

        if (user.getEmail() == null || user.getEmail().isEmpty()){
            throw new IllegalArgumentException("Email cannot be empty");
        }

        if (userRepository.existsByEmail((user.getEmail()))){
            throw new IllegalArgumentException("Email already exists");
        }

        if (userRepository.existsByUsername((user.getUsername()))){
            throw new IllegalArgumentException("Username already exists");
        }

        return userRepository.save(user);
    }

    public User getUserById(Long id){
        return userRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("user", id));
    }

}
