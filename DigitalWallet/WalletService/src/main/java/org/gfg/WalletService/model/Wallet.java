package org.gfg.WalletService.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.gfg.enums.UserIdentifier;
import org.gfg.enums.UserStatus;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "wallet")
@Builder
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private int userId;

    private String name;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String mobileNo;

    private double balance;

    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;
    private String userIdentificationNumber;

    @Enumerated(EnumType.STRING)
    private UserIdentifier userIdentifier;

    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updatedOn;
}
