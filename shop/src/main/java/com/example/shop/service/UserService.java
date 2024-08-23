package com.example.shop.service;

import com.example.shop.dto.UserDtO;
import com.example.shop.entity.User;
import com.example.shop.exception.UserNotFoundException;
import com.example.shop.mapper.UserMapper;
import com.example.shop.repository.UserRepository;
import com.example.shop.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    private JwtUtil jwtUtil;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<UserDtO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return userMapper.toDTOList(users);
    }

    public Optional<UserDtO> getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
        return Optional.of(userMapper.userToUserDtO(user));
    }
    public Optional<UserDtO> getUserByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("User not found with username: " + username));
        return Optional.of(userMapper.userToUserDtO(user));
    }

    public UserDtO getUserInfoFromToken(String token) {
        String username = jwtUtil.extractUsername(token);
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("User not found with username: " + username));
        UserDtO userDto = userMapper.userToUserDtO(user);
        return userDto;
    }
    public UserDtO createUser(UserDtO userDtO) {
        User user = userMapper.userDtOToUser(userDtO);
        user = userRepository.save(user);
        return userMapper.userToUserDtO(user);
    }

    public UserDtO saveUser(UserDtO userDtO) {
        User user = userMapper.userDtOToUser(userDtO);
        user.setPassword(user.getPassword());
        user = userRepository.save(user);
        return userMapper.userToUserDtO(user);
    }

    public void updateUser(Long id, UserDtO userDtO) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));

        if (userDtO.getUsername() != null) {
            user.setUsername(userDtO.getUsername());
        }
        if (userDtO.getEmail() != null) {
            user.setEmail(userDtO.getEmail());
        }
        if (userDtO.getCustomerName() != null) {
            user.setCustomerName(userDtO.getCustomerName());
        }
        if (userDtO.getCustomerSurname() != null) {
            user.setCustomerSurname(userDtO.getCustomerSurname());
        }
        if (userDtO.getPassword() != null && !userDtO.getPassword().isEmpty()) {
            user.setPassword(userDtO.getPassword());
        }

        userRepository.save(user);
    }

    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException("User not found with id: " + id);
        }
        userRepository.deleteById(id);
    }
    public User getCurrentUser(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

}