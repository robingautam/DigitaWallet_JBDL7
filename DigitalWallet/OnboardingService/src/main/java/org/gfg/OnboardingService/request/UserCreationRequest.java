package org.gfg.OnboardingService.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.gfg.enums.UserIdentifier;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserCreationRequest {

    private String name;
    private String email;
    private String mobileNo;
    private String password;
    private String dob;
    private UserIdentifier userIdentifier;
    private String userIdentifierValue;
}
