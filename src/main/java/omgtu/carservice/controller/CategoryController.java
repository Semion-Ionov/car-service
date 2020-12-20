package omgtu.carservice.controller;

import com.google.gson.Gson;
import omgtu.carservice.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/getAllCategories")
    public String getAll() {
        return new Gson().toJson(categoryService.getAll());
    }
}
