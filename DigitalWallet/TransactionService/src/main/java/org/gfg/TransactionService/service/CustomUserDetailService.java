package org.gfg.TransactionService.service;

import org.gfg.util.CommonConstants;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.client.RestTemplate;

public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    RestTemplate restTemplate;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       String url = "http://localhost:8090/onboarding-service/user/details/"+username;

       String response = restTemplate.getForObject(url, String.class);
        System.out.println("Response: "+response);
       if (response==null){
           throw  new UsernameNotFoundException("user not found");
       }
        JSONObject responseObject = new JSONObject(response);
        String password = responseObject.getString(CommonConstants.USER_PASSWORD);

        UserDetails userDetails = User.builder().username(username).password(password).build();

        return userDetails;
    }
}
