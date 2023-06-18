package laptrinhungdungjava.springsecurity.repository;

import laptrinhungdungjava.springsecurity.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Long> {
}
