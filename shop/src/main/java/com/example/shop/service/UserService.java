package com.example.shop.service;

import com.example.shop.dto.UserDtO;
import com.example.shop.entity.User;
import com.example.shop.exception.UserNotFoundException;
import com.example.shop.mapper.UserMapper;
import com.example.shop.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper = UserMapper.INSTANCE;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDtO> getAllUsers() {
        // Tüm kullanıcıları veritabanından al
        List<User> users = userRepository.findAll();

        // Kullanıcıları yazdır
        System.out.println("Users from repository:");
        users.forEach(user -> System.out.println(user.toString()));

        List<UserDtO> userDTOs = users.stream()
                .map(user -> {
                    UserDtO userDTO = userMapper.userToUserDtO(user);
                    System.out.println("Mapped UserDTO: " + userDTO.toString());
                    return userDTO;
                })
                .collect(Collectors.toList());

        // Sonuç listesini yazdır
        System.out.println("Final UserDTO List:");
        userDTOs.forEach(userDTO -> System.out.println(userDTO.toString()));

        return userDTOs;
    }

    public Optional<UserDtO> getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
        return Optional.of(userMapper.userToUserDtO(user));
    }

    public UserDtO createUser(UserDtO userDtO) {
        User user = UserMapper.INSTANCE.userDtOToUser(userDtO);
        user = userRepository.save(user);
        return UserMapper.INSTANCE.userToUserDtO(user);
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
}