package org.gfg.OnboardingService.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.gfg.enums.UserIdentifier;
import org.gfg.enums.UserStatus;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(unique = true)
    private String email;

    @Column(unique = true, length = 13)
    private String mobileNo;

    private String password;

    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;

    private String dob;

    @Enumerated(EnumType.STRING)
    private UserIdentifier userIdentifier;

    @Column(unique = true)
    private String userIdentifierValue;

    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updatedOn;



}
