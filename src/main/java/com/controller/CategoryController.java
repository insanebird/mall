package com.controller;

import com.entity.Category;
import com.entity.Option;
import com.service.CategoryService;
import com.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;

    @RequestMapping(value = "/findAllCategory", method = RequestMethod.GET)
    public List<Category> findAllCategory() {
        return categoryService.findAllCategory();
    }

    @RequestMapping(value = "/findNestedCategory", method = RequestMethod.POST)
    public List<Option> findNestedCategory(@RequestBody Category category) {
        return categoryService.findNestedCategory(category.getLevel());
    }

    @RequestMapping(value = "/addCategory", method = RequestMethod.POST)
    public void addCategory(@RequestBody Category category) {
        categoryService.addCategory(category);
    }

    @RequestMapping(value = "/getSearchPanelCategory", method = RequestMethod.GET)
    public List<Category> getSearchPanelCategory() {
        return productService.getSearchPanelCategory();
    }
}