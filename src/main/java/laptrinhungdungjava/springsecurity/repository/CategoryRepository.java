package laptrinhungdungjava.springsecurity.repository;

import laptrinhungdungjava.springsecurity.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
