package com.service;

import com.dao.CategoryDao;
import com.entity.Category;
import com.entity.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryDao categoryDao;

    public List<Category> findAllCategory() {
        return categoryDao.findAllCategory();
    }

    public List<Option> findNestedCategory(Integer level) {
        List<Category> nestedCategory = categoryDao.findTopLevelCategory();
        List<Option> options = new ArrayList<>();
        if (level > 0) {
            for (Category category : nestedCategory) {
                Option option = new Option();
                option.setLabel(category.getCategoryName());
                option.setValue(category.getCategoryId());

                if (level > 1) {
                    List<Option> optionList = new ArrayList<>();
                    List<Category> nestedCategory1 = categoryDao.findNestedCategory(category.getCategoryId());
                    category.setList(nestedCategory1);
                    for (Category category1 : nestedCategory1) {
                        Option option1 = new Option();
                        option1.setLabel(category1.getCategoryName());
                        option1.setValue(category1.getCategoryId());

                        if (level > 2) {
                            List<Option> list = new ArrayList<>();
                            List<Category> nestedCategory2 = categoryDao.findNestedCategory(category1.getCategoryId());
                            for (Category category2 : nestedCategory2) {
                                Option option2 = new Option();
                                option2.setLabel(category2.getCategoryName());
                                option2.setValue(category2.getCategoryId());
                                list.add(option2);
                            }
                            option1.setChildren(list);
                        }
                        optionList.add(option1);


                    }
                    option.setChildren(optionList);
                }
                options.add(option);

            }
        }
        return options;
    }

    public void addCategory(Category category) {
        category.setLevel(category.getLevel() + 1);
        categoryDao.addCategory(category);
    }
}
