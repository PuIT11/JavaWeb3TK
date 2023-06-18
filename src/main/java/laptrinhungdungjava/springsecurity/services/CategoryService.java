package laptrinhungdungjava.springsecurity.services;

import laptrinhungdungjava.springsecurity.entity.Category;
import laptrinhungdungjava.springsecurity.entity.Product;
import laptrinhungdungjava.springsecurity.repository.CategoryRepository;
import laptrinhungdungjava.springsecurity.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    public List<Category> GetAll() {
        return categoryRepository.findAll();
    }
}
