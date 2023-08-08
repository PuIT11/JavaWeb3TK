package laptrinhungdungjava.springsecurity.repository;

import laptrinhungdungjava.springsecurity.entity.OrdersDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrdersDetail, Long> {
}
