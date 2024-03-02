package com.berkayarslan.UserEngage.controller.contract.ımpl;

import com.berkayarslan.UserEngage.controller.contract.UserControllerContract;
import com.berkayarslan.UserEngage.dto.UserDTO;
import com.berkayarslan.UserEngage.mapper.UserMapper;
import com.berkayarslan.UserEngage.model.User;
import com.berkayarslan.UserEngage.request.user.UserSaveRequest;
import com.berkayarslan.UserEngage.request.user.UserUpdateRequest;
import com.berkayarslan.UserEngage.request.user.UserUpdateStatusRequest;
import com.berkayarslan.UserEngage.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserControllerContractImpl implements UserControllerContract {

    private final UserService userService;
    @Override
    public UserDTO saveUser(UserSaveRequest request) {
        User user = UserMapper.INSTANCE.userDTOToUser(request);
        user = userService.save(user);
        UserDTO userDTO = UserMapper.INSTANCE.userToUserDTO(user);
        return userDTO;
    }

    @Override
    public List<UserDTO> findAllUsers() {

        List<User> userList = userService.findAll();
        return UserMapper.INSTANCE.userListToUserDTOList(userList);
    }

    @Override
    public UserDTO updateUser(UserUpdateRequest request) {
        User user = userService.findByIdWithControl(request.id());
        UserMapper.INSTANCE.updateUserFields(user,request);
        userService.save(user);
        return UserMapper.INSTANCE.userToUserDTO(user);
    }

    @Override
    public UserDTO updateUserStatus(UserUpdateStatusRequest request) {

        return UserMapper.INSTANCE.userToUserDTO(userService.updateUser(request.id(),request.status()));
    }

    @Override
    public UserDTO getUserById(Long id) {
            User user = userService.findByIdWithControl(id);
            return UserMapper.INSTANCE.userToUserDTO(user);

    }

    @Override
    public void deleteCustomer(Long id) {
        userService.delete(id);
    }


}
