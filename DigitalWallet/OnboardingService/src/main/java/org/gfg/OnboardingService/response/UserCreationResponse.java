package org.gfg.OnboardingService.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCreationResponse extends Response{
    String name;
    String email;
}
