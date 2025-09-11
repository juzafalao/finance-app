package br.com.familyfinance.financeapp.service;

import br.com.familyfinance.financeapp.entity.User;
import br.com.familyfinance.financeapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Cria um novo usuário com senha criptografada
     */
    @Transactional
    public User createUser(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new IllegalArgumentException("E-mail já cadastrado: " + user.getEmail());
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setId(UUID.randomUUID());
        return userRepository.save(user);
    }

    /**
     * Busca usuário por ID
     */
    public User getUserById(UUID id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado com ID: " + id));
    }

    /**
     * Lista todos os usuários
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Atualiza dados do usuário
     */
    @Transactional
    public User updateUser(UUID id, User updatedUser) {
        User existingUser = getUserById(id);

        if (updatedUser.getFullName() != null) {
            existingUser.setFullName(updatedUser.getFullName());
        }

        if (updatedUser.getEmail() != null && !updatedUser.getEmail().equals(existingUser.getEmail())) {
            if (userRepository.findByEmail(updatedUser.getEmail()).isPresent()) {
                throw new IllegalArgumentException("E-mail já cadastrado: " + updatedUser.getEmail());
            }
            existingUser.setEmail(updatedUser.getEmail());
        }

        if (updatedUser.getPassword() != null && !updatedUser.getPassword().isBlank()) {
            existingUser.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
        }

        if (updatedUser.getRole() != null) {
            existingUser.setRole(updatedUser.getRole());
        }

        return userRepository.save(existingUser);
    }

    /**
     * Remove usuário por ID
     */
    @Transactional
    public void deleteUser(UUID id) {
        if (!userRepository.existsById(id)) {
            throw new IllegalArgumentException("Usuário não encontrado com ID: " + id);
        }
        userRepository.deleteById(id);
    }

    /**
     * Busca usuário pelo e-mail
     */
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
