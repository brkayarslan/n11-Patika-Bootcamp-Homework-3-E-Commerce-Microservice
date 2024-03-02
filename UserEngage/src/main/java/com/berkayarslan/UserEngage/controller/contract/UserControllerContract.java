package com.berkayarslan.UserEngage.controller.contract;

import com.berkayarslan.UserEngage.dto.UserDTO;
import com.berkayarslan.UserEngage.request.user.UserSaveRequest;
import com.berkayarslan.UserEngage.request.user.UserUpdateRequest;
import com.berkayarslan.UserEngage.request.user.UserUpdateStatusRequest;

import java.util.List;

public interface UserControllerContract {

    UserDTO saveUser(UserSaveRequest request);
    List<UserDTO> findAllUsers();
    UserDTO updateUser(UserUpdateRequest request);
    UserDTO updateUserStatus(UserUpdateStatusRequest request);
    UserDTO getUserById(Long id);
    void deleteCustomer(Long id);

}
