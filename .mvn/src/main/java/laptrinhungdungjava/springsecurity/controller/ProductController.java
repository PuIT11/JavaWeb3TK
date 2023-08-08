package laptrinhungdungjava.springsecurity.controller;

import jakarta.validation.Valid;
import laptrinhungdungjava.springsecurity.entity.Product;
import laptrinhungdungjava.springsecurity.repository.ProductRepository;
import laptrinhungdungjava.springsecurity.services.CategoryService;
import laptrinhungdungjava.springsecurity.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Controller
@RequestMapping("/products")
@Secured({"SALES", "USER"})

public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    // phan trang
    @GetMapping("/search")
    public String searchProducts(Model model, @RequestParam String key,
                                 @RequestParam(defaultValue = "0") int pageNo,
                                 @RequestParam(defaultValue = "4") int pageSize)
    {
        Page<Product> products = productService.GetSearchProducts(key, pageNo, pageSize);
        int totalPages = products.getTotalPages();
        model.addAttribute("listproduct", products);
        model.addAttribute("totalPages", totalPages);
        return "products/index";
    }
    @GetMapping("")
    public String index(Model model,
                        @RequestParam(defaultValue = "0") int page,
                        @RequestParam(defaultValue = "4") int size)
    {
        Page<Product> products = productService.GetAll(page, size);
        model.addAttribute("listproduct", products);
        model.addAttribute("totalPages", products.getTotalPages());
        return "products/index";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model)
    {
        model.addAttribute("product", productService.get(id));
        model.addAttribute("listCategory", categoryService.GetAll() );
        return "/products/edit";
    }
    @PostMapping("/edit")
    public String edit(@Valid Product editProduct,
                       @RequestParam MultipartFile imageProduct,
                       BindingResult result,
                       Model model)
    {
        if (result.hasErrors()) {
            model.addAttribute("product", editProduct);
            model.addAttribute("listCategory", categoryService.GetAll() );
            return "/products/edit";
        }
        if(imageProduct != null && imageProduct.getSize() > 0)
        {
            try {
                File saveFile = new ClassPathResource("static/images").getFile();
                Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + editProduct.getImage());
                Files.copy(imageProduct.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        productService.edit(editProduct);
        return "redirect:/products";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") int id, Model model) {
        Product product = productService.get(id);
        model.addAttribute("product", product);
        return "products/detail";
    }

}
