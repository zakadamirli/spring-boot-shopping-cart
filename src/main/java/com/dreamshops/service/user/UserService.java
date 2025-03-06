package com.dreamshops.service.user;

import com.dreamshops.dto.UserDto;
import com.dreamshops.exceptions.AlreadyExistsException;
import com.dreamshops.exceptions.ResourceNotFoundException;
import com.dreamshops.model.User;
import com.dreamshops.repository.UserRepository;
import com.dreamshops.request.CreateUserRequest;
import com.dreamshops.request.UserUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @Override
    public User createUser(CreateUserRequest userRequest) {
        return Optional.of(userRequest)
                .filter(user -> !userRepository.existsByEmail(userRequest.getEmail()))
                .map(req -> {
                    User user = new User();
                    user.setEmail(userRequest.getEmail());
                    user.setFirstName(userRequest.getFirstName());
                    user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
                    user.setPassword(userRequest.getPassword());
                    return userRepository.save(user);
                }).orElseThrow(() -> new AlreadyExistsException("Oops! " + userRequest.getEmail() + " User already exists"));
    }

    @Override
    public User updateUser(UserUpdateRequest request, Long userId) {
        return userRepository.findById(userId).map(existingUser -> {
            existingUser.setFirstName(request.getFirstName());
            existingUser.setLastName(request.getLastName());
            return userRepository.save(existingUser);
        }).orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.findById(userId).ifPresentOrElse(userRepository::delete, () -> {
            throw new ResourceNotFoundException("User not found");
        });
    }

    @Override
    public UserDto convertUserToDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public User getAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        return userRepository.findByEmail(email);
    }
}
