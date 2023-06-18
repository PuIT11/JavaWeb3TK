package laptrinhungdungjava.springsecurity.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
public class UserRoleId implements Serializable {
    @Column(name = "user_id")
    private Integer user;

    @Column(name = "role_id")
    private Integer role;
}

