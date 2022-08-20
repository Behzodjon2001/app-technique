package com.company.entity;

import com.company.enums.ProfileRole;
import com.company.enums.ProfileStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "profile")
public class ProfileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column
    private String surname;

    @Column()
    private String email;

    @Column
    private String phone;

    @Column(nullable = false)
    private String password;

    @Column
    @Enumerated(EnumType.STRING)
    private ProfileStatus status=ProfileStatus.ACTIVE;

    @Column
    @Enumerated(EnumType.STRING)
    private ProfileRole role;

    @Column
    private Boolean visible=true;

    @Column(name = "created_date")
    private LocalDateTime createdDate = LocalDateTime.now();

    public ProfileEntity() {
    }

    public ProfileEntity(Integer id) {
        this.id = id;
    }
}
