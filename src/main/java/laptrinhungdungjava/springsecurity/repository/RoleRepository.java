package laptrinhungdungjava.springsecurity.repository;

import laptrinhungdungjava.springsecurity.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String name);
}
