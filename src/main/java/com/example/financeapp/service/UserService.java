package com.example.financeapp.service;

import com.example.financeapp.model.User;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();
    void saveUser(User user);
    Optional<User>  getUserById(String id);
    void deleteUserById(String id);
    Page<User> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);


}
