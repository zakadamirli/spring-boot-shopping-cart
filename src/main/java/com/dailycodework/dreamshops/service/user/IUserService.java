package com.dailycodework.dreamshops.service.user;

import com.dailycodework.dreamshops.model.User;
import com.dailycodework.dreamshops.request.CreateUserRequest;
import com.dailycodework.dreamshops.request.UserUpdateRequest;

public interface IUserService {
    User getUserById(Long userId);
    User createUser(CreateUserRequest userRequest);
    User updateUser(UserUpdateRequest request, Long userId);
    void deleteUser(Long userId);
}
