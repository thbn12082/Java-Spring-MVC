package vn.hoidanit.laptopshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.hoidanit.laptopshop.domain.Role;
import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.domain.dto.RegisterDTO;
import vn.hoidanit.laptopshop.repository.RoleRepository;
import vn.hoidanit.laptopshop.repository.UserRepository;

@Service
// đây là tầng xử lý logic code
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;

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

    public void handleDelUserById(long id) {
        this.userRepository.deleteById(id);
    }

    public Role getRoleByName(String name) {
        return this.roleRepository.findByName(name);
    }

    // phaanf mapping thif vieets trong service

    public User registerDTOtoUser(RegisterDTO registerDTO) {
        User trans = new User();
        trans.setFullname(registerDTO.getFirstName() + " " + registerDTO.getLastName());
        trans.setEmail(registerDTO.getEmail());
        // đang làm th hoàn hảo
        trans.setPassword(registerDTO.getPassword());
        return trans;
    }

    public User handleUserByFullname(String name) {
        return this.userRepository.findByFullname(name);
    }

    public User handleUserByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }

    public boolean checkValidEmail(String email) {
        return this.userRepository.existsByEmail(email);
    }

}
