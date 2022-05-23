package pl.lukaszszawronski.inventoryapp.brand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.lukaszszawronski.inventoryapp.category.Category;
import pl.lukaszszawronski.inventoryapp.category.CategoryRepository;

import java.util.List;

@Controller
public class BrandController {

    @Autowired
    private BrandRepository brandRepo;

    @Autowired
    private CategoryRepository categoryRepo;

    @GetMapping("/brands/new")
    public String showCreateNewBrandForm(Model model){
        List<Category> listCategories = categoryRepo.findAll();
        model.addAttribute("listCategories", listCategories);
        model.addAttribute("brand", new Brand());
        return "brand_form";
    }
    @PostMapping("/brands/save")
    public String saveBrand(Brand brand){
        brandRepo.save(brand);

        return "redirect:/";
    }
    @GetMapping("/brands")
    public String listBrands(Model model){
        List<Brand> listBrands = brandRepo.findAll();
        model.addAttribute("listBrands", listBrands);
        return "brands";
    }
}
