package laptrinhungdungjava.springsecurity.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity

public class Category {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer  id;
    @Column
    private String name;
}



