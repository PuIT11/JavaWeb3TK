package laptrinhungdungjava.springsecurity.models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import laptrinhungdungjava.springsecurity.entity.Category;
import laptrinhungdungjava.springsecurity.entity.Product;
import lombok.Data;

@Data
public class CartItem {

    //Product info
    private Integer id;
    private String name;
    private String image;

    private long price;

    //Quantity
    private int quantity;

    public long getAmount() {
        return (long) quantity * price;
    }
}
