package laptrinhungdungjava.springsecurity.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.boot.autoconfigure.elasticsearch.ElasticsearchConnectionDetails;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_id;
    @Column
    private String username;
    @Column
    private String password;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "UserRole",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id"))
    private Set<Role> roles = new HashSet<>();
}



