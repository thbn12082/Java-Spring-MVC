package vn.hoidanit.laptopshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.repository.UserRepository;

@Service
// đây là tầng xử lý logic code
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String handleHello() {
        return "Hello from Service";
    }

    public User handleSaveUser(User user) {
        return this.userRepository.save(user);
    }

    public List<User> handleGetAllUser() {
        return this.userRepository.findAll();
    }

    public List<User> handleGetAllUserByNameAndEmail(String name, String email) {
        return this.userRepository.findFirstByEmailAndAddress(name, email);
    }

    public User handleUserById(long id) {
        return this.userRepository.findById(id);
    }
}
