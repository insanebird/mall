package com.controller;

import com.entity.Category;
import com.entity.Option;
import com.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "/findAllCategory", method = RequestMethod.GET)
    public List<Category> findAllCategory() {
        return categoryService.findAllCategory();
    }

    @RequestMapping(value = "/findNestedCategory", method = RequestMethod.GET)
    public List<Option> findNestedCategory() {
        return categoryService.findNestedCategory();
    }
}