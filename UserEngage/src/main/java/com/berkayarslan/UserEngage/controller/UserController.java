package com.berkayarslan.UserEngage.controller;

import com.berkayarslan.UserEngage.controller.contract.UserControllerContract;
import com.berkayarslan.UserEngage.dto.UserDTO;
import com.berkayarslan.UserEngage.general.RestResponse;
import com.berkayarslan.UserEngage.request.user.UserSaveRequest;
import com.berkayarslan.UserEngage.request.user.UserUpdateRequest;
import com.berkayarslan.UserEngage.request.user.UserUpdateStatusRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {


  private UserControllerContract userControllerContract;

    public UserController(UserControllerContract userControllerContract) {
        this.userControllerContract = userControllerContract;
    }

    @GetMapping
    public ResponseEntity<RestResponse<List<UserDTO>>> findAllUsers(){
        List<UserDTO> allUsers = userControllerContract.findAllUsers();
        return ResponseEntity.ok(RestResponse.of(allUsers));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestResponse<UserDTO>> findUserByUserId(@PathVariable Long id){
        UserDTO userDTO = userControllerContract.getUserById(id);
        return ResponseEntity.ok(RestResponse.of(userDTO));
    }

    @PostMapping
    public ResponseEntity<RestResponse<UserDTO>> saveUser(@RequestBody UserSaveRequest request){
        UserDTO userDTO = userControllerContract.saveUser(request);
        return ResponseEntity.ok(RestResponse.of(userDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestResponse<UserDTO>> updateUser(@PathVariable Long id,@RequestBody UserUpdateRequest request){
        UserDTO userDTO = userControllerContract.updateUser(request);
        return ResponseEntity.ok(RestResponse.of(userDTO));
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userControllerContract.deleteCustomer(id);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<RestResponse<UserDTO>> updateStatusById(@PathVariable Long id, @RequestBody UserUpdateStatusRequest request){
        UserDTO userDTO = userControllerContract.updateUserStatus(request);
        return ResponseEntity.ok(RestResponse.of(userDTO));
    }

}
