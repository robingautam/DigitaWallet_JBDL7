package org.gfg.OnboardingService.controller;

import org.gfg.OnboardingService.model.User;
import org.gfg.OnboardingService.request.UserCreationRequest;
import org.gfg.OnboardingService.response.UserCreationResponse;
import org.gfg.OnboardingService.service.UserService;
import org.gfg.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/onboarding-service")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/create/user")
    public ResponseEntity<UserCreationResponse> onboardUser(@RequestBody UserCreationRequest userCreationRequest){
        System.out.println(userCreationRequest);
         UserCreationResponse userCreationResponse = new UserCreationResponse();
        userCreationResponse.setCode("02");
        if (StringUtil.isBlank(userCreationRequest.getEmail())){
            userCreationResponse.setMessage("Email cannot be blank");
            return new ResponseEntity<>(userCreationResponse, HttpStatus.OK);
        }else if (StringUtil.isBlank(userCreationRequest.getMobileNo())){
            userCreationResponse.setMessage("Mobile cannot be blank");
            return new ResponseEntity<>(userCreationResponse, HttpStatus.OK);
        }
        else if (StringUtil.isBlank(userCreationRequest.getUserIdentifierValue()) || StringUtil.isBlank(userCreationRequest.getPassword())){
            userCreationResponse.setMessage("Invalid Request");
            return new ResponseEntity<>(userCreationResponse, HttpStatus.BAD_REQUEST);
        }
        else {
            User user = userService.createNewUser(userCreationRequest);
            if (user==null){
                userCreationResponse.setMessage("User Not Created");
                userCreationResponse.setCode("02");
            }
            userCreationResponse.setEmail(user.getEmail());
            userCreationResponse.setName(user.getName());
            userCreationResponse.setCode("00");
        }

        return new ResponseEntity<>(userCreationResponse, HttpStatus.CREATED);
    }


    @GetMapping("/user/details/{userId}")
    public String getUserDetails(@PathVariable("userId") String username){
        return userService.findUserByUsername(username);
    }
}
