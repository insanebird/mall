package com;

import com.dao.ProductDao;
import com.dao.RetailerDao;
import com.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MallApplicationTests {
    @Autowired
    ProductDao productDao;
    @Autowired
    ProductService productService;
    @Autowired
    RetailerDao retailerDao;

    @Test
    void contextLoads() {
    }

}
